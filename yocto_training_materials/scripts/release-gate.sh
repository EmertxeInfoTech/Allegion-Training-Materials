#!/bin/bash
# release-gate.sh (D3S9)
# Chain the quality gates into one pass. Run from a sourced build environment.
# Fails fast on the first gate that trips. Customize IMAGE and paths for your setup.
set -euo pipefail

IMAGE="${IMAGE:-trainergw-image}"
MACHINE_DIR="tmp/deploy/images/${MACHINE:-qemux86-64}"
SPDX_DIR="tmp/deploy/spdx"
CVE_DIR="tmp/deploy/cve"
LIC_DIR="tmp/deploy/licenses"

step() { echo; echo "==== $1 ===="; }

step "[1/6] Build image (QA enforcement via ERROR_QA)"
bitbake "$IMAGE"

step "[2/6] Run testimage (boots image in QEMU, runs test cases)"
bitbake "$IMAGE" -c testimage

step "[3/6] Confirm SBOM was generated"
if ls "${SPDX_DIR}"/*/"${IMAGE}"*.spdx.json >/dev/null 2>&1 || \
   ls "${SPDX_DIR}"/"${IMAGE}"*.spdx.json >/dev/null 2>&1; then
    echo "  SBOM present."
else
    echo "  FAIL: no SBOM found. Add: INHERIT += \"create-spdx\""; exit 1
fi

step "[4/6] CVE gate (unpatched HIGH/CRITICAL)"
CVE_JSON=$(ls "${CVE_DIR}"/"${IMAGE}"*.json 2>/dev/null | head -n1 || true)
if [ -n "${CVE_JSON}" ]; then
    ./cve-gate.sh "${CVE_JSON}" 7.0
else
    echo "  WARN: no CVE JSON found. Add: INHERIT += \"cve-check\""
fi

step "[5/6] License manifest present"
if ls "${LIC_DIR}"/"${IMAGE}"*/license.manifest >/dev/null 2>&1; then
    echo "  License manifest present."
else
    echo "  FAIL: no license manifest. Check license tooling."; exit 1
fi

step "[6/6] Done"
echo "PASS: all release gates green for ${IMAGE}."

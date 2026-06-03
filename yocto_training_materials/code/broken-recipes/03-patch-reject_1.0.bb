# BROKEN #3: patch does not apply
# Symptom: ERROR: ... patch ... FAILED / Hunk #1 FAILED
SUMMARY = "Broken recipe: stale patch"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "https://busybox.net/downloads/busybox-1.36.1.tar.bz2 \
           file://0001-stale.patch"
SRC_URI[sha256sum] = "b8cc24c9574d809e7279c3be349795c5d5ceb6fdf19ca709f80cde50e47de314"

S = "${WORKDIR}/busybox-1.36.1"

# FIX: the patch was written for an older version and no longer applies.
# Drop into devshell:   bitbake <recipe> -c devshell
# Re-apply by hand:     git apply --3way ../0001-stale.patch
# Resolve conflicts, then regenerate: git format-patch -1
# Replace the patch file in files/.

# Security hardening defaults for Allegion distro

# --- Compiler hardening ---
# Apply hardening flags to all compiled packages
require conf/distro/include/security_flags.inc

# --- License policy ---
# Refuse GPL-3.0 family if your product forbids it (anti-tivoization).
# Uncomment if your product policy requires it:
# INCOMPATIBLE_LICENSE = "GPL-3.0-or-later GPL-3.0-only AGPL-3.0-or-later"

# --- CVE checking ---
# Enable CVE scanning on every build (see License/SBOM/CVE study guide)
INHERIT += "cve-check"

# --- SBOM generation ---
# Generate SPDX SBOM for every image (see License/SBOM/CVE study guide)
INHERIT += "create-spdx"

# --- No empty passwords, no debug-tweaks leakage in production ---
# (debug-tweaks is controlled per-image, not here)

# SPDX license declaration examples (D3S7)
# Drop any of these LICENSE lines into a recipe. Use SPDX identifiers, never
# free-text like "GPL" (which version? only or later?).
# Full list: https://spdx.org/licenses/

# --- Single license ---
# LICENSE = "MIT"
# LICENSE = "GPL-2.0-only"
# LICENSE = "GPL-2.0-or-later"
# LICENSE = "Apache-2.0"
# LICENSE = "BSD-3-Clause"
# LICENSE = "LGPL-2.1-or-later"

# --- Combinations ---
# Both licenses apply (AND):
# LICENSE = "GPL-2.0-or-later & LGPL-3.0-or-later"
# Either license may be chosen (OR):
# LICENSE = "GPL-2.0-or-later | MIT"

# --- Per-package licensing (different packages, different licenses) ---
# LICENSE:${PN}       = "MIT"
# LICENSE:${PN}-tools = "GPL-2.0-only"

# --- Always pair LICENSE with a checksum of the license file(s) ---
# LIC_FILES_CHKSUM = "file://LICENSE;md5=<md5-of-the-file>"
# Multiple files:
# LIC_FILES_CHKSUM = "\
#     file://LICENSE;md5=... \
#     file://COPYING;md5=... \
#     file://src/header.h;beginline=1;endline=20;md5=... \
#     "

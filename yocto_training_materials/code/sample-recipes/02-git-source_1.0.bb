# PATTERN 2: Git source at a fixed revision
# Use SRCREV to pin an exact commit. PV embeds the git revision.
SUMMARY = "Example recipe: build from a git repository"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=<fill-in-after-first-fetch>"

# protocol=https is required by most public forges now.
SRC_URI = "git://github.com/example/mytool.git;branch=main;protocol=https"

# Pin the exact commit. Never track a moving branch in production.
SRCREV = "a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6e7f8a9b0"

PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake

# DEPENDS = build-time. Adjust to the project's needs.
DEPENDS = "zlib"

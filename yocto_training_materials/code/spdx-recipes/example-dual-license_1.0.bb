# Worked example: a recipe with a dual license and per-file checksums (D3S7)
SUMMARY = "Example showing SPDX dual licensing"
HOMEPAGE = "https://example.org/lib"

# Either GPL-2.0-or-later OR MIT, at the user's choice.
LICENSE = "GPL-2.0-or-later | MIT"

LIC_FILES_CHKSUM = "\
    file://COPYING.GPL;md5=<md5-of-gpl> \
    file://COPYING.MIT;md5=<md5-of-mit> \
    "

SRC_URI = "https://example.org/lib/lib-${PV}.tar.gz"
SRC_URI[sha256sum] = "<sha256-of-the-tarball>"

inherit autotools

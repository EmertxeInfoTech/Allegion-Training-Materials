SUMMARY = "GNU Hello, a friendly greeting program"
DESCRIPTION = "GNU Hello prints 'Hello, world!' and serves as the canonical \
GNU autotools example. Used here to demonstrate an autotools recipe."
HOMEPAGE = "https://www.gnu.org/software/hello/"
SECTION = "examples"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "${GNU_MIRROR}/hello/hello-${PV}.tar.gz"
# NOTE: verify this on first build. If wrong, bitbake prints the real value.
# Start with a wrong value and let bitbake tell you the correct one:
#   SRC_URI[sha256sum] = "0000...0000"
SRC_URI[sha256sum] = "8d99142afd92576f30b0cd7cb42a8dc6809998bc5d607d88761f512e26c7db20"

inherit autotools gettext

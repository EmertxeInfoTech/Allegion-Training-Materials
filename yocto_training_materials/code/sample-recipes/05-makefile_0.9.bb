# PATTERN 5: Plain Makefile project (no autotools/cmake)
# You must pass the cross compiler explicitly and do the install yourself.
SUMMARY = "Example recipe: project with a hand-written Makefile"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=<fill-in>"

SRC_URI = "https://example.org/tinytool/tinytool-${PV}.tar.gz"
SRC_URI[sha256sum] = "<sha256-of-the-tarball>"

S = "${WORKDIR}/tinytool-${PV}"

# oe_runmake passes the cross CC, CFLAGS, LDFLAGS from the environment.
do_compile() {
    oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}"
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/tinytool ${D}${bindir}/tinytool
}

FILES:${PN} = "${bindir}/tinytool"

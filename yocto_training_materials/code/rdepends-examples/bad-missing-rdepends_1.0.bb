# BAD EXAMPLE - missing RDEPENDS
# This recipe installs a Python script but never declares that the target
# needs a Python interpreter. It builds fine and the package installs fine.
# On the device it fails at runtime: "python3: not found".
SUMMARY = "Python health-check daemon (BROKEN - missing RDEPENDS)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://healthcheck.py"
S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/healthcheck.py ${D}${bindir}/healthcheck
}

FILES:${PN} = "${bindir}/healthcheck"

# BUG: nothing here. The script needs python3 at runtime.
# RDEPENDS:${PN} = "python3-core"   <-- this line is missing

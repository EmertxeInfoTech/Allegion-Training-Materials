# GOOD EXAMPLE - correct RDEPENDS
# Same recipe, but it correctly declares its runtime dependencies.
SUMMARY = "Python health-check daemon (correct RDEPENDS)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://healthcheck.py"
S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/healthcheck.py ${D}${bindir}/healthcheck
}

FILES:${PN} = "${bindir}/healthcheck"

# CORRECT: the script needs the Python 3 interpreter and the requests module
# on the target at runtime. Without these, install succeeds but execution fails.
RDEPENDS:${PN} = "python3-core python3-requests"

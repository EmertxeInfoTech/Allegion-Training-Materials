# BROKEN #4: installed but not shipped (FILES mismatch)
# Symptom: WARNING/ERROR: ... files installed but not shipped in any package
SUMMARY = "Broken recipe: FILES does not cover installed files"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://app.sh file://app.conf"
S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/app.sh ${D}${bindir}/app
    # We also install a config file:
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/app.conf ${D}${sysconfdir}/app.conf
}

# BUG: FILES only lists the binary, not the config we installed in /etc.
FILES:${PN} = "${bindir}/app"

# FIX: add the config to FILES:
#   FILES:${PN} = "${bindir}/app ${sysconfdir}/app.conf"

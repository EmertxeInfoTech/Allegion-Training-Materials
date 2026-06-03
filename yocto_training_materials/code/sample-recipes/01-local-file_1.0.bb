# PATTERN 1: Local file source
# Simplest case - ship a file that lives next to the recipe.
SUMMARY = "Example recipe: install a local script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://my-tool.sh"
S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/my-tool.sh ${D}${bindir}/my-tool
}

FILES:${PN} = "${bindir}/my-tool"

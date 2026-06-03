SUMMARY = "Tiny hello-world program for the TrainerGW image"
DESCRIPTION = "The smallest possible custom recipe: installs a shell script \
that prints a greeting. Used in Day 1 to prove the layer-recipe-image flow."
HOMEPAGE = "https://www.emertxe.com"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello-trainergw"

# No source to compile; just a script to install.
S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/hello-trainergw ${D}${bindir}/hello-trainergw
}

# Explicitly own the file we ship (keeps the QA check happy).
FILES:${PN} = "${bindir}/hello-trainergw"

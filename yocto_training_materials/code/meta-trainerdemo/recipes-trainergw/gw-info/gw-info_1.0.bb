SUMMARY = "Print basic device information (kernel, uptime, IP)"
DESCRIPTION = "Day 1 verification task. Installs a script that reports the \
kernel version, uptime, and primary IP address of the device."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://gw-info"
S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/gw-info ${D}${bindir}/gw-info
}

FILES:${PN} = "${bindir}/gw-info"

# gw-info uses 'ip' at runtime; make sure it is present on the target.
RDEPENDS:${PN} = "iproute2"

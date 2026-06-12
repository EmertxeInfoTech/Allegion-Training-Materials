SUMMARY = "Allegion example daemon managed by systemd"
DESCRIPTION = "A minimal C daemon demonstrating local-source build, systemd \
service integration, and unprivileged operation."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://mydaemon.c \
    file://Makefile \
    file://mydaemon.service \
"

S = "${WORKDIR}"

inherit systemd

SYSTEMD_SERVICE:${PN} = "mydaemon.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

# Create an unprivileged user for the daemon (no login shell)
inherit useradd
USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "-r -s /usr/sbin/nologin mydaemon"

do_compile() {
    oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}"
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 mydaemon ${D}${bindir}/mydaemon

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/mydaemon.service ${D}${systemd_system_unitdir}/
}

FILES:${PN} += "${systemd_system_unitdir}/mydaemon.service"

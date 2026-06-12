# Allegion journald configuration: persistent, capped logs

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://allegion-journald.conf"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/journald.conf.d
    install -m 0644 ${WORKDIR}/allegion-journald.conf \
        ${D}${sysconfdir}/systemd/journald.conf.d/allegion.conf
}

FILES:${PN} += "${sysconfdir}/systemd/journald.conf.d/allegion.conf"

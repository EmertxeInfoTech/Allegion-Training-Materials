# Allegion SSH hardening: replace sshd_config with a hardened version

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://sshd_config_hardened"

do_install:append() {
    # Overwrite the default sshd_config with our hardened version
    install -m 0600 ${WORKDIR}/sshd_config_hardened \
        ${D}${sysconfdir}/ssh/sshd_config
}

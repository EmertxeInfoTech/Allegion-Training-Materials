# Allegion kernel customizations: KSPP hardening + custom config

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://kspp-hardening.cfg"

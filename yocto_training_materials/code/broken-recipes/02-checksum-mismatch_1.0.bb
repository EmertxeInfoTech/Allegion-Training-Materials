# BROKEN #2: checksum mismatch
# Symptom: ERROR: ... sha256 checksum does not match
SUMMARY = "Broken recipe: wrong checksum"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "https://busybox.net/downloads/busybox-1.36.1.tar.bz2"
# BUG: this checksum is wrong on purpose.
SRC_URI[sha256sum] = "deadbeefdeadbeefdeadbeefdeadbeefdeadbeefdeadbeefdeadbeefdeadbeef0"

S = "${WORKDIR}/busybox-1.36.1"

# FIX: BitBake prints the correct sha256 in the error. Paste it in. The real
# value for busybox-1.36.1 is:
#   b8cc24c9574d809e7279c3be349795c5d5ceb6fdf19ca709f80cde50e47de314

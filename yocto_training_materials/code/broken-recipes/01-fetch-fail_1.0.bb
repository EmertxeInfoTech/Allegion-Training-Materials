# BROKEN #1: fetch failure (wrong URL)
# Symptom: ERROR: Fetcher failure ... 404 Not Found
SUMMARY = "Broken recipe: bad SRC_URI"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# BUG: this path does not exist on the server.
SRC_URI = "https://busybox.net/downloads/busybox-9.9.9.tar.bz2"
SRC_URI[sha256sum] = "0000000000000000000000000000000000000000000000000000000000000000"

S = "${WORKDIR}/busybox-9.9.9"

# FIX: use a real version that exists, e.g. busybox-1.36.1.tar.bz2, and set the
# correct sha256sum (run: bitbake <recipe> -c fetch after fixing the URL, or
# sha256sum the downloaded tarball).

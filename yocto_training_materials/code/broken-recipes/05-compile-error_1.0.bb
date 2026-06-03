# BROKEN #5: compile failure (missing build dependency)
# Symptom: fatal error: openssl/sha.h: No such file or directory
SUMMARY = "Broken recipe: missing DEPENDS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hashit.c"
S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/hashit.c -o ${WORKDIR}/hashit -lcrypto
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/hashit ${D}${bindir}/hashit
}

FILES:${PN} = "${bindir}/hashit"

# BUG: hashit.c includes <openssl/sha.h> and links -lcrypto, but we never
# declared the build dependency, so the headers/libs aren't in the sysroot.
# FIX: add the build dependency:
#   DEPENDS = "openssl"
# And the runtime dependency so the shared lib ships:
#   RDEPENDS:${PN} = "libcrypto"

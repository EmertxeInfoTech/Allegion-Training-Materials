SUMMARY = "Base packages common to all Allegion images"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    systemd \
    systemd-analyze \
    util-linux \
    nftables \
    iproute2 \
    openssl \
    ca-certificates \
"

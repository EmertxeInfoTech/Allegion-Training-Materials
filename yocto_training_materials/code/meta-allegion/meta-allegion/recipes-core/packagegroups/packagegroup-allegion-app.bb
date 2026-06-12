SUMMARY = "Allegion application stack"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    mydaemon \
    hello \
"

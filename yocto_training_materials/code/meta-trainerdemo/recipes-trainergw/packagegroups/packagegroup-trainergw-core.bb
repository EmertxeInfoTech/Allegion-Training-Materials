SUMMARY = "Core packages for the TrainerGW image"
DESCRIPTION = "Bundles the runtime packages that define a TrainerGW device, \
so the image recipe only needs to install one name."

# Packagegroups are architecture-independent in content but are tied to the
# machine because the set of packages can vary per machine.
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# The packages that make up a 'core' TrainerGW device.
RDEPENDS:${PN} = "\
    hello-trainergw \
    gw-info \
    openssh-sshd \
    chrony \
    iptables \
    iproute2 \
    "

# Optional extras kept in a separate sub-packagegroup so images can opt in.
RDEPENDS:${PN}-extras = "\
    htop \
    strace \
    tcpdump \
    "

PACKAGES = "${PN} ${PN}-extras"

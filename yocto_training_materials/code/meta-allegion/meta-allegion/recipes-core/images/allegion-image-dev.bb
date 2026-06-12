SUMMARY = "Allegion development image (debug tools, SSH, writable rootfs)"
LICENSE = "MIT"

require allegion-image-base.inc

# Development conveniences
IMAGE_FEATURES += "debug-tweaks tools-debug ssh-server-openssh package-management"

# Developer tools
IMAGE_INSTALL:append = " \
    packagegroup-allegion-app \
    htop \
    strace \
    tcpdump \
    nano \
    gdb \
    gdbserver \
    smem \
    sysstat \
    iotop \
"

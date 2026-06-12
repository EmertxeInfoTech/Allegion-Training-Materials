SUMMARY = "Allegion production image (hardened, read-only rootfs, no debug tools)"
LICENSE = "MIT"

require allegion-image-base.inc

# Production hardening
IMAGE_FEATURES += "read-only-rootfs splash"
# NOTE: deliberately NO debug-tweaks, NO tools-debug, NO always-on SSH

# Only the application stack
IMAGE_INSTALL:append = " \
    packagegroup-allegion-app \
    chrony \
    ca-certificates \
"

# Aggressive cleanup for smaller image
IMAGE_FSTYPES = "wic.bz2 wic.bmap tar.bz2"

SUMMARY = "TrainerGW reference image"
DESCRIPTION = "The product image carried through the training. Starts from \
core-image-base and layers on the TrainerGW packagegroup."
LICENSE = "MIT"

# Start from a known, small-but-useful base.
require recipes-core/images/core-image-base.bb

# Add our core package set.
IMAGE_INSTALL:append = " packagegroup-trainergw-core"

# Developer conveniences (remove debug-tweaks for production images!).
IMAGE_FEATURES += "ssh-server-openssh"
EXTRA_IMAGE_FEATURES ?= "debug-tweaks"

# Give the rootfs a little headroom (in KB).
IMAGE_ROOTFS_EXTRA_SPACE = "131072"

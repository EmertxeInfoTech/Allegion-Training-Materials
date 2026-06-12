# Shared base for Allegion images (dev and prod both require this)

inherit core-image

# Core functionality every Allegion image needs
IMAGE_INSTALL = " \
    packagegroup-core-boot \
    packagegroup-allegion-base \
"

# Locale: none, to keep image small (add specific ones if needed)
IMAGE_LINGUAS = ""

# Output: rootfs tarball + full SD card image
IMAGE_FSTYPES = "tar.bz2 wic.bz2 wic.bmap"

# Breathing room in the rootfs
IMAGE_ROOTFS_EXTRA_SPACE = "65536"

# Use our partition layout
WKS_FILE = "allegion-sdimage.wks"

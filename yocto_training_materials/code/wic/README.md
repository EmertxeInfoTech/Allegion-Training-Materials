# WIC Kickstart Layouts (D3S4/D3S5)

Three partition layouts for different product needs.

| File | Layout | When to use |
|------|--------|-------------|
| trainergw-simple.wks | boot + rootfs | Bring-up, lab, prototypes |
| trainergw-ab.wks | boot + rootfs_a + rootfs_b + data | Fielded products with OTA |
| trainergw-ro-overlay.wks | boot + RO root + overlay + data | Tamper-evident, easy factory reset |

Wire one into your build:

    WKS_FILE = "trainergw-ab.wks"
    IMAGE_FSTYPES += "wic wic.bz2 wic.bmap"

Build and inspect:

    bitbake trainergw-image
    fdisk -l tmp/deploy/images/<machine>/trainergw-image-*.wic
    bmaptool copy <image>.wic.bz2 /dev/sdX     # flash (faster than dd)

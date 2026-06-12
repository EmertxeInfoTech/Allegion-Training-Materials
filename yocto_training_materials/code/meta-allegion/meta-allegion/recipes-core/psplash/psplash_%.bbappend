# Allegion custom boot splash
# Drop a generated psplash-poky-img.h in files/ to override the default logo.
# Generate it with: make-image-header.sh yourlogo.png POKY
#
# FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
# SRC_URI += "file://psplash-poky-img.h"
#
# (Left commented because it needs your actual logo image. See Yocto
#  Advanced Practical Topics, splash screen section.)

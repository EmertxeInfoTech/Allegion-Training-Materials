# Append to the linux-yocto kernel recipe to add our config fragments.
#
# This single bbappend wires in BOTH:
#   features.cfg   (D2S4 - enable hardware features)
#   hardening.cfg  (D3S2 - KSPP-recommended hardening)
#
# Fragments are layered on top of the kernel defconfig. They survive kernel
# version upgrades, unlike hand-edited defconfigs.

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://features.cfg \
            file://hardening.cfg \
            "

# Only apply our fragments for the machines we own. Adjust as needed.
# (Remove the override to apply everywhere.)

# Sample machine.conf (D2S4)

`trainergw-board.conf` is a template machine configuration for a Cortex-A72
gateway. In a real BSP this lives at:

    meta-yourbsp/conf/machine/trainergw-board.conf

Build for it with:

    MACHINE = "trainergw-board" bitbake trainergw-image

The real values (tune file, devicetree name, boot args, partition layout) come
from your SoC vendor's reference manual and BSP. This file shows the shape and
the variables that matter, not values for any specific silicon.

# meta-allegion

Custom Yocto distribution layer for Allegion embedded products.

## What this layer provides

- A custom distro (`allegion`) with systemd as init, security hardening,
  CVE checking, and SBOM generation enabled.
- Dev and production image recipes.
- A KSPP-hardened kernel config fragment.
- A hardened sshd_config.
- Persistent, capped journald logging.
- An example systemd-managed daemon (`mydaemon`) running unprivileged.
- The GNU hello autotools example recipe.
- A 4-partition A/B-ready WIC layout.
- Runtime tests for `bitbake <image> -c testimage`.

## Dependencies

- poky (meta, meta-poky)
- For a real board BSP: e.g. meta-raspberrypi (+ meta-openembedded)

All layers must be on the same branch (kirkstone or scarthgap).

## Quick start

    # 1. Clone alongside poky
    git clone .../meta-allegion

    # 2. Add the layer
    bitbake-layers add-layer ../meta-allegion

    # 3. Select the distro and machine (in conf/local.conf)
    echo 'DISTRO = "allegion"'      >> conf/local.conf
    echo 'MACHINE = "raspberrypi3"' >> conf/local.conf

    # 4. Build
    bitbake allegion-image-dev      # development
    bitbake allegion-image-prod     # production

## Verify systemd is PID 1 on target

    ps -p 1 -o comm=     # should print: systemd

## Directory structure

    meta-allegion/
    ├── conf/
    │   ├── layer.conf                       # layer declaration
    │   └── distro/
    │       ├── allegion.conf                # the custom distro
    │       └── include/
    │           ├── allegion-systemd.inc     # INIT_MANAGER = systemd
    │           └── allegion-security.inc    # CVE, SBOM, hardening flags
    ├── recipes-core/
    │   ├── images/
    │   │   ├── allegion-image-base.inc      # shared image base
    │   │   ├── allegion-image-dev.bb        # dev image
    │   │   └── allegion-image-prod.bb       # prod image
    │   ├── packagegroups/
    │   │   ├── packagegroup-allegion-base.bb
    │   │   └── packagegroup-allegion-app.bb
    │   ├── systemd/
    │   │   └── systemd_%.bbappend           # persistent journald
    │   └── psplash/
    │       └── psplash_%.bbappend           # custom splash (placeholder)
    ├── recipes-kernel/linux/
    │   ├── linux-yocto_%.bbappend           # adds KSPP fragment
    │   └── files/kspp-hardening.cfg         # KSPP config
    ├── recipes-connectivity/openssh/
    │   ├── openssh_%.bbappend               # hardened sshd
    │   └── files/sshd_config_hardened
    ├── recipes-example/
    │   ├── hello/hello_2.12.1.bb            # autotools example
    │   └── mydaemon/                        # custom systemd daemon
    │       ├── mydaemon_1.0.bb
    │       └── files/{mydaemon.c,Makefile,mydaemon.service}
    ├── wic/
    │   ├── allegion-sdimage.wks             # 4-partition A/B layout
    │   └── allegion-simple.wks              # 2-partition starter
    └── lib/oeqa/runtime/cases/allegion.py   # runtime tests

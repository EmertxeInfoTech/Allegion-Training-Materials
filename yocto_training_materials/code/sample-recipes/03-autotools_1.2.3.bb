# PATTERN 3: autotools project (configure / make / make install)
# 'inherit autotools' gives you do_configure/do_compile/do_install for free.
SUMMARY = "Example recipe: classic autotools tarball"
HOMEPAGE = "https://example.org/widget"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=<fill-in>"

SRC_URI = "https://example.org/widget/widget-${PV}.tar.gz"
SRC_URI[sha256sum] = "<sha256-of-the-tarball>"

inherit autotools pkgconfig

DEPENDS = "glib-2.0 dbus"

# Pass extra configure flags if needed:
EXTRA_OECONF = "--disable-static --enable-systemd"

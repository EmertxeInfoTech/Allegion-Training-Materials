# PATTERN 4: CMake project
# 'inherit cmake' handles the out-of-tree build directory and toolchain file.
SUMMARY = "Example recipe: CMake-based project"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=<fill-in>"

SRC_URI = "https://example.org/engine/engine-${PV}.tar.xz"
SRC_URI[sha256sum] = "<sha256-of-the-tarball>"

inherit cmake

DEPENDS = "boost openssl"

# CMake cache variables go in EXTRA_OECMAKE:
EXTRA_OECMAKE = "-DBUILD_TESTING=OFF -DENABLE_DOCS=OFF"

# busybox-ptest.bbappend (D3S9)
# Example of enabling ptest for a recipe. ptest packages a recipe's own test
# suite so it can be run on the target with ptest-runner.
#
# Many oe-core recipes already define a do_install_ptest; for those you only
# need to ensure ptest is in your DISTRO_FEATURES and the image. This append
# shows the recipe-side switch.

# Turn on ptest for this recipe build.
PTEST_ENABLED = "1"

# If a recipe does NOT already provide ptest, you implement two things:
#   1. do_install_ptest() - install the test scripts/binaries under
#      ${D}${PTEST_PATH} (which is /usr/lib/<pn>/ptest)
#   2. a run-ptest script at ${PTEST_PATH}/run-ptest that emits
#      "PASS: <name>" / "FAIL: <name>" lines.
#
# Example skeleton (uncomment and adapt for a recipe without built-in ptest):
#
# inherit ptest
#
# SRC_URI += "file://run-ptest"
#
# do_install_ptest() {
#     install -d ${D}${PTEST_PATH}/tests
#     install -m 0755 ${S}/tests/* ${D}${PTEST_PATH}/tests/
# }
#
# To get ptests into your image:
#   DISTRO_FEATURES:append = " ptest"
#   IMAGE_FEATURES += "ptest-pkgs"
#
# Then on the target:
#   ptest-runner busybox      # run one
#   ptest-runner              # run all installed ptests

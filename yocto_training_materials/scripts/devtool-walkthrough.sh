#!/bin/bash
# devtool-walkthrough.sh (D3S6)
# A guided, COMMENTED walkthrough of the devtool modify/build/deploy/finish loop.
# This is meant to be read and run step by step, NOT executed blindly.
# Run inside a sourced build environment:  source poky/oe-init-build-env build
set -e

echo "This script is a guided walkthrough. Read each step; run them yourself."
echo "Press Ctrl-C to stop at any point."
echo

cat <<'STEPS'
# ---------------------------------------------------------------------------
# STEP 1 - ADD a new recipe from an upstream source
# ---------------------------------------------------------------------------
devtool add https://github.com/example/mytool/archive/v1.0.tar.gz
#  -> creates a recipe AND checks out the source into
#     build/workspace/sources/mytool/
#  Inspect what it made:
devtool status
ls workspace/sources/mytool

# ---------------------------------------------------------------------------
# STEP 2 - MODIFY an existing recipe's source
# ---------------------------------------------------------------------------
devtool modify busybox
#  -> extracts busybox source into workspace/sources/busybox as a git tree.
#  Edit files there, commit your changes with git as you go.

# ---------------------------------------------------------------------------
# STEP 3 - BUILD what you changed
# ---------------------------------------------------------------------------
devtool build busybox

# ---------------------------------------------------------------------------
# STEP 4 - DEPLOY straight to a running target (dev iteration)
# ---------------------------------------------------------------------------
devtool deploy-target busybox root@192.168.1.42
#  Undo it later with:
#  devtool undeploy-target busybox root@192.168.1.42

# ---------------------------------------------------------------------------
# STEP 5 - FINISH: turn your edits into patches + update the recipe in a layer
# ---------------------------------------------------------------------------
devtool finish busybox ../meta-trainerdemo
#  -> generates patches from your git commits and writes a .bbappend/.bb update
#     into meta-trainerdemo. Your work is now persisted in the layer.

# ---------------------------------------------------------------------------
# To abandon work in progress without finishing:
# ---------------------------------------------------------------------------
devtool reset busybox
STEPS

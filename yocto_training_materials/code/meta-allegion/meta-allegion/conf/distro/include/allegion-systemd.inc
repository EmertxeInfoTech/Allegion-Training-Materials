# systemd init configuration for Allegion distro
#
# This is the COMPLETE, conflict-free way to enable systemd.
# Using INIT_MANAGER sets all interdependent variables correctly
# in one place, avoiding the cascade of errors that comes from
# setting DISTRO_FEATURES / VIRTUAL-RUNTIME_* manually and missing one.

# The modern one-liner (Yocto 3.1 / dunfell and later).
# Expands internally to:
#   - add "systemd" to DISTRO_FEATURES
#   - VIRTUAL-RUNTIME_init_manager = "systemd"
#   - DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
#   - VIRTUAL-RUNTIME_initscripts = ""
INIT_MANAGER = "systemd"

# Use systemd-journald for logging (no separate syslog by default).
# Set to "systemd" to also pull in a syslog-compatible path if needed.
VIRTUAL-RUNTIME_syslog ?= ""

# journald: persistent logs, capped size (see Day4.2 study guide)
# These get applied via a journald.conf we ship in the image.

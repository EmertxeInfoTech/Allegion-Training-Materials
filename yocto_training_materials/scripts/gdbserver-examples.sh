#!/bin/bash
# gdbserver-examples.sh (D4S4)
# Reference commands for remote debugging a target binary. Read, don't run blind.

cat <<'EOF'
# ===========================================================================
# REMOTE DEBUGGING WITH gdbserver
# ===========================================================================

# --- On the TARGET: start a new process under gdbserver ---
gdbserver :2345 /usr/bin/myapp
#   listens on TCP 2345 and waits for the host gdb to connect

# --- On the TARGET: attach to an already-running process ---
gdbserver :2345 --attach $(pidof myapp)

# --- On the HOST (inside the sourced SDK environment) ---
#   $GDB is set by the SDK environment-setup script.
$GDB /path/to/host/build/myapp
#   then, at the (gdb) prompt:
#     (gdb) target remote 192.168.1.42:2345
#     (gdb) break main
#     (gdb) continue
#     (gdb) next / step / print <var> / backtrace
#     (gdb) continue

# --- Make sure debug symbols are available ---
#   Yocto strips symbols into a -dbg package. Install on target:
#     opkg install myapp-dbg
#   Or build with IMAGE_FEATURES += "dbg-pkgs" (or tools-debug).

# ===========================================================================
# strace - watch what a process asks the kernel for
# ===========================================================================
strace ./myapp                       # trace a new process
strace -p $(pidof myapp)             # attach to running
strace -e openat,read ./myapp        # only file syscalls (find missing files)
strace -e network ./myapp            # only network syscalls
strace -f -o myapp.trace ./myapp     # follow forks, write to file
strace -c ./myapp                    # summary: syscall counts + time

# ===========================================================================
# coredumpctl - post-mortem crash analysis
# ===========================================================================
coredumpctl list                     # what crashed
coredumpctl info <pid|exe>           # details of a crash
coredumpctl gdb <pid|exe>            # open gdb on the core
coredumpctl dump <pid> > myapp.core  # extract the core to analyse off-device
EOF

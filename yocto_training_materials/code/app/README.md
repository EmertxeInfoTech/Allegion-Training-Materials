# Day 4 Demo Applications (D4S4)

| File | Purpose |
|------|---------|
| myapp.c | Cross-compile + deploy + ldd + gdbserver demo (uses OpenSSL) |
| myapp_crash.c | Deliberate crash for the coredumpctl / gdb demo |
| Makefile | Builds both; source the SDK env first |

Workflow:

    source /opt/poky/5.0/environment-setup-*    # set CC, sysroot, etc.
    make                                          # builds myapp + myapp_crash

    # Deploy (dev iteration)
    scp myapp root@<target>:/usr/bin/
    # Check runtime deps on target
    ldd /usr/bin/myapp

    # Remote debug
    # on target:  gdbserver :2345 /usr/bin/myapp
    # on host:    $GDB myapp  ->  target remote <target>:2345

    # Crash analysis
    # on target:  ./myapp_crash ; coredumpctl gdb

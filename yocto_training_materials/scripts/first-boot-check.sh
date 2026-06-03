#!/bin/sh
# first-boot-check.sh (D4S2)
# Run on the target right after first boot. Verifies the system came up clean.
# Exit code 0 = all good; non-zero = something to investigate.

fail=0
note() { printf '%-22s %s\n' "$1" "$2"; }

echo "==================== TrainerGW First-Boot Check ===================="

# 1. Time / date sane (RTC or NTP working)
YEAR=$(date +%Y)
if [ "$YEAR" -ge 2024 ]; then note "Clock:" "OK ($(date))"; else note "Clock:" "SUSPECT ($(date)) - NTP/RTC?"; fail=1; fi

# 2. Network: IP present
IP=$(ip -4 -o addr show scope global 2>/dev/null | awk '{print $4}' | head -n1)
if [ -n "$IP" ]; then note "IP address:" "OK ($IP)"; else note "IP address:" "MISSING"; fail=1; fi

# 3. Network: default route
if ip route show default 2>/dev/null | grep -q default; then note "Default route:" "OK"; else note "Default route:" "MISSING"; fail=1; fi

# 4. DNS
if getent hosts example.com >/dev/null 2>&1; then note "DNS:" "OK"; else note "DNS:" "FAILED (or offline)"; fi

# 5. Filesystems mounted
note "Mounts:" "$(df -h / 2>/dev/null | awk 'NR==2 {print $1" "$5" used"}')"

# 6. Memory
note "Memory:" "$(free -h 2>/dev/null | awk 'NR==2 {print $3" used / "$2" total"}')"

# 7. Kernel errors / warnings
KERR=$(dmesg --level=err,warn 2>/dev/null | wc -l)
if [ "$KERR" -eq 0 ]; then note "Kernel err/warn:" "OK (none)"; else note "Kernel err/warn:" "$KERR lines - review: dmesg --level=err,warn"; fi

# 8. systemd failed units
if command -v systemctl >/dev/null 2>&1; then
    FAILED=$(systemctl --failed --no-legend 2>/dev/null | wc -l)
    if [ "$FAILED" -eq 0 ]; then note "Failed units:" "OK (none)"; else note "Failed units:" "$FAILED - review: systemctl --failed"; fail=1; fi
    note "System state:" "$(systemctl is-system-running 2>/dev/null)"
fi

echo "===================================================================="
if [ "$fail" -eq 0 ]; then echo "RESULT: clean boot"; else echo "RESULT: issues found - see lines above"; fi
exit $fail

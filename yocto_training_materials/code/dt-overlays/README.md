# Device Tree Overlays (D3S3)

`trainergw-status-led.dts` is the working reference overlay (a GPIO status LED).
The four `broken-*.dts` files each demonstrate one of the most common bring-up
failures, with the BUG and FIX documented inline.

| File | Failure mode | First thing to check |
|------|--------------|----------------------|
| broken-01-wrong-compatible | driver never binds | binding doc for the exact compatible string |
| broken-02-gpio-conflict | EBUSY on probe | `cat /sys/kernel/debug/gpio` |
| broken-03-missing-status-okay | child node ignored | parent bus `status` |
| broken-04-missing-clock | EPROBE_DEFER forever | `cat /sys/kernel/debug/devices_deferred` |

Debug toolkit (works for all):
- `dtc -I fs -O dts /sys/firmware/devicetree/base | less`  (the live tree)
- `dmesg | grep -iE 'probe|defer|of_'`
- `cat /sys/kernel/debug/devices_deferred`

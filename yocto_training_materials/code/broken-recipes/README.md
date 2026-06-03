# Five Deliberately-Broken Recipes (D2S5)

Use these for the build-debugging exercise. Each has a clearly labelled BUG and
a FIX comment. Let students hit the error, read the log, and fix it.

| File | Failure | Where it fails | Fix |
|------|---------|----------------|-----|
| 01-fetch-fail | 404 on fetch | do_fetch | Use a real version + checksum |
| 02-checksum-mismatch | sha256 mismatch | do_fetch | Paste the correct sha256 |
| 03-patch-reject | patch won't apply | do_patch | Rebase patch in devshell |
| 04-files-mismatch | installed not shipped | do_package | Add file to FILES |
| 05-compile-error | missing header | do_compile | Add DEPENDS = "openssl" |

Diagnostic flow for every one:
1. Read the error line BitBake prints (it names the failed task + log path).
2. `less` the log: `tmp/work/.../<recipe>/.../temp/log.do_<task>`.
3. For compile/patch problems, `bitbake <recipe> -c devshell` and reproduce by hand.
4. Fix, then re-run just that task: `bitbake <recipe> -c <task> -f`.

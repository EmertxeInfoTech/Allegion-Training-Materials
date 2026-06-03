# DEPENDS vs RDEPENDS (D2S2)

- **DEPENDS** = build-time. What you need to *compile* (headers, libraries, tools).
- **RDEPENDS** = runtime. What the device needs to *run* the shipped package.

The two files here are identical except for one line.

- `bad-missing-rdepends_1.0.bb` ships a Python script with no `RDEPENDS`.
  It installs but fails at runtime with `python3: not found`.
- `good-with-rdepends_1.0.bb` adds `RDEPENDS:${PN} = "python3-core python3-requests"`.

**Demo:** build both into an image, boot, run `healthcheck`. The bad one fails;
the good one prints `OK`. About 90% of "works on my host, fails on target" bugs
trace back to a missing RDEPENDS like this.

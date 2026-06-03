# Yocto + Embedded Linux Training — Reference Materials

Companion materials for the four-day Yocto training. Organized by type so items
can be reused across sessions. File names are prefixed with the day/session
(e.g. `D3S2_...`) so they map back to the schedule and the materials checklist.

## Folder map

```
code/        Real recipes, configs, overlays, WKS files, sample apps
scripts/     Runnable shell scripts + the testimage Python case
handouts/    Print-ready Word (.docx) cheat sheets, worksheets, quizzes
diagrams/    Branded SVG diagrams (architecture, flows, decision trees)
references/  (see handouts/D4S7_references.docx)
```

## code/

- `meta-trainerdemo/` — the complete working layer built across the course
  (hello-trainergw, gw-info, packagegroup, image recipe, kernel fragments+bbappend)
- `sample-recipes/` — five recipe patterns (local, git, autotools, cmake, makefile)
- `rdepends-examples/` — good vs bad RDEPENDS, side by side
- `broken-recipes/` — five deliberately-broken recipes for the debugging lab
- `machine-conf/` — a template machine.conf
- `config-samples/` — local.conf, sstate mirror, nginx, hardened sshd, journald, coredump
- `dt-overlays/` — a working status-LED overlay + four broken DT scenarios
- `wic/` — three partition layouts (simple, A/B, read-only+overlay)
- `spdx-recipes/` — license declaration examples + INCOMPATIBLE_LICENSE policy
- `app/` — myapp.c (SDK build) + a crashing variant for the core-dump demo
- `ptest/` — ptest bbappend, run-ptest, and a testimage Python test case

## scripts/

- `first-boot-check.sh` — verifies a clean first boot on the target
- `devtool-walkthrough.sh` — guided devtool modify/build/deploy/finish loop
- `gdbserver-examples.sh` — remote debug + strace + coredumpctl reference
- `cve-gate.sh` — fail a release on unpatched HIGH/CRITICAL CVEs
- `release-gate.sh` — chain build + testimage + CVE + SBOM + license checks

## handouts/ (Word, print-ready)

Cheat sheets, glossaries, comparison cards, lab worksheets, daily quizzes
(student + instructor versions), the capstone summary, references, and the
feedback form. Each carries the Emertxe footer and page numbers.

> Quiz note: the instructor versions include the answer key in green callouts.
> Hand out the `_student` versions; keep the `_instructor` versions for yourself.

## diagrams/ (SVG — scalable, print-clean)

Yocto architecture, build-failure flowchart, filesystem decision tree,
boot flow, networking diagnostics ladder, A/B update flow.

## What was intentionally skipped

Binary assets that cannot be authored as text/vector were skipped per request:
photos, pre-recorded demo videos, pre-built sstate caches, pre-flashed SD card
images, and the SDK installer binary. These are marked in the materials
checklist as "Pre-built artifact" and must be produced during prep on a real
build host.

## Scope of this set

This batch covers the **"Must"** priority code and document items from the
materials checklist. "Should" and "Nice" items can be produced on request.

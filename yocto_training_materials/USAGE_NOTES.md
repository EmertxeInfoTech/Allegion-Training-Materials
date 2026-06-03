# Usage notes

## Trying the code on a real build
1. Clone Poky (Scarthgap) and source the build env.
2. Copy `code/meta-trainerdemo` next to poky, then `bitbake-layers add-layer ../meta-trainerdemo`.
3. Use `code/config-samples/local.conf.sample` as a starting local.conf.
4. `bitbake trainergw-image` (or `core-image-base` with IMAGE_INSTALL appends).

## Placeholders to fill before building
Some sample recipes contain `<fill-in>` / `<sha256-...>` placeholders where a
real upstream URL, checksum, or license md5 is needed. They are illustrative of
the pattern; replace before building against a real source.

## Converting handouts to PDF for printing
LibreOffice (or Word) → Export as PDF. The documents are US-Letter, 1" margins.

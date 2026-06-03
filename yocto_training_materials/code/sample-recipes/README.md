# Five Recipe Patterns (D2S2)

These cover the source/build styles you will meet most often.

| File | Pattern | Key points |
|------|---------|-----------|
| 01-local-file_1.0.bb | Local file | `SRC_URI = "file://..."`, `S = "${WORKDIR}"` |
| 02-git-source_1.0.bb | Git + SRCREV | Pin exact commit, never a moving branch |
| 03-autotools_1.2.3.bb | autotools | `inherit autotools`, `EXTRA_OECONF` |
| 04-cmake_2.0.0.bb | CMake | `inherit cmake`, `EXTRA_OECMAKE` |
| 05-makefile_0.9.bb | Plain Makefile | `oe_runmake`, manual `do_install` |

Replace every `<fill-in>` placeholder before building. For real tarballs, get
the checksum with `sha256sum file.tar.gz`. For git LICENSE checksums, fetch
once and read the error message - it prints the correct md5.

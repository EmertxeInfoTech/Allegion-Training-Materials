#!/usr/bin/env python3
import sys
try:
    import requests  # noqa: F401
except ImportError:
    print("healthcheck: 'requests' module not installed", file=sys.stderr)
    sys.exit(1)
print("healthcheck: OK")

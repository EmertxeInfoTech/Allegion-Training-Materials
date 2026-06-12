# Simple Makefile for mydaemon
# CC, CFLAGS, LDFLAGS come from the Yocto environment via oe_runmake

CC ?= gcc
CFLAGS ?= -O2 -Wall -Wextra
LDFLAGS ?=

all: mydaemon

mydaemon: mydaemon.c
	$(CC) $(CFLAGS) $(LDFLAGS) -o mydaemon mydaemon.c

clean:
	rm -f mydaemon

.PHONY: all clean

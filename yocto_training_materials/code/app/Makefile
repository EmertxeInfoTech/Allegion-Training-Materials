# Makefile for the Day 4 demo apps. Source the SDK environment first:
#   source /opt/poky/5.0/environment-setup-*
# Then:  make

CC ?= cc
CFLAGS ?= -Wall -O2
DBGFLAGS = -g -O0

all: myapp myapp_crash

myapp: myapp.c
	$(CC) $(CFLAGS) myapp.c -o myapp -lcrypto

myapp_crash: myapp_crash.c
	$(CC) $(DBGFLAGS) myapp_crash.c -o myapp_crash

clean:
	rm -f myapp myapp_crash

.PHONY: all clean

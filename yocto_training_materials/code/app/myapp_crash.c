/*
 * myapp_crash.c (D4S4) - deliberately crashing variant for the core-dump demo.
 * Build:  $CC myapp_crash.c -o myapp_crash -g -O0
 * Run on target, watch it crash, then:
 *   coredumpctl list
 *   coredumpctl gdb <pid>
 *   (gdb) bt full
 */
#include <stdio.h>
#include <string.h>

static int compute(int *values, int count) {
    int total = 0;
    /* BUG: off-by-one walks one past the end of the array. With a bad index
       and -O0 this reliably faults when count is chosen to overrun. */
    for (int i = 0; i <= count; i++)
        total += values[i];
    return total;
}

int main(void) {
    int data[4] = {10, 20, 30, 40};

    /* Pass a bad count to force a read past the array AND a null deref below. */
    printf("sum = %d\n", compute(data, 1000000));

    char *p = NULL;
    strcpy(p, "boom");   /* null pointer dereference -> SIGSEGV */
    return 0;
}

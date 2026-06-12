/* mydaemon.c - minimal systemd-managed daemon for Allegion demo */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <time.h>

static volatile int running = 1;

static void handle_term(int sig) {
    (void)sig;
    running = 0;
}

int main(void) {
    /* systemd manages us as Type=simple; just log and loop. */
    signal(SIGTERM, handle_term);
    signal(SIGINT, handle_term);

    /* Line-buffered so journald captures each line promptly. */
    setvbuf(stdout, NULL, _IOLBF, 0);

    printf("mydaemon: started (pid=%d)\n", getpid());

    while (running) {
        time_t now = time(NULL);
        printf("mydaemon: heartbeat at %s", ctime(&now));
        sleep(30);
    }

    printf("mydaemon: shutting down cleanly\n");
    return 0;
}

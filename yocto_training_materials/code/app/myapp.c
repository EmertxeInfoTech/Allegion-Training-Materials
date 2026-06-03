/*
 * myapp.c (D4S4) - simple cross-compiled application using OpenSSL.
 * Build with the SDK:
 *   source /opt/poky/5.0/environment-setup-*
 *   $CC myapp.c -o myapp -lcrypto
 * Deploy and run on the target. ldd should resolve libcrypto on the device.
 */
#include <stdio.h>
#include <string.h>
#include <openssl/sha.h>

int main(int argc, char **argv) {
    const char *msg = (argc > 1) ? argv[1] : "trainergw";
    unsigned char hash[SHA256_DIGEST_LENGTH];

    SHA256((const unsigned char *)msg, strlen(msg), hash);

    printf("SHA-256 of \"%s\":\n", msg);
    for (int i = 0; i < SHA256_DIGEST_LENGTH; i++)
        printf("%02x", hash[i]);
    printf("\n");
    return 0;
}

#include <stdio.h>
#include <openssl/sha.h>

int main(void) {
    unsigned char hash[SHA256_DIGEST_LENGTH];
    const char *msg = "trainergw";
    SHA256((const unsigned char *)msg, 9, hash);
    printf("sha256 computed\n");
    return 0;
}

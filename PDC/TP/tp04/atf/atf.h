#define ATF_BLOCSIZE 32
#define NBLOCS 2000

void *atf_newbloc();
int atf_freebloc(void *bloc);
int atf_init();

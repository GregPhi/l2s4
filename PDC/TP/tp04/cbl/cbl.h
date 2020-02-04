#define CBL_BLOCSIZE 32
#define NBLOCS 5

void *cbl_newbloc(void);
int cbl_freebloc(void *);
int cbl_init(void);

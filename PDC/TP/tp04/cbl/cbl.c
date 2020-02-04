#include <stdio.h>

#include "cbl.h"

#define BLOC_END -1
#define BLOC_TAKEN -2

struct free_bloc_s{
  int nb_free_bloc;
  int next_free_bloc;
};

union bloc_u{
  struct free_bloc_s bloc_free;
  char bloc[CBL_BLOCSIZE];
};

static int first_free_blocs;
static union bloc_u membloc[NBLOCS];

void *cbl_newbloc(){
  if(first_free_blocs != BLOC_END){
    int ffb = first_free_blocs;
    membloc[first_free_blocs+1].bloc_free.nb_free_bloc = membloc[first_free_blocs].bloc_free.nb_free_bloc-1;
    membloc[first_free_blocs+1].bloc_free.next_free_bloc = membloc[first_free_blocs].bloc_free.next_free_bloc;
    first_free_blocs = (membloc[first_free_blocs].bloc_free.nb_free_bloc == 1)?membloc[first_free_blocs].bloc_free.next_free_bloc : first_free_blocs + 1;
    membloc[ffb].bloc_free.next_free_bloc = BLOC_TAKEN;
    return membloc[ffb].bloc;
  }
  return NULL;
}

int cbl_freebloc(void *bloc){
  int i;
  for(i = 0; i < NBLOCS; i++){
    if(bloc == membloc+i){
      if(membloc[i].bloc_free.next_free_bloc != BLOC_TAKEN){
        return 0;
      }
      membloc[i].bloc_free.nb_free_bloc = 1;
      if(first_free_blocs != BLOC_END){
        membloc[i].bloc_free.next_free_bloc = membloc[first_free_blocs].bloc_free.next_free_bloc;
        membloc[first_free_blocs].bloc_free.next_free_bloc = i;
      }else{
        membloc[i].bloc_free.next_free_bloc = BLOC_END;
        first_free_blocs = i;
      }
      return 1;
    }
  }
  return 0;
}

int cbl_init(){
  first_free_blocs = 0;
  membloc[0].bloc_free.nb_free_bloc = NBLOCS;
  membloc[0].bloc_free.next_free_bloc = BLOC_END;
  return 0;
}

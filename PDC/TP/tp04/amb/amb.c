#include <stdio.h>
#include "amb.h"

#define BLOC_END -1
#define NBLOCS 2048

static int first_free_blocs;
static union bloc_u membloc[NBLOCS];

void *amb_newbloc(unsigned int nbloc){
  int ind = first_free_blocs,prev_ind = 0;
  int nb_blocs = membloc[ind].bloc_free.nb_free_bloc;
  while(ind != BLOC_END && nb_blocs <= nbloc){
    prev_ind = ind;
    ind = membloc[ind].bloc_free.next_free_bloc;
    nb_blocs = membloc[ind].bloc_free.nb_free_bloc;
  }
  if(ind != BLOC_END){
    membloc[ind].bloc_0 = nbloc;
    if(nb_blocs != nbloc+1){
      membloc[ind+nbloc+1].bloc_free.next_free_bloc = membloc[ind].bloc_free.next_free_bloc;
      membloc[ind+nbloc+1].bloc_free.nb_free_bloc = nb_blocs - nbloc -1;
      if(ind == first_free_blocs){
        first_free_blocs = ind+nbloc+1;
      }else{
        membloc[prev_ind].bloc_free.next_free_bloc = ind+nbloc+1;
      }
      return membloc[ind+1].bloc;
    }else{
      if(ind == first_free_blocs){
        first_free_blocs = membloc[ind].bloc_free.next_free_bloc;
      }else{
        membloc[prev_ind].bloc_free.next_free_bloc = membloc[ind].bloc_free.next_free_bloc;
      }
      return membloc[ind+1].bloc;
    }
  }else{
    return NULL;
  }
}

int amb_freebloc(void *bloc){
  union bloc_u *bloc_p = bloc;
  int i = bloc_p-membloc-1;
  int nalloue = ++membloc[i].bloc_0;
  int ffb = first_free_blocs;
  int c = ffb;
  if(ffb != BLOC_END){
    while(membloc[c].bloc_free.next_free_bloc != BLOC_END && membloc[c].bloc_free.next_free_bloc < i){
      c = membloc[c].bloc_free.next_free_bloc;
    }
    if(c > i){
      first_free_blocs = i;
      membloc[i].bloc_free.next_free_bloc = c;
      membloc[i].bloc_free.nb_free_bloc = nalloue;
    }else{
      membloc[i].bloc_free.next_free_bloc = membloc[c].bloc_free.next_free_bloc;
      membloc[i].bloc_free.nb_free_bloc = nalloue;
      membloc[c].bloc_free.next_free_bloc = i;
    }
    return 1;
  }else{
    membloc[i].bloc_free.next_free_bloc = BLOC_END;
    membloc[i].bloc_free.nb_free_bloc = nalloue;
    first_free_blocs = i;
    return 0;
  }
}

int amb_init(){
  first_free_blocs = 0;
  membloc[0].bloc_free.nb_free_bloc = NBLOCS;
  membloc[0].bloc_free.next_free_bloc = BLOC_END;
  return 0;
}

/*
int main(void){
  amb_init();
  void *s1 = amb_newbloc(9);
  printf("%p\n", s1);
  void *s2 = amb_newbloc(1);
  printf("%p\n", s2);
  amb_freebloc(s1);
  void *s3 = amb_newbloc(3);
  printf("%p\n", s3);
  void *s4 = amb_newbloc(3);
  printf("%p\n", s4);
  void *s5 = amb_newbloc(1);
  printf("%p\n", s5);
}
*/

#include <stdio.h>
#include <stlib.h>
#include <assert.h>

#include "atf.h"

int main(){
  void *addr[42];
  int naddr = 0;
  void *p;
  int i, status;
  atf_init();
  while((p=atf_newbloc())){
    if(naddr < 42 && (rand()%4 == 0)){
      addr[naddr++] = p;
    }
  }
  for(i = 0; i < naddr; i++){
    status = atf_freebloc(addr[i]);
    assert(status==0);
  }
}

#include <stdio.h>
#include <stdlib.h>

int main(){
  long int nw = 1;
  int c;
  while ((c = getchar()) != EOF){
    if (c == ' ' && c == '\n'){
      nw++;
    }
  }
  return nw;
}

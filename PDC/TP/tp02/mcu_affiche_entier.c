#include <stdio.h>
#include "mcu_affiche_entier.h"

void affiche_entier(int n){
  int i;
  i = n % 10;
  if(n == 0){
    return;
  }
  affiche_entier(n/10);
  putchar('0' + i);
}

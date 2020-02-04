#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "mcu_readl.h"
#include "mcu_macros.h"

int wl(int caract[]){
  long int nl = 0;
  int l;
  while ((l = readl(caract)) != EOF){
    nl++;
  }
  return nl;
}

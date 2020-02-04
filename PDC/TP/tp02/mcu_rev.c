#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "mcu_readl.h"
#include "mcu_macros.h"

int rev(int caract[]){
  int l;
  int i;
  while (l = readl(caract) != EOF){
    for (i = readl(caract)-1; i >= 0; i--){
      putchar(caract[l]);
    }
  }
  return 0;
}

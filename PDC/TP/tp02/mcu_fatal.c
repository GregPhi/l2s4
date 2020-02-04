#include <stdio.h>
#include <stdlib.h>
#include "mcu_fatal.h"

void fatal(int assert, const char message[], int status){
  if (assert > 0){
    fprintf(stderr, "%s", message);
    exit(status);
  }
  return;
}

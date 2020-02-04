#include <stdio.h> 
#include <stdlib.h>
#include "mcu_macros.h"
#include <unistd.h>
#include "mcu_fatal.h"

int readl(char line[])
{ 
  int g = getchar();
  int cpt = 0;  
  while (cpt <= MAXLINE && g != EOF && g != '\n')
    {line[cpt] = g;
      g = getchar();
      cpt++;
      if (cpt > MAXLINE)
  {
    fatal(cpt > MAXLINE,"Trop long !",1);
  }
      if (g == '\n')
  {
    line[cpt] = '\0';
  }
    }
  return cpt;
}


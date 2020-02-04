#include <stdio.h>
#include <stdlib.h>
#include "mcu_affiche_entier.h"

int m_wc()
{
 int g = getchar();
 int cpt = 1;
 while (g != EOF)
  {if (g == '\n')
     {g =getchar();
      if (g == EOF)
	{
	 break;
	}
      else 
	{
	  cpt++;
	}
    }
  else {
   cpt++;
   g = getchar();
       } 
  } 
return cpt;
}

int main (void)
{
  affiche_entier(m_wc());
  putchar ('\n');
  return 0;
}

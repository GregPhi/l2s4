#include <stdio.h>
#include <stdlib.h>
extern int readl(int line[]){
    for(int i=0;i<200;i++){
      line[i]=getchar();
 	if (line[i]==EOF){
	    line[i]='\0';
	    return EOF;
	}
         if (line[i]=='\n'){
	    line[i]='\0';
	    return i;
	}

    }
}

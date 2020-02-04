#include <stdlib.h>
#include <stdio.h>
int rand (void);
#define TABSIZE 10
#define NMAXCHAR 200

int compint(const void * a,const void * b){
    if (*(int *)a<*(int *)b){return -1;}
    if(*(int *)a>*(int *)b){return 1;}
    return 0;
}

void affichetab(int *tab,int nelem){
    for(int i =0;i<nelem;i++){
        printf("%d |",tab[i]);
    }
    putchar('\n');
}
int strcmp2(const void * a,const void * b){
        for( int i=0;i<NMAXCHAR;i++){
                if(((int *)a)[i]>((int *)b)[i]){return 1;}
                    else if(((int *)a)[i]<((int *)b)[i]){return -1;}
                        }
            return 0;
}

void *memcpy(void * des,void * src,size_t n){
        for(size_t i=0;i<n;i++){
                    ((char *)des)[i]=((char *)src)[i];
                        }
}

void quicksort(void *base, int nelem, int size,int(*compar)(const void *, const void *)){
    if (nelem==2){
        if (compar(base,base+size)==1){
            void * a=malloc(size);
            memcpy(a,base,size);
            memcpy(base,base+size,size);
            memcpy(base+size,a,size);
      free(a);
        }
    }
    if (nelem>2){
        int j=0;
        void * a=malloc(size);
        for(int i=0; i<nelem-1;i++){
            if (compar(base+(i*size),base+(nelem-1)*size)<1){
                memcpy(a,base+j*size,size);
                memcpy(base+(j*size),base+(i*size),size);
                memcpy(base+(i*size),a,size);
                j++;
            }
        }
        memcpy(a,base+(j*size),size);
        memcpy(base+(j*size),base+((nelem-1)*size),size);
        memcpy(base+((nelem-1)*size),a,size);
        free(a);
        quicksort(base,j,size,compar);
        quicksort(base+(j+1)*size,nelem-(j+1),size,compar);
    }
}



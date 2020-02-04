
msort: msort.o mcu_readl.o quicksort.o 
	gcc -o msort mcu_readl.o quicksort.o msort.o

msort.o: msort.c quicksort.h mcu_readl.h
	gcc -c msort.c

quicksort_int : quicksort_int.c
	gcc -o quicksort_int quicksort_int.c

quicksort.o: quicksort.c quicksort.h
	gcc -c quicksort.c

label : label.o mcu_readl.o quicksort.o
	gcc -o label mcu_readl.o quicksort.o label.o 

label.o : label.c quicksort.h mcu_readl.h
	gcc -c label.c  

mcu_readl.o : mcu_readl.c mcu_readl.h
	gcc -c mcu_readl.c
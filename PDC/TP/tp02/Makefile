CFLAGS =-W -Wall -ansi -pedantic
EXEC = main

all :
	make mcu_readl.o
	make mcu_macros.o
	make mcu_fatal.o
	make mcu_affiche_entier.o
	make mcu_test.o
	make mcu_test

mcu_test : mcu_readl.o mcu_fatal.o mcu_affiche_entier.o mcu_macros.o mcu_test.o
	gcc mcu_readl.o mcu_fatal.o mcu_affiche_entier.o mcu_macros.o mcu_test.o -o mcu_test $(CFLAGS)

mcu_readl.o: mcu_readl.c mcu_readl.h mcu_macros.h
	gcc -c mcu_readl.c -o mcu_readl.o $(CFLAGS)

mcu_macros.o: mcu_macros.c mcu_macros.h
	gcc -c mcu_macros.c -o mcu_macros.o $(CFLAGS)

mcu_fatal.o: mcu_fatal.c mcu_fatal.h
	gcc -c mcu_fatal.c -o mcu_fatal.o $(CFLAGS)

mcu_affiche_entier.o: mcu_affiche_entier.c mcu_affiche_entier.h
	gcc -c mcu_affiche_entier.c -o mcu_affiche_entier.o $(CFLAGS)

mcu_test.o: mcu_test.c mcu_macros.h mcu_readl.h mcu_affiche_entier.h mcu_fatal.h
	gcc -c mcu_test.c -o mcu_test.o $(CFLAGS)

mcu_wc.o: mcu_wc.c
	gcc -c mcu_wc.c -o mcu_wc.o $(CFLAGS)

mcu_wc:
	gcc -o mcu_wc.c mcu_wc $(CFLAGS)

mcu_ww.o: mcu_ww.c
	gcc -c mcu_ww.c -o mcu_ww.o $(CFLAGS)

mcu_ww:
	gcc -o mcu_ww.c mcu_ww $(CFLAGS)

mcu_wl.o: mcu_wl.c
	gcc -c mcu_wl.c -o mcu_wl.o $(CFLAGS)

mcu_rev.o: mcu_rev.c
	gcc -c mcu_rev.c -o mcu_rev.o $(CFLAGS)

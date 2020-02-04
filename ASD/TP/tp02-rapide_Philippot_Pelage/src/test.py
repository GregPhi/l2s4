# -*- coding: utf-8 -*-

"""
:mod:`test` module : test module for quicksort assignment

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2016, january
"""

import sorting
import generate
import copy
import sys

global cpt


def cmp(a,b):
    """
    A comparison function

    :param a: First element
    :param b: Second element
    :return: 0 if a == b, 1 if a > b, -1 if a < b
    :rtype: int

    >>> cmp(10,5)
    1
    >>> cmp(5,5)
    0
    >>> cmp(5,10)
    -1
    """
    global cpt
    cpt = cpt + 1
    if a == b:
        return 0
    elif a < b:
        return -1
    else:
        return 1

def file(n,name_file):
    """
    Create a name_file.dat

    :param n:
    :type n: int
    :param name_file: name file
    :type name_file: string

    >>> file(100,"first_100.data",0)
    >>> file(100,"opti_100.data",1)
    >>> file(100,"alea_100.data",2)
    """
    global cpt
    file = open(name_file,"w")

    for i in range (1, n+1):
        cpt = 0
        t = generate.random_list(i)
        sorting.quicksort(t,cmp,0)
        aux = str(i)+" "+str(cpt)
        cpt = 0
        sorting.quicksort(t,cmp,1)
        aux +=" "+str(cpt)+"  "
        cpt = 0
        sorting.quicksort(t,cmp,2)
        aux += str(cpt)+"\n"
        file.write(aux)
    file.close()

if __name__ == "__main__":
    pivot = int(sys.argv[1])
    file(100,"pivots_first_alea_opti(cmp_supl).dat")
    cpt = 0
    t = generate.random_list(100)
    tt = sorting.merge_sort(t,cmp)
    print (tt)
    if generate.is_sorted (tt):
        print("Yes !!")
    else:
        raise Exception("List has not been correctly sorted by merge sort")

    print (t)
    sorting.quicksort(t,cmp,pivot)
    if generate.is_sorted (t):
        print("Yes !!")
        print(cpt)
    else:
        raise Exception("List has not been correctly sorted by quicksort")

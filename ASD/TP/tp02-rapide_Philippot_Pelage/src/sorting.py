# -*- coding: utf-8 -*-

"""
:mod:`sorting` module : sorting functions module for quicksort assignment

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2017, january
"""

import copy
import random
import test
import math



def merge (t1,t2, cmp):
    """
    Given two sorted list, creates a fresh sorted list.

    :param t1: A list of objects
    :type t1: list
    :param t2: A list of objects
    :type t1: list
    :param cmp: A comparison function, returning 0 if a == b, -1 is a < b, 1 if a > b
    :type cmp: function
    :return: A fresh list, sorted.
    :rtype: list

    .. note::

       time complexity of merge is :math:`O(n_1+n_2)` with
       :math:`n_1` and :math:`n_2` resp. the length of *t1* and *t2*

    """
    n1 = len(t1)
    n2 = len(t2)
    t = [ 0 for i in range(0,n1+n2)]
    i = j = k = 0
    while i < n1 and j < n2:
        if cmp(t1[i],t2[j]) < 0:
            t[k] = t1[i]
            i = i + 1
        else:
            t[k] = t2[j]
            j = j + 1
        k = k + 1
    while i < n1:
        t[k] = t1[i]
        i = i + 1
        k = k + 1
    while j < n2:
        t[k] = t2[j]
        j = j + 1
        k = k + 1
    return t


def merge_sort (t,cmp):
    """
    A sorting function implementing the merge sort algorithm

    :param t: A list of integers
    :type t: list
    :param cmp: A comparison function, returning 0 if a == b, -1 is a < b, 1 if a > b
    :type cmp: function
    :return: A fresh list, sorted.
    :rtype: list
    """
    n = len(t)
    if n <= 1:
        # cas de base
        return copy.deepcopy(t)
    else:
        # cas general
        t1 = merge_sort((t[0:((n-1)//2+1)]),cmp)
        t2 = merge_sort((t[((n-1)//2+1):n]),cmp)
        return merge(t1,t2,cmp)


def quicksort (t,cmp,choice):
    """
    A sorting function implementing the quicksort algorithm

    :param t: A list of integers
    :type t: list
    :param cmp: A comparison function, returning 0 if a == b, -1 is a < b, 1 if a > b
    :type cmp: function
    :return: Nothing

    .. note::
       *t* is modified during the sort process

    >>> import generate
    >>> def cmp (x,y):
    ...    if x == y:
    ...       return 0
    ...    elif x < y:
    ...       return -1
    ...    else:
    ...       return 1
    >>> l = generate.random_list(10)
    >>> quicksort(l,cmp,0)
    >>> quicksort(l,cmp,1)
    >>> quicksort(l,cmp,2)
    """
    s = {'data' : t, 'left' : 0, 'right' : len(t)-1}
    quicksort_slice(s,cmp,choice)
    print(s)


def quicksort_slice (s, cmp,choice):
    """
    A sorting function implementing the quicksort algorithm

    :param s: A slice of a list, that is a dictionary with 3 fields :
              data, left, right representing resp. a list of ibjects and left
              and right bounds of the slice.
    :type s: dict
    :param cmp: A comparison function, returning 0 if a == b, -1 is a < b, 1 if a > b
    :type cmp: function
    :return: Nothing
    """
    if (s['right']-s['left'] < 1):
        return
    else:
        if choice == 0:
            m1, m2 = partition(s,cmp,s['left'])
        elif choice == 1:
            m1, m2 = partition(s,cmp,random_pivot(s))
        else:
            m1, m2 = partition(s,cmp,optimal_pivot(s))
        quicksort_slice(m1,cmp,choice)
        quicksort_slice(m2,cmp,choice)
        return


def partition (s, cmp,xpivot):
    """
    Creates two slices from *s* by selecting in the first slice all
    elements being less than the pivot and in the second one all other
    elements.

    :param s: A slice of a list, that is a dictionary with 3 fields :
              data, left, right representing resp. a list of ibjects and left
              and right bounds of the slice.
    :type s: dict
    :param cmp: A comparison function, returning 0 if a == b, -1 is a < b, 1 if a > b
    :type cmp: function
    :return: A couple of slices, the pivot being at the left index of the second slice.
    :rtype: tuple

    >>> import generate
    >>> def cmp (x,y):
    ...    if x == y:
    ...       return 0
    ...    elif x < y:
    ...       return -1
    ...    else:
    ...       return 1
    >>> l = generate.random_list(10)
    >>> pivot = l[0]
    >>> p1,p2 = partition({'left':0,'right':len(l)-1,'data':l},cmp)
    >>> l1 = p1['data'][p1['left']:p1['right']+1]
    >>> l2 = p2['data'][p2['left']:p2['right']+1]
    >>> print(l1)
    >>> print(l2)
    """
    pivot = s["data"][xpivot]

    idx = s["left"]
    pos_pivot = s["data"].index(pivot)
    count = 0
    while idx <= s["right"] and count <= (s["right"] - s["left"]):
        pos_pivot = s["data"].index(pivot)
        if cmp(pivot, s["data"][idx]) == 1:
            aux = s["data"][idx]
            s["data"][idx]= pivot
            s["data"][pos_pivot] = aux
            idx += 1


        elif cmp(pivot,s["data"][idx]) == -1 :

            aux= s["data"][idx]
            for i in range(idx,s["right"]):
                s["data"][i] = s["data"][i+1]
            s["data"][s["right"]] = aux
            count += 1

        else:
            idx += 1

    return ({"data" : s["data"], "left":s["left"], "right":pos_pivot},{"data" : s["data"], "left" : pos_pivot+1, "right": s["right"]})


def random_pivot(s):
    """
    Returns a random number in a slice of table

    :return: a random number
    :rtype: int

    >>> import generate
    >>> l = generate.random_list(10)
    >>> l
    >>> s = {'left':0,'right':len(l)-1,'data':l}
    >>> random_pivot(s)
    """
    return random.randint(s['left'],s['right'])

def optimal_pivot(s):
    """
    Returns the optimal pivot for the slice

    :return: a random number
    :rtype: int

    >>> import generate
    >>> l = generate.random_list(10)
    >>> l
    >>> s = {'left':0,'right':len(l)-1,'data':l}
    >>> optimal_pivot(s)
    """
    nb = 0
    res = 0
    for i in range (s['left'],s['right']+1):
        res += s['data'][i]
        i+=1
        nb += 1
    res = math.floor(res/nb)
    if res in s['data'][s['left']:s['right']]:
        return s['data'].index(res)

    elif res not in s['data'][s['left']:s['right']]:
        if res >= s['data'][s['right']]:
            return s['right']

        elif res <= s['data'][s['left']]:
            return s['left']




if __name__ == "__main__":
    import doctest
    doctest.testmod()

# -*- coding: utf-8 -*-

""":mod:`bloomfilter` module : Implements a bloomfilter.

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2016, january

"""

def create (n,f,m):
    """
    Creates a new empty Bloom filter of size :math:`2^n`

    :param n: the log of the size of the filter
    :type n: int
    :param f: the hash function whose should take as input two
              parameters: the value to be hashed and the number
              of the subfunction used
    :type f: function(any,int)
    :param m: the number of functions provided by *f*
    :return: the new Bloom filter
    :rtype: dict
    """
    return {"funtion": f, "table": [False for i in range(2**n)], "size": 2**n,"number_of_f":m}

def add (bf, e):
    """
    Adds *e* to *bf*.

    :param bf: A Bloom filter
    :type bf: dict
    :param e: The element to be added
    :type e: Any
    """
    for i in range(0,bf["number_of_f"]):
        bf["table"][bf["funtion"](e,i)%bf["size"]] = True

def contains (bf, e):
    """
    Returns True if *e* is in *bf*.

    :param bf: A Bloom filter
    :type bf: dict
    :param e: The element to be tested
    :type e: Any
    """
    for i in range(0, bf["number_of_f"]):
        if(not bf["table"][bf["funtion"](e,i)%bf["size"]]):
            return False
    return True

# -*- coding: utf-8 -*-

""":mod:`test` module : Test module for bloomfilter analysis

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2016, january

"""
import random
import bloomfilter

nb_hash_functions = 8
random_tab = [ 0 for i in range(128 * nb_hash_functions)]

def init_random_tab ():
    """
    Creates the hash functions.
    """
    global random_tab
    for i in range(128):
        for j in range(nb_hash_functions):
            random_tab[j * 128 + i] = random.randint(1,32000)

def code_of_string (str,n):
    """
    For a given string, returns the hash code for the n-th hashing function.

    :param str: The string to be hashed.
    :type str: string
    :param n: The function number.
    :type n: int
    :return: A hash code
    :rtype: int

    .. note::
       1 <= n <= nb_hash_functions
    """
    h=0

    for i in range(0,len(str)):
        h+=random_tab[128 * (n-1) + ord(str[i]) ]
    return h

def random_word ():
    """
    Returns a word with random letters whose length is between 4 and 7.

    :rtype: string
    """
    letters = [ chr(i) for i in range(ord('a'),ord('z')+1) ] + [ chr(i) for i in range(ord('A'),ord('Z')+1) ]
    length = 4 + random.randint(0,4)
    str = ""
    for i in range(length):
        str = str + random.choice(letters)
    return str

def analyse():
    """
    Analyse the false positve
    """
    init_random_tab()
    test_word = 0
    false_positif = 0
    I = [random_word() for i in range(0,2**10)]
    for n in range(1,9):
        for t in range(10,21):
            bloomfilt = bloomfilter.create(t,code_of_string,n)
            for j in range(0,2**10):
                bloomfilter.add(bloomfilt,I[j])
            for k in range(0,2**14):
                w = random_word()
                if w not in I:
                    test_word += 1
                    if bloomfilter.contains(bloomfilt,w):
                        false_positif += 1
            print(t,n,test_word,false_positif,(false_positif/test_word))
            test_word = 0
            false_positif = 0
        print("")
        print("")

if __name__ == "__main__":
    #init_random_tab()
    #bf = bloomfilter.create(6,code_of_string,8)
    #w = random_word()
    #bloomfilter.add(bf,"timoleon")
    #print("Test add")
    #if bloomfilter.contains(bf,"timoleon"):
    #    print("%s est present" % ("timoleon"),"\n")
    #print("Test random")
    #if not bloomfilter.contains(bf,w):
    #    print("%s n'est pas present" % (w))
    #if bloomfilter.contains(bf,w):
    #    print("%s est present" % (w))
    #print("\n")
    #print("Test analyse")
    analyse()

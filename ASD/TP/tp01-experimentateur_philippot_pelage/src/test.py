# -*- coding: utf-8 -*-

"""
:mod:`test` module : test module for experiences assignment

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2015, december
"""

import sys
import experience
import sorting

cpt = 0
op = 0


def compare (m1,m2):
    global cpt
    cpt+=1
    return experience.compare(m1,m2)

# STRATEGY 1
def negative_markers1(markers,positive):
    """
    Computes the list of negative markers from the list of markers and
    the list of positive markers.

    :param markers: The list of markers
    :type markers: List of String
    :param positive: The list of positive markers
    :type positive: List of String
    :return: The list of negative markers
    :rtype: List of String
    """
    global op
    global cpt
    op = 0
    cpt = 0
    negative = []
    for i in markers:
        in_pos = False
        for j in positive:
            if (compare(i,j) == 0):
                in_pos = True
                op += 1
                break
        if not in_pos:
            negative.append(i)
    #print("Nbre Opération: ", op)
    #print("Nbre Compteur:", cpt)
    return negative,cpt,op

# STRATEGY 2
def recherche_dichotomique(element, liste_triee):
    """
    Do a dichotimic reserach for element in the sorted list

    :param element: the element research
    :type element: String
    :param liste_triee: the sorted list
    :type liste_triee: list
    :return: the position of the element in the sorted list
    :rtype: int
    """
    global op
    global cpt
    a = 0
    b = len(liste_triee)-1
    m = (a+b) // 2
    op += 1
    while a < b:
        if compare(liste_triee[m], element) == 0:
            return m
        elif compare(liste_triee[m], element) == 1:
            op += 1
            b = m-1
        else:
            op += 1
            a = m + 1
        m = (a+b) // 2
        op += 1
    return a

def negative_markers2(markers,positive):
    """
    Computes the list of negative markers from the list of markers and
    the list of positive markers.
    And the list positive is sort.

    :param markers: The list of markers
    :type markers: List of String
    :param positive: The list of positive markers
    :type positive: List of String
    :return: The list of negative markers
    :rtype: List of String
    """
    global cpt
    global op
    op = 0
    cpt = 0
    positive = sorting.merge_sort(positive, experience.compare)
    negative = []
    for i in markers:
        if positive[recherche_dichotomique(i, positive)] != i:
            negative.append(i)
    #print("Nbre Opération: ", op)
    #print("Nbre Compteur:", cpt)
    return negative,cpt,op

# STRATEGY 3
def negative_markers3(markers,positive):
    """
    Computes the list of negative markers from the list of markers and
    the list of positive markers.
    And the list markers and positive is sort.

    :param markers: The list of markers
    :type markers: List of String
    :param positive: The list of positive markers
    :type positive: List of String
    :return: The list of negative markers
    :rtype: List of String
    """
    global cpt
    global op
    op = 0
    cpt = 0
    positive = sorting.merge_sort(positive, experience.compare)
    negative = markers.copy()
    markers = sorting.merge_sort(markers, experience.compare)
    j = 0
    for i in positive:
        if compare(i, markers[j]) == 0:
            negative.remove(markers[j])
            j += 1
            op += 1
        else:
            while compare(i, markers[j]) != 0 or j == len(markers):
                j += 1
                op += 1
            if compare(i,markers[j]) == 0:
                negative.remove(i)
    #print("Nbre Opération: ", op)
    #print("Nbre Compteur:", cpt)
    return negative,cpt,op

#File

def file(n,name_file):
    """
    Create a name_file.dat

    :param n:
    :type n: int
    :param name_file: name file
    :type name_file: string
    """
    file = open(name_file,"w")
    markers = []
    positive = []
    for i in range(1, n+1):
        markers.append(str(i))
    for j in range (1, n+1):
        positive.append(str(j))
        aux = str(n)+" "+str(j)+"  "+str(negative_markers1(markers,positive)[2])+"  "+str(negative_markers2(markers,positive)[2])+"  "+str(negative_markers3(markers,positive)[2])+"\n"
        file.write(aux)
    file.close()

def f():
    """
    Execut file(n,name_file)
    """
    file(10,"tp1-10.dat")
    file(20,"tp1-20.dat")
    file(30,"tp1-30.dat")
    file(40,"tp1-40.dat")
    file(50,"tp1-50.dat")
    file(60,"tp1-60.dat")
    file(70,"tp1-70.dat")
    file(80,"tp1-80.dat")
    file(90,"tp1-90.dat")
    file(100,"tp1-100.dat")

if __name__ == "__main__":
    p = int(sys.argv[1])
    m = int(sys.argv[2])

    markers = experience.markers(m)
    positive = experience.experience(p,markers)

    print("")
    print("Markers: %s" % (markers))
    print("Positive markers: %s" % (positive))
    print("===============================================================")

    # test stategy 1
    cpt = 0
    print("Test STRATEGY 1")
    print("Negative markers: %s" % (negative_markers1(markers,positive)[0]))
    print("Nb. comparisons: %d" % (negative_markers1(markers,positive)[1]))
    print("Nb. opértions: %d" % (negative_markers1(markers,positive)[2]))
    print("===============================================================")

    # test stategy 2
    cpt = 0
    print("Test STRATEGY 2")
    print("Negative markers: %s" % (negative_markers2(markers,positive)[0]))
    print("Nb. comparisons: %d" % (negative_markers2(markers,positive)[1]))
    print("Nb. opérations: %d" % (negative_markers2(markers,positive)[2]))
    print("===============================================================")

    # test stategy 3
    cpt = 0
    print("Test STRATEGY 3")
    print("Negative markers: %s" % (negative_markers3(markers,positive)[0]))
    print("Nb. comparisons: %d" % (negative_markers3(markers,positive)[1]))
    print("Nb. opértions: %d" % (negative_markers3(markers,positive)[2]))
    print("")

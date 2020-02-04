# -*- coding: utf-8 -*-

import listiterator as list

def print_with_iterator (l):
    """
    Print elements of a list using an iterator.

    :param l: The list to be printed
    :type l: dict
    """
    it = list.get_listiterator(l)
    while (list.hasNext(it)):
        print(list.next(it),end=' ')
    return print(end = '\n')

def print_with_iterator_reverse (l):
    """
    Print elements of a list using an iterator in reverse order.

    :param l: The list to be printed
    :type l: dict
    """
    it = list.get_listiterator(l,True)
    while (list.hasPrevious(it)):
        print(list.previous(it),end=' ')
    return print(end = '\n')

def print_with_iterator_reverse_bis (l):
    """
    Print elements of a list using an iterator in reverse order.

    :param l: The list to be printed
    :type l: dict
    """
    it = list.get_listiterator(l,True)
    print(it['prev']['next']['value'], end =' ')
    while (list.hasPrevious(it)):
        print(list.previous(it),end=' ')
    return print(end = '\n')    

def ordering_insert (l, v):
    """
    Add *v* to list *l* such that *l* is kept ordered.

    :param l: An ordered list.
    :type l: dict
    :param v: The value to be inserted.
    :type v: same as elements of *l*
    """
    it = list.get_listiterator(l)
    while(list.hasNext(it) and it['next']['value']<v):
        list.next(it)
    list.add(it,v)

if __name__ == "__main__":
    l = list.empty_list ()
    for i in reversed(range(1,5)):
        list.cons(l,i)

    print("Test print_list()")
    list.print_list(l);
    print("\n")

    print("Test 0")
    # test 0 : impression renversee
    print("Test print_list(with reverse = True)")
    list.print_list(l,reverse=True)
    print("\n")

    print("Test 1")
    # test 1 : impression avec iterateurs
    print("Test print_with_iterator()")
    print_with_iterator(l)
    print("Test print_with_iterator_reverse()")
    print_with_iterator_reverse(l)
    print("\n")

    print("Test add()")
    print("Test 2")
    # test 2 : insertion avant le 3eme element
    it = list.get_listiterator (l)
    print(list.next(it))
    print(list.next(it))
    list.add(it,23)
    assert(list.previous(it) == 23)
    print_with_iterator(l)
    print_with_iterator_reverse(l)
    print("\n")

    print("Test 3")
    # test 3 : insertion apres le dernier element
    it = list.get_listiterator (l)
    while (list.hasNext(it)):
        list.next(it)
    list.add(it,45)
    assert(list.previous(it) == 45)
    print_with_iterator(l)
    print_with_iterator_reverse(l)
    print("\n")

    print("Test 4")
    #test 4 : insertion avant le premier element
    it = list.get_listiterator (l)
    list.add(it,0)
    assert(list.previous(it) == 0)
    print_with_iterator(l)
    print_with_iterator_reverse(l)
    print("\n")

    print("Test 5")
    # test 5 : insertion avant le dernier element avec l'iterateur placé en fin
    it = list.get_listiterator (l,True)
    list.previous(it)
    list.add(it,445)
    assert(list.previous(it) == 445)
    print_with_iterator(l)
    print_with_iterator_reverse(l)
    print("\n")

    print("Test 6")
    # test 6 : affichage à l'envers avec l'itérateur placé en fin
    print_with_iterator_reverse_bis(l)
    print("\n")

    print("Test 7")
    # test 7 : ajout après le dernier élément
    it = list.get_listiterator (l,True)
    list.add(it,5)
    assert(list.previous(it) == 5)
    print_with_iterator(l)
    print_with_iterator_reverse(l)
    print("\n")

    print("Test 8")
    # test 8 : inserer trié, à vous d'écrire ce test
    l2 = list.empty_list ()
    for i in reversed(range(1,10)):
        list.cons(l2,i)
    ordering_insert (l2,11)
    list.print_list(l2);
    print("\n")

    print("Test 9")
    # test 9 : suppression en tete
    it = list.get_listiterator (l2)
    list.remove(it)
    print_with_iterator(l2)
    print("\n")
    
    print("Test 10")
    # test 10 : suppression en queue
    it = list.get_listiterator (l2)
    while (list.hasNext(it)):
        list.next(it)
        
    list.remove(it)
    list.remove(it)
    list.remove(it)
    print_with_iterator(l2)
    print("\n")

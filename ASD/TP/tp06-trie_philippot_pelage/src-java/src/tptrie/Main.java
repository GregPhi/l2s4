package tptrie;

import tptrie.trie.* ;
import tptrie.*;
import java.util.*;

/**
 * Class Main
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version 1.5
 */

public class Main {

  /**
   * Main
   *
   * @param args[] : (type-String)
   */
   public static void main (String args[]) {
     System.out.println("Main of TP 6 : ");
     Scanner s = new Scanner(System.in);
     System.out.println("- T for Trie.");
     System.out.println("- C for CompactTrie.");
     System.out.println("- D for test Trie and CompactTrie.");
     System.out.println("- MT to test Trie and you choose the number of words to add and you add them.");
     System.out.println("- MC to test Trie and you choose the number of words to add and you add them.");
     System.out.println("- Nothing for quit.");
     String tp = s.nextLine();
     switch(tp){
      case "T":
        Trie t1 = new Trie();
        t1.add("banane");
        t1.add("ci");
        t1.add("citronnier");
        t1.add("citron");
        t1.add("poire");
        t1.add("pomme");
        t1.print();
        break;
      case "C":
        CompactTrie ct1 = new CompactTrie();
        ct1.add("banane");
        ct1.add("ci");
        ct1.add("citronnier");
        ct1.add("citron");
        ct1.add("poire");
        ct1.add("pomme");
        ct1.print();
        break;
      case "D":
        Trie t2 = new Trie();
        t2.add("banane");
        t2.add("ci");
        t2.add("citronnier");
        t2.add("citron");
        t2.add("poire");
        t2.add("pomme");
        t2.print();
        System.out.println("\n");
        CompactTrie ct2 = new CompactTrie();
        ct2.add("banane");
        ct2.add("ci");
        ct2.add("citronnier");
        ct2.add("citron");
        ct2.add("poire");
        ct2.add("pomme");
        ct2.print();
        break;
      case "MT":
        Trie t = new Trie();
        Scanner n1 = new Scanner(System.in);
        System.out.println("Number world to add to this Trie.");
        Integer n = n1.nextInt();
        for(int i = 0; i < n; i++){
          Scanner w1 = new Scanner(System.in);
          System.out.println("World to add to this Trie.");
          String w = w1.nextLine();
          t.add(w);
        }
        t.print();
        break;
      case "MC":
        CompactTrie ct = new CompactTrie();
        Scanner n2 = new Scanner(System.in);
        System.out.println("Number world to add to this CompactTrie.");
        Integer nn = n2.nextInt();
        for(int i = 0; i < nn; i++){
          Scanner w2 = new Scanner(System.in);
          System.out.println("World to add to this CompactTrie.");
          String w3 = w2.nextLine();
          ct.add(w3);
        }
        ct.print();
        break;
      default:
        break;
    }
  }
}

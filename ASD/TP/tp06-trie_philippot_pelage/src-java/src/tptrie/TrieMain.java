package tptrie;

import tptrie.trie.Trie ;

/**
 * Class TrieMain
 *
 * @author : Fil Lille 1, Philippot Gregoire and Pelage François-Xavier
 * @version 1.5
 */

public class TrieMain {

  /**
   * Main Trie
   *
   * @param args[] : (type-String)
   */
   public static void main (String args[]) {

      Trie t = new Trie();
      System.out.println("Test Trie : ");
      System.out.println("Add banane : ");
      t.add("banane");
      System.out.println("\n");
      //System.out.println("test contains banane : "+t.contains("banane"));
      t.print();
      System.out.println("\n");
      System.out.println("Add citronnier : ");
      t.add("citronnier");
      t.print();
      System.out.println("\n");
      System.out.println("Add citron : ");
      t.add("citron");
      t.print();
      System.out.println("\n");
      System.out.println("Add pomme : ");
      t.add("pomme");
      t.print();
      System.out.println("\n");
      System.out.println("Add poire : ");
      t.add("poire");
      t.print();
      System.out.println("\n");
      System.out.println("Add ci : ");
      t.add("ci");
      t.print();
      System.out.println("\n");
      //t.print();
   }
}

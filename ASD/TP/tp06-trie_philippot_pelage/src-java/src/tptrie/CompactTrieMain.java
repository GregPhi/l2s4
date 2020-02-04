package tptrie;

import tptrie.trie.CompactTrie ;

/**
 * Class CompactTrieMain
 *
 * @author : Fil Lille 1, Philippot Gregoire and Pelage François-Xavier
 * @version 1.5
 */

public class CompactTrieMain {

  /**
   * Main CompactTrie
   *
   * @param args[] : (type-String)
   */
   public static void main (String args[]) {

      CompactTrie t = new CompactTrie();
      System.out.println("Test CompactTrie : ");
      System.out.println("Add banane : ");
      t.add("banane");
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
      //System.out.println("po : "+t.contains("po"));
      System.out.println("\n");
      System.out.println("Add ci : ");
      t.add("ci");
      t.print();
   }
}

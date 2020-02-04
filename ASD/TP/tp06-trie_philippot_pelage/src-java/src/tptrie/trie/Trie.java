package tptrie.trie;

import java.util.Map;
import java.util.TreeMap;
import java.io.*;

/**
 * Clss Trie
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class Trie {

   //ATTRIBUTS
   /* Map */
   private TreeMap<Character,Trie> map;
   /* End */
   private boolean end;

   public Trie() {
      this.map = new TreeMap<Character,Trie>();
      this.end = false;
   }

   /**
    * Add a word in a Trie object
    *
    * @param word : (type-String)
    */
   public void add(String word){
     if(word.length()==0){
        this.end=true;
        //System.out.println("length = 0 : "+this.end);
     }else{
       if(this.map.containsKey(word.charAt(0))){
         //System.out.println("charAt : "+word.charAt(0)+" "+this.end);
         this.map.get(word.charAt(0)).add(word.substring(1));
       }else{
         //System.out.println("charAt : "+word.charAt(0)+" "+this.end);
         this.map.put(word.charAt(0),new Trie());
         this.map.get(word.charAt(0)).add(word.substring(1));
       }
     }
   }

   /**
    * Check if <code>word</code> is in Trie object
    *
    * @param word : (type-String)
    * @return : (type-boolean)
    */
   public boolean contains (String word) {
     if(word.length()==0){
       return this.end;
     }else{
       if(!(this.map.containsKey(word.charAt(0)))){
         return false;
       }else{
         return this.map.get(word.charAt(0)).contains(word.substring(1));
       }
     }
   }

   /**
    * Display the Trie
    */
   public void print () {
     System.out.println("digraph G {");
     int cpt = 0;
     this.print_aux(cpt);
     System.out.println("}");
   }

   /**
    * Display
    *
    * @param ind (type-int)
    * @return (type-int)
    */
  public int print_aux(int ind){
    if(this.end){
      System.out.println(ind+" [style=filled,color=blue]");
    }else{
      System.out.println(ind+" [style=filled,color=pink]");
    }
    if(this.map.keySet().size()==0){
      return ++ind;
    }else{
      int aux = ind;
      ind++;
      for(char c : this.map.keySet()){
        if(this.map.keySet().size()==1){
          System.out.println(aux+" -> "+ind+"[label=\""+c+"\"];");
        }else{
          System.out.println(aux+" -> "+ind+"[label=\""+c+"\"];");
        }
        ind = this.map.get(c).print_aux(ind);
      }
      return ind;
    }
  }
}

package tptrie.trie;

import java.util.Map;
import java.util.HashMap;

/**
 * Class CompactTrie
 *
 * @author : Philippot Gregoire and Pelage François-Xavier
 * @version : 1.0
 */

public class CompactTrie {

  //ATTRIBUTS
  /* End of CompactTrie */
   private boolean end;
  /* Map */
   private HashMap<String, CompactTrie> map;

  /**
   * Create a CompactTrie
   */
   public CompactTrie () {
    this.end = false;
    this.map = new HashMap<String, CompactTrie>();
   }

   /**
    * Return the number of letter that are common between the two words.
    *
    * @param word the word that we want to compare with a word in CompactTrie
    * @param wordInTrie a word in CompactTrie
    * @return the number of common letter
    *
    */
   public int commonLetters(String word, String wordInTrie){
     int cpt = 0;
     int letterTotest;
     boolean common = true;
     if(word.length()>wordInTrie.length()){
       letterTotest = wordInTrie.length();
     }else{
       letterTotest = word.length();
     }
     while(cpt < letterTotest && common){
       common = word.charAt(cpt) == wordInTrie.charAt(cpt);
       cpt++;
     }
     if(common){
       return cpt;
     }else{
       return cpt-1;
     }
   }

   /**
    * Add a word in a CompactTrie object
    *
    * @param word : (type-String)
    */
   public void add (String word) {
    boolean same = false;
    String tmp = "";
    int letterCommon = 0;
    for(String tmpStr : this.map.keySet()){
      if(tmpStr.charAt(0) == word.charAt(0)){
        same = true;
        tmp = tmpStr;
        break;
      }
    }
    if(same){
      letterCommon = commonLetters(word, tmp);
      if(letterCommon < tmp.length()){
        String newNode = word.substring(0, letterCommon);
        this.map.put(newNode, new CompactTrie());
        //System.out.println("newNowe : "+newNode);
        CompactTrie tmpC = this.map.get(tmp);
        this.map.remove(tmp);
        this.map.get(newNode).map.put(tmp.substring(letterCommon), tmpC);
        //System.out.println("tmp.substring(letterCommon) : "+tmp.substring(letterCommon));
        if(word.length() == letterCommon){
          this.map.get(newNode).end = true;
        }else{
          String tmp2 = word.substring(letterCommon);
          this.map.get(newNode).add(tmp2);
          //System.out.println(tmp2);
          //this.map.get(newNode).end = true;
        }
      }else{
        this.map.get(tmp).add(word.substring(tmp.length()));
        //System.out.println(tmp);
        //this.map.get(tmp).end = true;
      }
    }else{
      this.map.put(word, new CompactTrie());
      //System.out.println("word : "+word);
      this.map.get(word).end = true;
    }
   }

   /**
   * Check if <code>word</code> is in CompactTrie object
   *
   * @param word : (type-String)
   * @return : (type-boolean)
    */
   public boolean contains (String word) {
    boolean same = false;
    String tmp = "";
    int letterCommon = 0;
    for(String tmpStr : this.map.keySet()){
      if(tmpStr.charAt(0) == word.charAt(0)){
        same = true;
        tmp = tmpStr;
        break;
      }
    }
    if(same){
      letterCommon = commonLetters(word, tmp);
      if(letterCommon == tmp.length()){
        if(word.length() > letterCommon){
          return this.map.get(tmp).contains(word.substring(letterCommon));
        }else if(word.equals(tmp)){
          return true;
        }
      }
    }
    return false;
   }


   /**
    * Display the CompactTrie
    */
   public void print () {
     System.out.println("digraph G{");
     int cpt = 0;
     this.print_aux(cpt);
     System.out.println("}");
   }

   /**
   * Display the CompactTrie
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
       for(String i : this.map.keySet()){
         if(this.map.keySet().size()==1){
           System.out.println(aux+" -> "+ind+" [label=\""+i+"\"];");
         }else{
           System.out.println(aux+" -> "+ind+" [label=\""+i+"\"];");
         }
         ind = this.map.get(i).print_aux(ind);
       }
       return ind;
     }
   }
}

package tp03_partie1_philippot;

import java.util.*;
import java.io.*;

import Stock.*;

public class SomeClass{
  public static void main(String[] args){
    System.out.println("Create a Stock, and test many different function.");
    Stock s1 = new Stock(10);
    System.out.println(s1.toString());
    System.out.println("------------------------");
    s1.add(20);
    System.out.println(s1.toString());
    System.out.println("------------------------");
    s1.remove(5);
    System.out.println(s1.toString());
    System.out.println("------------------------");
    s1.remove(30);
    System.out.println(s1.toString());
    System.out.println("------------------------");
  }
}

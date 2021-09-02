package org.antry;

public class Question {
   static abstract class Human {
 
           }
 
           static class Man extends Human {
 
           }
 
           static class Woman extends Human {
 
           }
 
           public void sayHello(Human guy) {
      System.out.println("hello , guy!");
   }
 
           public void sayHello(Man guy) {
      System.out.println("hello , gentle!");
   }
 
           public void sayHello(Woman guy) {
      System.out.println("hello , ladly!");
   }
 
           public static void main(String[] args) {
      Human man = new Man();
      Human woman = new Woman();
      Question sr = new Question();
      sr.sayHello(man);
      sr.sayHello(woman);
   }
}
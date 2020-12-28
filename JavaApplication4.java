/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Scanner;


import java.util.Scanner;


/**
 *
 * @author Hazem
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
 Scanner s = new Scanner (System.in);

System.out.println("\t\t *Welcome to file allocation program* " ); 
     FileAllo y=new FileAllo();
                        System.out.println("Please enter the memory size: ");
    while (!s.hasNextInt()){
             System.out.println("Invalid input , please enter an Integer");
             s.next();
         }
      y.memorySize=(s.nextInt());
     y.x = new FileAllo[y.memorySize];
     for(int i=0; i< y.x.length;i++)
{
    y.x[i]=new FileAllo();

}
      int choice;
           y.menu2();
            choice = s.nextInt();
     do {
   
         switch (choice){
             case 1 : //CONTIGUOUS ALLOCATION
  
         int option;
         y.start();
         do {
         y.menu();
         System.out.println("Enter your choice");
       while (!s.hasNextInt()){
             System.out.println("Invalid input , please enter a valid choice from 1 to 6");
             s.next();
         }
           option = s.nextInt();
         while(option>6 | option<1){
             System.out.println("Invalid input , please enter a valid choice from 1 to 6");
             option=s.nextInt();
         }
        switch (option) {
            case 1 : 
                String fileName;
        int fileSize;
                System.out.println("Enter file name :");
     fileName = s.next();
     System.out.println("Enter file size :");
     while (!s.hasNextInt()){
             System.out.println("Invalid input , please enter an Integer.");
             s.next();
         }
     fileSize = s.nextInt();
     y.insert(fileName, fileSize); 
     y.show2();
     break;
            case 2 : 
                 System.out.println("Enter file name to be removed");
       String name;
       name = s.next();
       y.delete (name);
       y.show2();
       break;
            case 3 :
                y.show3();
                 break;
            case 4 :
                y.show2();
                break;
            case 5:
                y.menu2();
                choice = s.nextInt();
                break;
            case 6:
                System.out.println("GOODBYE!");
                System.exit(0);
                break;
        }
        }
        while (option != 5 && option!= 6);
         break;
         // START OF LINKED ALLOCATION 
         
          case 2:
            int option2;
         y.start();
         do {
         y.menu3();
         System.out.println("Enter your choice");
       while (!s.hasNextInt()){
             System.out.println("Invalid input , please enter a valid choice from 1 to 6");
             s.next();
         }
           option2 = s.nextInt();
         while(option2>6 | option2<1){
             System.out.println("Invalid input , please enter a valid choice from 1 to 6");
             option2=s.nextInt();
         }
        switch (option2) {
            case 1 : 
                String fileName;
        int fileSize;
                System.out.println("Enter file name :");
     fileName = s.next();
     System.out.println("Enter file size :");
     while (!s.hasNextInt()){
             System.out.println("Invalid input , please enter an Integer.");
             s.next();
         }
     fileSize = s.nextInt();
     y.insert2(fileName, fileSize); 
     y.show2();
     break;
            case 2 : 
                 System.out.println("Enter file name to be removed");
       String name;
       name = s.next();
       y.delete2 (name);
       y.show2();
       break;
            case 3 :
                y.show();
                 break;
            case 4 :
                y.show5();
                break;
            case 5:
                y.menu2();
                choice = s.nextInt();
                break;
            case 6:
                System.out.println("GOODBYE!");
                System.exit(0);
                break;
        }
        }
        while (option2 != 5 && option2!= 6);  
         break;
        
        // START OF IDNEXED ALLOCATION
          case 3:
           int option3;
         y.start();
         do {
         y.menu4();
         System.out.println("Enter your choice");
       while (!s.hasNextInt()){
             System.out.println("Invalid input , please enter a valid choice from 1 to 5");
             s.next();
         }
           option3 = s.nextInt();
         while(option3>5 | option3<1){
             System.out.println("Invalid input , please enter a valid choice from 1 to 5");
             option3=s.nextInt();
         }
        switch (option3) {
            case 1 : 
                String fileName;
        int fileSize;
                System.out.println("Enter file name :");
     fileName = s.next();
     System.out.println("Enter file size :");
     while (!s.hasNextInt()){
             System.out.println("Invalid input , please enter an Integer.");
             s.next();
         }
     fileSize = s.nextInt();
     y.insert3(fileName, fileSize); 
     y.show2();
     break;
            case 2 : 
                 System.out.println("Enter file name to be removed");
       String name;
       name = s.next();
       y.delete3 (name);
       y.show2();
       break;
            case 3 :
                y.show4();
                 break;
            case 4 :
            y.menu2();
                choice = s.nextInt();
                break;
            case 5:
                 System.out.println("GOODBYE!");
                 System.exit(0);
                break;
        
        }
        }
        while (option3 != 4 && option3!= 5);  
         break;
     }
     }while (choice !=4);
    
    }
}
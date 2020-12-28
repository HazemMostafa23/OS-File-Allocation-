package javaapplication4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Hazem
 */
public class FileAllo {
    public class FileInfo{
        
       String fileName;
       int fileSize;
       int sPoint;
       int ePoint;
       ArrayList<Integer>Pointers;
       FileInfo(){
            }
       FileInfo(String fileName,int fileSize,int sPoint,int ePoint){
            
       this.fileName=fileName;
       this.fileSize=fileSize;
       this.sPoint=sPoint;
      this.ePoint=ePoint;
       }
        FileInfo(String fileName,int fileSize,int sPoint,int ePoint,ArrayList<Integer>Pointers){
            this.fileName=fileName;
       this.fileSize=fileSize;
       this.sPoint=sPoint;
      this.ePoint=ePoint;
      this.Pointers=Pointers;
        }
       }
    
 ArrayList<FileInfo> list = new ArrayList<FileInfo>();
 int memorySize;
 FileInfo obj2=new FileInfo();
 Scanner S=new Scanner(System.in);
    boolean check=true;
    int point;
  FileAllo [] x;
  ArrayList<Integer> free;
  ArrayList<Integer>Pointers;
  String points_to;
  
    void start(){
        
 for (int i=0;i<memorySize;i++)
 {
  x[i].check=false;
  x[i].point=-1;
  x[i].Pointers=new ArrayList<Integer>();
 }

    }
    boolean isAvail()
    {
        free=new ArrayList<Integer>(); 
      
        for (int i = 0; i <memorySize; i++)
        { int count=0;
         if(obj2.fileSize+i>x.length){
                break;
                }
            for (int j = i; j <obj2.fileSize+i; j++)
            {

                if (x[j].check == false)
            {
                count++;
                if(count==obj2.fileSize){
                free.add(i);
               
                }



           } else if(x[j].check==true){
               break;
           }
            }

        }
        if(free.size()>0){
            return true;
        }
        return false;
    }
  void insert(String fileName,int fileSize){
     obj2.fileName=fileName;
     obj2.fileSize=fileSize;
     int count=0;
   if(isAvail()==false){
       System.out.println("No space available");

   }
   else{
       Random number=new Random();
          int no;
 
     no=number.nextInt()%memorySize;
 while(no<0||free.contains(no)==false){
     no=number.nextInt()%memorySize;
 }
     
     for(int i=no;i<obj2.fileSize+no;i++)
     {
         x[i].obj2.fileName=obj2.fileName;
         x[i].check=true;
           count++;
           if(count==1){
               obj2.sPoint=no;
           }
     }
     
   
     obj2.ePoint=(obj2.sPoint+obj2.fileSize)-1;
       
list.add(new FileInfo(obj2.fileName,obj2.fileSize,obj2.sPoint,obj2.ePoint));
   }

  }
   boolean isAvail3(){
      free=new ArrayList<Integer>(); 
      
      for(int i=0;i<memorySize;i++){
          if(x[i].check==false){
              free.add(i);
          }
          
      }
      if(free.size()>=obj2.fileSize){
          return true;
      }
     else return false;
  }
  void insert3(String fileName,int fileSize){
      int count=0;
      obj2.fileName=fileName;
      obj2.fileSize=fileSize;
     
     
      if(isAvail3()==true){
          Random number=new Random();
          int no;
          int index2=0;
          int indexedblock=number.nextInt()%memorySize;
          while(indexedblock<0||x[indexedblock].Pointers.size()!=0){
          indexedblock=number.nextInt()%memorySize;
 }
     
 while(count!=fileSize){
     no=number.nextInt()%memorySize;

 while(no<0||free.contains(no)==false||no==indexedblock){
     no=number.nextInt()%memorySize;
 }
      x[no].check=true;
          x[no].obj2.fileName=obj2.fileName;
          int index=free.indexOf(no);
          free.remove(index);
         
          count++;
      if(count==1){
      obj2.sPoint=no;
                   }
      if(count>=1){ 
          x[index2].point=no;
          index2=no;
      }
      obj2.ePoint=no;
     x[indexedblock].Pointers.add(no);
     x[indexedblock].points_to=fileName;
     x[indexedblock].check=true;
    

     
      

 } 
 list.add(new FileInfo(obj2.fileName,obj2.fileSize,obj2.sPoint,obj2.ePoint));
       } 
      else 
      {
          System.out.println("No space available");
           System.out.println(free.size());
      }
      
      
  }
  
  void delete(String fileName){
      boolean check=false;
       for(int i=0;i<list.size();i++) { 
        if(list.get(i).fileName.equals(fileName)){
            obj2.fileName=list.get(i).fileName;
            obj2.fileSize=list.get(i).fileSize;
            obj2.sPoint=list.get(i).sPoint;
            obj2.ePoint=list.get(i).ePoint;
            list.remove(i);
            check=true;
       }  
     } 
       if(check==true){
          for(int i=obj2.sPoint;i<obj2.ePoint+1;i++)
          {
             x[i].check=false;
             x[i].obj2.fileName=null;
         }         
       }
       else if(check==false){
           System.out.println("The requested file doesn't exist");
           
       }
        
              
           
      
  }

    void delete3(String fileName){
      boolean check=false;
       for(int i=0;i<list.size();i++) { 
        if(list.get(i).fileName.equals(fileName)){
         fileName=list.get(i).fileName;
         
            list.remove(i);
            check=true;
       }  
     } 
       if(check==true){
           for(int i=0;i<memorySize;i++){ 
               if(fileName.equals(x[i].points_to)&&x[i].Pointers.size()>0){
                 
              System.out.println("lol");
                     x[i].Pointers.clear();
                   
                 
                   x[i].check=false;
                   x[i].obj2.fileName=null;
               }
               
           }
           
       }
    
       else if(check==false){
           System.out.println("The requested file doesn't exist");
           
       }
        
              
           
      
  }
     void menu()
 {
     System.out.println("*****************************************************");
     System.out.println("\t  CONTIGUOUS ALLOCATION MENU \t  ");
       System.out.println("*****************************************************");
     System.out.println("1. Add a file \n2. Delete a file\n3. Access all blocks\n4. Show table\n5. Change Allocation.\n6.Exit Application  ");
          System.out.println("*****************************************************");
     
 }
          void menu2()
 {
       System.out.println("Choose your file allocation method. ");
     System.out.println("**********");
     System.out.println(" MENU \t  ");
  System.out.println("**********");
     System.out.println("1. Contiguous Allocation \n2. Linked Allocation \n3. Indexed Allocation\n 4. Exit application  ");
  System.out.println("**********");
     
 }
   void menu3()
 {
     System.out.println("*****************************************************");
     System.out.println("\t LINKED ALLOCATION MENU \t  ");
     System.out.println("*****************************************************");
     System.out.println("1. Add a file \n2. Delete a file\n3. Access allocated blocks\n4. Show pointers' order\n5. Change Allocation.\n6.Exit Application  ");
     System.out.println("*****************************************************");
     
 }
   void menu4()
 {
     System.out.println("*****************************************************");
     System.out.println("\t INDEXED ALLOCATION MENU \t  ");
     System.out.println("*****************************************************");
     System.out.println("1. Add a file \n2. Delete a file\n3. Access index blocks\n4. Change Allocation\n5. Exit Application.  ");
      System.out.println("*****************************************************");
     
 }

  void show(){
      for(int i=0;i<memorySize;i++){
          if(x[i].obj2.fileName!=null){
          System.out.println("MEMORY BLOCK:"+ i+ " contains FILENAME:"+ x[i].obj2.fileName+" "+ "Points to "+x[i].point+" ");

      }
         

  }
      System.out.println("The unallocated blocks are hidden");
      
      
      
      
    
  }
  void show4()//INDEXED POINTERS 
  {
for(int i=0;i<memorySize;i++){
    if(x[i].Pointers.size()>0){
   System.out.println("Index  " + i + " holds the following pointers " + x[i].Pointers+ " to the file named "+x[i].points_to);
    }
  }
      
  }
  
}

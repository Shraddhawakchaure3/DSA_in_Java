//Name:-Sapike Sakshi Dinesh
//Roll no: 118 Div :- Sy B

import java.util.Scanner;
import java.util.LinkedList;
class HashOT{

    private int size;
    private LinkedList<Integer> [] table;
    //constructor
   public HashOT(int size){
         this.size=size;
         //initialize the size
         table = new LinkedList[size];
        for(int i=0;i<size;i++){
            table[i]=new LinkedList<>();
        }
    }

    public int hash(int key){
       return key%size;
    }
//insert
    public void insert(int data){
        int index=hash(data);
        table[index].add(data);
    }
    //display
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ":->");

            for(int j=0;j<table[i].size();j++){
            //for (Integer data : table[i]) {
              //  System.out.print(data + "->");
                System.out.print(table[i].get(j)+"->");
            }
            System.out.println("null");

        }

    }
    //search
    public boolean search(int key){
        int id=hash(key);
        return table[id].contains(key);

    }
}
public class Chaining {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        int  num,ch;
        System.out.println("Enter the size of Hashtable");
        int size=s.nextInt();

        HashOT h =new HashOT(size);

        System.out.println("Enter the total number of key");
        int key=s.nextInt();

        do{
            System.out.println("Enter your choice\n1.Insert.\n2.Display.\n3.Search ");
            ch=s.nextInt();
            switch(ch){
                case 1://insert
                    System.out.println("Enter the value of key");

                    for(int i=0;i<key;i++){
                    int data=s.nextInt();
                    h.insert(data);
                    }
                    break;
                case 2://display
                    h.display();
                break;
                case 3://search
                    System.out.println("enter the data to be  search ");
                    int d=s.nextInt();

                    if(h.search(d)){
                        System.out.println(d+" element found");
                    }
                    else{
                        System.out.println(d+" element not found");
                    }
                    break;
                default:
                    System.out.println(" Invalid choice");
            }
            System.out.println("Do you want to continue\n 1(Yes) \n2(NO)");
            num=s.nextInt();
        }while(num!=0);
    }
}

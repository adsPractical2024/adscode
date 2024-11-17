import java.util.*;

public class employeeLL {
    static node head;
    static node tail;
    static int size=0;

    static class node{
        String name;
        int id;
        node prev;
        node next;

        node(String name,int id){
            this.id=id;
            this.name=name;
        }
    }

    static void addfirst(Scanner sc){
        if(sc.hasNextLine()){
            sc.nextLine();
        }
        System.out.println("enter name");
        String name= sc.nextLine();
        System.out.println("enter id");
        int id=sc.nextInt();
        node n1 = new node(name, id);

        if(head==null){
            head=tail=n1;
            tail.next=head;
            head.prev=tail;
            return;
        }
        n1.next=tail.next;
        n1.prev=head.prev;
        tail.next=n1;
        head.prev=n1;
        head=n1;
        
        
    }

    static void addlast(Scanner sc){

        if(sc.hasNextLine()){
            sc.nextLine();
        }
        System.out.println("enter name");
        String name= sc.nextLine();
        System.out.println("enter id");
        int id=sc.nextInt();
        node n1 = new node(name, id);

        if(head==null){
            head=tail=n1;
            tail.next=head;
            head.prev=tail;
            return;
        }
        n1.next=head;
        n1.prev=tail;
        tail.next=n1;
        head.prev=n1;
        tail=n1;
    }

    static void addAtpos(Scanner sc){
        int curr=1;
        node temp=head;

        if(sc.hasNextLine()){
            sc.nextLine();
        }
        System.out.println("enter positon to enter");
        int pos =sc.nextInt();
        if(pos==1){
            addfirst(sc);
            return;
        }
        else if(curr<pos-1&&temp.next!=null){
            temp=temp.next;
            curr++;
        }

        if(temp==tail){
            addlast(sc);
            return;
        }
        if(sc.hasNextLine()){
            sc.nextLine();
        }
        System.out.println("enter name");
        String name= sc.nextLine();
        System.out.println("enter id");
        int id=sc.nextInt();
        node n1 = new node(name, id);

        temp.next.prev=n1;
        n1.next=temp.next;
        n1.prev=temp;
        temp.next=n1;    
    }

    static void deletefirst(){
        node temp =head;

        if(head==null){
            System.out.println("list is empty");
            return;
        }
        tail.next=head.next;
        head.next.prev=tail;
        head=head.next;

    }

    static void deletelast(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }

        head.prev=tail.prev;
        tail.prev.next=head;
        tail=tail.prev;
    }

    static void deleteatpos(Scanner sc){
        if (head==null) {
            System.out.println("list is empty");
            return;
        }
        System.out.println("enter index to delete");
        int ind = sc.nextInt();

        int pos=1;
        node temp=head;
        if(pos==1){
            
            deletefirst();
            return;
        }
        while(pos<ind-1&&temp!=null){
            temp=temp.next;
            pos++;
        }
        node curr= temp.next;
        if(curr==tail){
            deletelast();;
            return;
        }
        temp.next=curr.next;
        curr.next.prev=temp;
        curr.next=curr.prev=null;
    }

    static void printlist(){
        node temp=head;
        if(temp==null){
            return;
        }
        do{
            System.out.print(temp.name+",");
            System.out.print(temp.id+"-->");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
    }

    public static void main(String[] args) {
        
        int choice= 0;
        Scanner sc= new Scanner(System.in);
        
        while(choice!=-1){
            System.out.println("enter 1 to addfirst\n 2. to addlast\n 3.to add between \n4. to deletefirst \n5.to deletelast \n 7.to printlist");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addfirst(sc);
                    printlist();
                    break;
                case 2:
                    addlast(sc);
                    printlist();
                    break;

                case 3:
                    addAtpos(sc);
                    printlist();
                    break;
                case 4:
                    deletefirst();
                    printlist();
                    break;
                case 5:
                    deletelast();
                    printlist();
                    break;
                case 6:
                    deleteatpos(sc);
                    printlist();
                    break;
                case 7:
                    printlist();
                    break;
            
                default:
                    break;
            }
        }
    }
}

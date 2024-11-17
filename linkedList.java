import java.util.Scanner;

class linkedList{
    static Node head;
    
    static class Node{
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;
        }
    }

    public void printList(){

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp= temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    
    // add
    public Node addfirst(Scanner sc){

        String data;
        
        System.out.println("Enter data to enter");

        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        data = sc.nextLine();
        Node n1 = new Node(data);
        if(head==null){
            head=n1;
            return n1;
        }
        n1.next=head;
        head=n1;
        System.out.println("data is entered");
        return n1;
    }

    public Node addLast(Scanner sc){

        System.out.println("Enter data to enter");
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        String data = sc.nextLine();
        Node n1= new Node(data);
        if(head==null){
            n1=head;
            return n1;
        }

        

        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=n1;
        return n1;

    }

    public Node addAfterNode(Scanner sc){

        System.out.println("Enter index at which to insert");
        
        int prev = sc.nextInt();
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        System.out.println("Enter data to enter");
        String data = sc.nextLine();
        Node n1 = new Node(data) ;
        if (head== null){
            n1= head;
            return n1;
        }
        int x=1;

        Node temp =head;
        while(temp.next!=null&&x<prev-1){
            temp=temp.next;
            x++;

        }
        n1.next=temp.next;
        temp.next=n1;
        return n1;
        
    }

    //delete
    public void deletefirst(){
        Node temp =head;
        if(head==null){
            System.out.println("deleteion cant be performed");
            return;
        }
        head = temp.next;

    }

    public void deleteLast(){
        Node temp = head;
        if (head==null){
            System.out.println("Deletion cant be performed");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        while(temp.next.next!=null){
            temp=temp.next;
        }
        //System.out.println(temp.data);
        temp.next=null;
    }

    public void deleteAfter(Scanner sc){
        
        System.out.println("enter index whic is to be deleted");
        int i = sc.nextInt();
        int x=1;

        if (head==null){
            System.out.println("Deletion cant be performed");
            return;
        }

        Node n1 = head;

        while(n1!=null&&x<i-1){
            n1=n1.next;
            x++;
        }

        n1.next =n1.next.next;
    }

    public void deleteThis(Node n1){
        if (head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp =head;
        while(temp.next!=n1){
            temp=temp.next;
        }
        temp.next=n1.next;
    }

    public static void main(String[] args) {
        linkedList L = new linkedList();
        Scanner sc = new Scanner(System.in);
        

        int choice = 0;

        while(choice!=-1){
            System.out.println("put 1 to create or add in list");
            System.out.println("put 2 to addlast in list");
            System.out.println("put 3 to add after node");
            System.out.println("put 4 to deleteFirst element");
            System.out.println("put 5 to deletelast element");
            System.out.println("put 6 to delete sepecific node");
            System.out.println("put 7 to print list");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    L.addfirst(sc);
                    L.printList();
                    break;
                
                case 2:
                    L.addLast(sc);
                    L.printList();
                    break;

                case 3:
                    L.addAfterNode(sc);
                    L.printList();
                    break;

                case 4:
                    L.deletefirst();
                    L.printList();
                    break;

                case 5:

                    L.deleteLast();;
                    L.printList();

                    break;
                
                case 6:
                    L.deleteAfter(sc);
                    L.printList();


                case 7:
                    L.printList();
                    break;

                case 8:
                    System.out.println("head is "+L.head.data);

                    break;


            }
        }


        
    }
}
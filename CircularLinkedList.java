import java.util.Scanner;

public class CircularLinkedList {
    Node head;

    static class Node {
        Employee data;
        Node next;

        Node(Employee emp) {
            data = emp;
            next = null;
        }
    }

    static class Employee {
        int empId;
        String empName;

        Employee(int id, String name) {
            empId = id;
            empName = name;
        }
    }

    public void insertAtBeginning(Employee emp) {
        Node newNode = new Node(emp);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtEnd(Employee emp) {
        Node newNode = new Node(emp);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void insertAtSpecificLocation(Employee emp, int position) {
        if (position == 0) {
            insertAtBeginning(emp);
            return;
        }
        Node newNode = new Node(emp);
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        Node prev = null;
        while (temp.next != head) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = head;
    }

    public void deleteSpecificNode(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 0) {
            deleteFromBeginning();
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.println("Employee ID: " + temp.data.empId + ", Employee Name: " + temp.data.empName);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Insert At Beginning");
            System.out.println("2. Insert At End");
            System.out.println("3. Insert At Specific Location");
            System.out.println("4. Delete From Beginning");
            System.out.println("5. Delete From End");
            System.out.println("6. Delete Specific Node");
            System.out.println("7. Display");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.next();
                    list.insertAtBeginning(new Employee(id, name));
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    int id2 = scanner.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String name2 = scanner.next();
                    list.insertAtEnd(new Employee(id2, name2));
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    int id3 = scanner.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String name3 = scanner.next();
                    System.out.print("Enter Position: ");
                    int pos = scanner.nextInt();
                    list.insertAtSpecificLocation(new Employee(id3, name3), pos);
                    break;
                case 4:
                    list.deleteFromBeginning();
                    break;
                case 5:
                    list.deleteFromEnd();
                    break;
                case 6:
                    System.out.print("Enter Position to delete: ");
                    int pos2 = scanner.nextInt();
                    list.deleteSpecificNode(pos2);
                    break;
                case 7:
                    list.display();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }
}

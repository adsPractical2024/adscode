import java.util.Scanner; 
 
class Employee { 
    int empId; 
    String empName; 
    Employee next; 
 
    public Employee(int empId, String empName) { 
        this.empId = empId; 
        this.empName = empName; 
        this.next = null; 
    } 
} 
 
class EmployeeLinkedList { 
    Employee head; 
 
    public EmployeeLinkedList() { 
        this.head = null; 
    } 
 
    public void insert(int empId, String empName) { 
        Employee newEmployee = new Employee(empId, empName); 
        if (head == null) { 
            head = newEmployee; 
        } else { 
            Employee temp = head; 
            while (temp.next != null) { 
                temp = temp.next; 
            } 
            temp.next = newEmployee; 
        } 
    } 
 
    public void delete(int empId) { 
        if (head == null) { 
            System.out.println("List is empty"); 
            return; 
        } else if (head.empId == empId) { 
            head = head.next; 
        } else { 
            Employee temp = head; 
            while (temp.next != null && temp.next.empId != empId) { 
                temp = temp.next; 
            } 
            if (temp.next == null) { 
                System.out.println("Employee not found"); 
            } else { 
                temp.next = temp.next.next; 
            } 
        } 
    } 
 
    public void search(int empId) { 
        Employee temp = head; 
        boolean found = false; 
        while (temp != null) { 
            if (temp.empId == empId) { 
                System.out.println("Employee found: " + temp.empName); 
                found = true; 
                break; 
            } 
            temp = temp.next; 
        } 
        if (!found) { 
            System.out.println("Employee not found"); 
        } 
    } 
 
    public void modify(int empId, String newEmpName) { 
        Employee temp = head; 
        boolean modified = false; 
        while (temp != null) { 
            if (temp.empId == empId) { 
                temp.empName = newEmpName; 
                System.out.println("Employee details modified"); 
                modified = true; 
                break; 
            } 
            temp = temp.next; 
        } 
        if (!modified) { 
            System.out.println("Employee not found"); 
        } 
    } 
 
    public void display() { 
        Employee temp = head; 
        while (temp != null) { 
            System.out.println("Employee ID: " + temp.empId + ", Employee Name: " + 
temp.empName); 
            temp = temp.next; 
        } 
    } 
} 
 
public class Assignment1 { 
    public static void main(String[] args) { 
        EmployeeLinkedList employeeList = new EmployeeLinkedList(); 
        Scanner scanner = new Scanner(System.in); 
        int choice; 
        do { 
            System.out.println("1. Insert Employee\n2. Delete Employee\n3. Search Employee\n4. Modify Employee\n5. Display Employees\n6. Exit"); 
            System.out.print("Enter your choice: "); 
            choice = scanner.nextInt(); 
            switch (choice) { 
                case 1: 
                    System.out.print("Enter Employee ID: "); 
                    int empId = scanner.nextInt(); 
                    System.out.print("Enter Employee Name: "); 
                    scanner.nextLine(); 
                    String empName = scanner.nextLine(); 
                    employeeList.insert(empId, empName); 
                    break; 
                case 2: 
                    System.out.print("Enter Employee ID to delete: "); 
                    empId = scanner.nextInt(); 
                    employeeList.delete(empId); 
                    break; 
                case 3: 
                    System.out.print("Enter Employee ID to search: "); 
                    empId = scanner.nextInt(); 
                    employeeList.search(empId); 
                    break; 
                case 4: 
                    System.out.print("Enter Employee ID to modify: "); 
                    empId = scanner.nextInt(); 
                    System.out.print("Enter new Employee Name: "); 
                    scanner.nextLine(); 
                    empName = scanner.nextLine(); 
                    employeeList.modify(empId, empName); 
                    break; 
                case 5: 
                    employeeList.display(); 
                    break; 
                case 6: 
                    System.out.println("Exiting..."); 
                    break; 
                default: 
                    System.out.println("Invalid choice. Please try again."); 
            } 
        } while (choice != 6); 
        scanner.close(); 
    } 
}

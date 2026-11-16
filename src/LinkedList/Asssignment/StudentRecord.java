package LinkedList.Asssignment;
import java.util.Scanner;
public class StudentRecord {
    static class Node {
        int rollNo;
        String name;
        int age;
        String grade;
        Node next;
        Node(int rollNo, String name, int age, String grade) {
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    public static Node head = null;
    public static void addAtBeginning(int rollNo, String name, int age, String grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        newNode.next = head;
        head = newNode;
    }
    public static void addAtEnd(int rollNo, String name, int age, String grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public static void addAtPosition(int rollNo, String name, int age, String grade, int position) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }
        Node newNode = new Node(rollNo, name, age, grade);
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public static Node search(int rollNo) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public static void delete(int rollNo) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted");
        }
    }
    public static void display() {
        if (head == null) {
            System.out.println("No records found");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNo);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.println("Grade: " + temp.grade);
            System.out.println("-------------------");
            temp = temp.next;
        }
    }
    public static void updateGrade(int rollNo, String grade) {
        Node student = search(rollNo);
        if (student == null) {
            System.out.println("Student not found");
        } else {
            student.grade = grade;
            System.out.println("Grade updated");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Display Students");
            System.out.println("7. Update Grade");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                System.out.print("Enter Roll Number: ");
                int rollNo = sc.nextInt();

                System.out.print("Enter Name: ");
                String name = sc.next();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                System.out.print("Enter Grade: ");
                String grade = sc.next();

                if (choice == 1) {
                    addAtBeginning(rollNo, name, age, grade);
                } else if (choice == 2) {
                    addAtEnd(rollNo, name, age, grade);
                } else {
                    System.out.print("Enter Position: ");
                    int position = sc.nextInt();
                    addAtPosition(rollNo, name, age, grade, position);
                }
            } else if (choice == 4) {
                System.out.print("Enter Roll Number: ");
                int rollNo = sc.nextInt();
                delete(rollNo);
            } else if (choice == 5) {
                System.out.print("Enter Roll Number: ");
                int rollNo = sc.nextInt();

                Node student = search(rollNo);

                if (student == null) {
                    System.out.println("Student not found");
                } else {
                    System.out.println("Roll Number: " + student.rollNo);
                    System.out.println("Name: " + student.name);
                    System.out.println("Age: " + student.age);
                    System.out.println("Grade: " + student.grade);
                }
            } else if (choice == 6) {
                display();
            } else if (choice == 7) {
                System.out.print("Enter Roll Number: ");
                int rollNo = sc.nextInt();
                System.out.print("Enter New Grade: ");
                String grade = sc.next();
                updateGrade(rollNo, grade);
            } else if (choice == 8) {
                System.out.println("Program ended");
                sc.close();
                return;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}


package LinkedList.Asssignment;
import java.util.Scanner;
public class TaskScheduler {
    static class Node {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;
        Node(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }
    static Node head = null;
    static Node current = null;
    public static void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
        current = head;
    }
    public static void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        if (current == null) {
            current = head;
        }
    }
    public static void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        if (head == null) {
            System.out.println("Invalid position");
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        if (temp.next == head && position > 2) {
            System.out.println("Invalid position");
            return;
        }
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public static void delete(int taskId) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        Node prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head && temp.next == head) {
                    head = null;
                    current = null;
                } else {
                    if (temp == head) {
                        Node last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = temp.next;
                    }
                    if (current == temp) {
                        current = temp.next;
                    }
                }
                System.out.println("Task deleted successfully");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Task not found");
    }
    public static void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }
        System.out.println("Current Task");
        System.out.println("Task ID: " + current.taskId);
        System.out.println("Task Name: " + current.taskName);
        System.out.println("Priority: " + current.priority);
        System.out.println("Due Date: " + current.dueDate);
        current = current.next;
    }
    public static void display() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }
        Node temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId);
            System.out.println("Task Name: " + temp.taskName);
            System.out.println("Priority: " + temp.priority);
            System.out.println("Due Date: " + temp.dueDate);
            System.out.println("-------------------");
            temp = temp.next;
        } while (temp != head);
    }
    public static void search(int priority) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task Found");
                System.out.println("Task ID: " + temp.taskId);
                System.out.println("Task Name: " + temp.taskName);
                System.out.println("Priority: " + temp.priority);
                System.out.println("Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("Task not found");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete Task");
            System.out.println("5. View Current Task");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                System.out.print("Enter Task ID: ");
                int taskId = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Task Name: ");
                String taskName = sc.nextLine();
                System.out.print("Enter Priority: ");
                int priority = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Due Date: ");
                String dueDate = sc.nextLine();
                if (choice == 1) {
                    addAtBeginning(taskId, taskName, priority, dueDate);
                } else if (choice == 2) {
                    addAtEnd(taskId, taskName, priority, dueDate);
                } else {
                    System.out.print("Enter Position: ");
                    int position = sc.nextInt();
                    addAtPosition(taskId, taskName, priority, dueDate, position);
                }
            } else if (choice == 4) {
                System.out.print("Enter Task ID: ");
                int taskId = sc.nextInt();

                delete(taskId);
            } else if (choice == 5) {
                viewCurrentTask();
            } else if (choice == 6) {
                display();
            } else if (choice == 7) {
                System.out.print("Enter Priority: ");
                int priority = sc.nextInt();

                search(priority);
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

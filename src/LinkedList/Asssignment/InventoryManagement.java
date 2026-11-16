package LinkedList.Asssignment;
import java.util.Scanner;
public class InventoryManagement {
    public static class Node {
        String itemName;
        int itemId;
        int quantity;
        double price;
        Node next;
        Node(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }
    public static Node head = null;
    public static void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }
    public static void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
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
    public static void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position < 1) {System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        Node newNode = new Node(itemName, itemId, quantity, price);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public static void delete(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item deleted successfully");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item deleted successfully");
        }
    }
    public static void updateQuantity(int itemId, int quantity) {
        Node temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = quantity;
                System.out.println("Quantity updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }
    public static void search(int itemId, String itemName) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemId == itemId || temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found");
                System.out.println("Item Name: " + temp.itemName);
                System.out.println("Item ID: " + temp.itemId);
                System.out.println("Quantity: " + temp.quantity);
                System.out.println("Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found");
        }
    }
    public static void display() {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println("Item Name: " + temp.itemName);
            System.out.println("Item ID: " + temp.itemId);
            System.out.println("Quantity: " + temp.quantity);
            System.out.println("Price: " + temp.price);
            System.out.println("-------------------");
            temp = temp.next;
        }
    }
    public static void totalValue() {
        Node temp = head;
        double total = 0;
        while (temp != null) {
            total = total + (temp.quantity * temp.price);
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }
    public static void sortByName(boolean ascending) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        Node temp;
        boolean swapped;
        do {
            swapped = false;
            temp = head;
            while (temp.next != null) {
                int result = temp.itemName.compareToIgnoreCase(temp.next.itemName);
                if ((ascending && result > 0) || (!ascending && result < 0)) {
                    String name = temp.itemName;
                    temp.itemName = temp.next.itemName;
                    temp.next.itemName = name;
                    int id = temp.itemId;
                    temp.itemId = temp.next.itemId;
                    temp.next.itemId = id;
                    int quantity = temp.quantity;
                    temp.quantity = temp.next.quantity;
                    temp.next.quantity = quantity;
                    double price = temp.price;
                    temp.price = temp.next.price;
                    temp.next.price = price;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Inventory sorted by name");
        display();
    }
    public static void sortByPrice(boolean ascending) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        Node temp;
        boolean swapped;
        do {
            swapped = false;
            temp = head;
            while (temp.next != null) {
                if ((ascending && temp.price > temp.next.price) ||
                        (!ascending && temp.price < temp.next.price)) {
                    String name = temp.itemName;
                    temp.itemName = temp.next.itemName;
                    temp.next.itemName = name;
                    int id = temp.itemId;
                    temp.itemId = temp.next.itemId;
                    temp.next.itemId = id;
                    int quantity = temp.quantity;
                    temp.quantity = temp.next.quantity;
                    temp.next.quantity = quantity;
                    double price = temp.price;
                    temp.price = temp.next.price;
                    temp.next.price = price;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Inventory sorted by price");
        display();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete Item");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search Item");
            System.out.println("7. Display Inventory");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Sort by Name");
            System.out.println("10. Sort by Price");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                sc.nextLine();
                System.out.print("Enter Item Name: ");
                String itemName = sc.nextLine();
                System.out.print("Enter Item ID: ");
                int itemId = sc.nextInt();
                System.out.print("Enter Quantity: ");
                int quantity = sc.nextInt();
                System.out.print("Enter Price: ");
                double price = sc.nextDouble();
                if (choice == 1) {
                    addAtBeginning(itemName, itemId, quantity, price);
                } else if (choice == 2) {
                    addAtEnd(itemName, itemId, quantity, price);
                } else {
                    System.out.print("Enter Position: ");
                    int position = sc.nextInt();
                    addAtPosition(itemName, itemId, quantity, price, position);
                }
            } else if (choice == 4) {
                System.out.print("Enter Item ID: ");
                int itemId = sc.nextInt();
                delete(itemId);
            } else if (choice == 5) {
                System.out.print("Enter Item ID: ");
                int itemId = sc.nextInt();
                System.out.print("Enter New Quantity: ");
                int quantity = sc.nextInt();
                updateQuantity(itemId, quantity);
            } else if (choice == 6) {
                System.out.print("Enter Item ID (enter 0 if searching by name): ");
                int itemId = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Item Name (leave empty if searching by ID): ");
                String itemName = sc.nextLine();
                search(itemId, itemName);
            } else if (choice == 7) {
                display();
            } else if (choice == 8) {
                totalValue();
            } else if (choice == 9) {
                System.out.println("1. Ascending");
                System.out.println("2. Descending");
                int order = sc.nextInt();
                if (order == 1) {
                    sortByName(true);
                } else if (order == 2) {
                    sortByName(false);
                } else {
                    System.out.println("Invalid choice");
                }
            } else if (choice == 10) {
                System.out.println("1. Ascending");
                System.out.println("2. Descending");
                int order = sc.nextInt();
                if (order == 1) {
                    sortByPrice(true);
                } else if (order == 2) {
                    sortByPrice(false);
                } else {
                    System.out.println("Invalid choice");
                }
            } else if (choice == 11) {
                System.out.println("Program ended");
                sc.close();
                return;

            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}

package LinkedList.Asssignment;
import java.util.Scanner;

public class MovieManagement {

    public static class Node {
        String title;
        String director;
        int year;
        double rating;
        Node prev;
        Node next;
        Node(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.prev = null;
            this.next = null;
        }
    }
    public static Node head = null;
    public static Node tail = null;

    public static void addAtBeginning(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public static void addAtEnd(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public static void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            addAtBeginning(title, director, year, rating);
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

        if (temp == tail) {
            addAtEnd(title, director, year, rating);
            return;
        }

        Node newNode = new Node(title, director, year, rating);

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    public static void delete(String title) {
        Node temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

        if (temp == head) {
            head = head.next;
        } else {
            temp.prev.next = temp.next;
        }

        if (temp == tail) {
            tail = tail.prev;
        } else {
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie deleted successfully");
    }

    public static void search(String value) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(value) ||
                    temp.director.equalsIgnoreCase(value)) {

                System.out.println("Movie Found");
                System.out.println("Title: " + temp.title);
                System.out.println("Director: " + temp.director);
                System.out.println("Year: " + temp.year);
                System.out.println("Rating: " + temp.rating);

                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            try {
                double rating = Double.parseDouble(value);
                temp = head;

                while (temp != null) {
                    if (temp.rating == rating) {
                        System.out.println("Movie Found");
                        System.out.println("Title: " + temp.title);
                        System.out.println("Director: " + temp.director);
                        System.out.println("Year: " + temp.year);
                        System.out.println("Rating: " + temp.rating);
                        found = true;
                    }
                    temp = temp.next;
                }
            } catch (NumberFormatException e) {
                found = false;
            }
        }
        if (!found) {
            System.out.println("Movie not found");
        }
    }
    public static void displayForward() {
        if (head == null) {
            System.out.println("No movies found");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title);
            System.out.println("Director: " + temp.director);
            System.out.println("Year: " + temp.year);
            System.out.println("Rating: " + temp.rating);
            System.out.println("-------------------");
            temp = temp.next;
        }
    }
    public static void displayReverse() {
        if (tail == null) {
            System.out.println("No movies found");
            return;
        }
        Node temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title);
            System.out.println("Director: " + temp.director);
            System.out.println("Year: " + temp.year);
            System.out.println("Rating: " + temp.rating);
            System.out.println("-------------------");
            temp = temp.prev;
        }
    }
    public static void updateRating(String title, double rating) {
        Node temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = rating;
                System.out.println("Rating updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete Movie");
            System.out.println("5. Search Movie");
            System.out.println("6. Display Forward");
            System.out.println("7. Display Reverse");
            System.out.println("8. Update Rating");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                sc.nextLine();
                System.out.print("Enter Movie Title: ");
                String title = sc.nextLine();
                System.out.print("Enter Director: ");
                String director = sc.nextLine();
                System.out.print("Enter Release Year: ");
                int year = sc.nextInt();
                System.out.print("Enter Rating: ");
                double rating = sc.nextDouble();
                if (choice == 1) {
                    addAtBeginning(title, director, year, rating);
                } else if (choice == 2) {
                    addAtEnd(title, director, year, rating);
                } else {
                    System.out.print("Enter Position: ");
                    int position = sc.nextInt();
                    addAtPosition(title, director, year, rating, position);
                }
            } else if (choice == 4) {
                sc.nextLine();
                System.out.print("Enter Movie Title: ");
                String title = sc.nextLine();
                delete(title);
            } else if (choice == 5) {
                sc.nextLine();
                System.out.println("Enter Movie Title, Director or Rating: ");
                String value = sc.nextLine();
                search(value);
            } else if (choice == 6) {
                displayForward();
            } else if (choice == 7) {
                displayReverse();
            } else if (choice == 8) {
                sc.nextLine();
                System.out.print("Enter Movie Title: ");
                String title = sc.nextLine();
                System.out.print("Enter New Rating: ");
                double rating = sc.nextDouble();
                updateRating(title, rating);
            } else if (choice == 9) {
                System.out.println("Program ended");
                sc.close();
                return;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}



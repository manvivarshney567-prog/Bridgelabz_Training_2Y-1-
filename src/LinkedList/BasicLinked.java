package LinkedList;

public class BasicLinked {
    public static void main(String[] args){
        Node a=new Node(5);
        System.out.print(a.data+" -> ");
        Node b=new Node (6);
        System.out.print(b.data+" -> ");
        System.out.println(a.next);
    }
}

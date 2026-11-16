package LinkedList.Searching;

public class Searching {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
        }
    }
    public static Node head;
    public static Node tail;
    public static void insertAtEnd(int value){
        Node temp=new Node(value);
        if(head==null)
        {
            head=temp;
            tail=temp;
        }
        else{
            tail.next=temp;
            tail=temp;
        }
    }
    public static void display(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data+"->");
            temp=temp.next;
        }
    }
}

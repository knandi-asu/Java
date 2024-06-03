import java.util.*;
public class StackClass {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            next=null;
        }
    }
    static class Stack{
        public static Node head;
        public static boolean isEmpty(){
            if(head==null)
                return true;
            return false;
        }
        public static void push(int x){
            Node new_node=new Node(x);
            if(isEmpty()==true)
                head=new_node;
            else{
                new_node.next=head;
                head=new_node;
            }
        }
        public static int pop(){
            if(isEmpty()){
                System.out.println("No elements in stack");
                return -1;
            }
            int top_ele=head.data;
            head=head.next;
            return top_ele;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("EMpty stack");
                return -1;
            }
            return head.data;
        }
        public static void printStack(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return;
            }
            Node temp=head;
            while(temp!=null){
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
    }
    public static void main(String[] args){
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.printStack();
        System.out.println(s.peek());
        System.out.println(s.pop());
        
    }
}

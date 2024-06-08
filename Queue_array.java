import java.util.*;
public class Queue_array {
    static class Queue{
        static int[] arr;
        static int front=-1;
        static int rear=-1;
        static int size;
        public Queue(int size){
            arr=new int[size];
            this.size=size;
        }
        public static boolean isEmpty(){
            return rear==-1;
        }
        public static void add(int data){
            if(rear==arr.length-1){
                System.out.println("Queue is full");
                return;
            }
            if(rear==-1){
                front=0;
            }
            arr[++rear]=data;
        }
        public static int remove(){
            if(rear==-1){
                System.out.println("Empty queue");
                return -1;
            }
            int popped=arr[front];
            front++;
            return popped;
        }
        public static int peek(){
            if(front>=rear && front!=0){
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[front];
        }
        public static void printqueue(){
            if(rear==-1 || front>=rear){
                System.out.println("Empty Queue");
                return;
            }
            for(int i=front;i<=rear;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println("");
        }

    }
    public static void main(String[] args){
        Queue q=new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.printqueue();
        q.remove();
        q.remove();
        q.remove();
        q.add(1);
        q.add(2);
        q.printqueue();
        q.add(2);
        System.out.println(q.peek());
    }
}

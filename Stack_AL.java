import java.util.*;
public class Stack_AL {
    static class Stack{
        static ArrayList<Integer> list=new ArrayList<>();
        public static boolean isEmpty(){
            if(list.size()==0)return true;
            return false;
        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isEmpty()){
                System.out.println("Empty List");
                return -1;
            }
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Stack");
                return -1;
            }
            return list.get(list.size()-1);
        }
        public static void printstack(){
            if(isEmpty()){
                System.out.println("Empty Stack");
                return;
            }
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }
    }
    public static void main(String[] args){
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.printstack();
        s.pop();
        s.printstack();
        s.peek();
        s.printstack();
    }
}

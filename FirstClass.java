
import java.util.*;

class FirstClass{
    public static int sumNumbers(int a, int b){
         return a+b;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(sumNumbers(a, b));
    }
}
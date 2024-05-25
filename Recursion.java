import java.util.*;

public class Recursion {
    public static int soln(int x, int n){
        if(n==0)
            return 1;
        if(x==0)
            return 0;
        if(n%2==0)
            return soln(x,n/2)*soln(x,n/2);
        return soln(x,n/2)*soln(x,n/2)*x;
        //return x*soln(x,n-1);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter x & n resp.");
        int x=sc.nextInt();
        int n=sc.nextInt();
        System.out.println("Stack height logn " + soln(x,n));
    }
}

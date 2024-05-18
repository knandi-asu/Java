import java.util.*;
class Arrays{
    public static void main(String args[]){
        //int[] marks=new int[3];
        //int marks[]=new int[3];
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        int marks[]=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter " + i +" element : ");
            marks[i]=sc.nextInt();
        }
        // marks[0]=7;
        // marks[1]=3;
        // marks[2]=9;
        for(int i=0;i<marks.length;i++){
            System.out.println(marks[i]);
        }
    }
}
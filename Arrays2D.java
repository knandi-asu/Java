import java.util.*;
class Arrays2D{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int row=sc.nextInt();
        int col=sc.nextInt();
        int[][] marks=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.println("Enter " + i + ","+ j +" element : ");
                marks[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.println(marks[i][j]);
            }
        }
    }
}
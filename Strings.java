import java.util.*;
public class Strings{
    public static void main(String[] args){
        String firstname;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first name");
        firstname=sc.nextLine();
        // System.out.println("Enter last name");
        // lastname=sc.nextLine();
        // String fullname=firstname + " "+ lastname;
        // System.out.println(fullname);
        // for(int i=0;i<fullname.length();i++){
        //     System.out.println(fullname.charAt(i));
        // }
        StringBuilder sb=new StringBuilder(firstname);
        for(int i=0;i<(sb.length()/2);i++){
            char temp=sb.charAt(i);
            sb.setCharAt(i,sb.charAt(sb.length()-i-1));
            sb.setCharAt(sb.length()-i-1,temp);
        }
        System.out.println(sb);
    }
}
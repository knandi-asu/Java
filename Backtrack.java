import java.util.*;

public class Backtrack {
    public static void permutation(int index, String str, String perm){
        if(str.length()==0){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<str.length();i++){
            Character curr=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            permutation(index+1,newStr,perm+curr);
        }
    }
    public static void main(String[] args){
        permutation(0,"ABC","");
    }
}

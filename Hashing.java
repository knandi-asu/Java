import java.util.HashSet;
import java.util.Iterator;

public class Hashing {
    public static void main(String[] args){
        HashSet<Integer> set=new HashSet<>();
        //Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        //Search
        // if(set.contains(1)){
        //     System.out.println("Exists");
        // }else{
        //     System.out.println("Doesnt exists");
        // }
        // //delete
        // set.remove(1);
        // if(set.contains(1)){
        //     System.out.println("Exists");
        // }else{
        //     System.out.println("Doesnt exists");
        // }
        // //Size
        // System.out.println("Size of set "+ set.size());

        //Iterator
        Iterator it=set.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
}

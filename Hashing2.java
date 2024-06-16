import java.util.*;

public class Hashing2 {
    public static void main(String[] args){
        HashMap<String,Integer> map=new HashMap<>();
        //Insert
        map.put("India",120);
        map.put("US",60);
        map.put("China",130);
        map.put("China",180);
        // System.out.println(map);

        // //search
        // if(map.containsKey("India")){
        //     System.out.println("Key Exists");
        // }else{
        //     System.out.println("Key is not present");
        // }
        // //get
        // System.out.println(map.get("China"));
        // System.out.println(map.get("Indonesia"));

        // //Iterator
        // System.out.println("Iterator");
        // for(Map.Entry<String,Integer> e : map.entrySet()){
        //     System.out.println(e.getKey() + ":" + e.getValue());
        // }

        // Set<String> keys=map.keySet();
        // for(String key : keys){
        //     System.out.println(key + ":" + map.get(key));
        // }

        map.remove("China");
        System.out.println(map);
    }
}

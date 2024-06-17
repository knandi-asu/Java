import java.util.*;

import javax.annotation.processing.SupportedSourceVersion;

public class HashMapImpl {
    static class HashMap<K,V>{//K->key, V-> Value (Generics) indicates type of Key & value
        private class Node{
            K key;
            V value;
            Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }
        private int n;//Nodes
        private int N;//buckets length
        private LinkedList<Node> buckets[];
        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }

        private int hashFunction(K key){ // Should always be in between 0-(n-1)
            int bi=key.hashCode();
            return Math.abs(bi)%N;
        }

        private int searchLL(K key, int bi){
            LinkedList<Node> ll=buckets[bi];
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key==key){
                    return i;//di
                }
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[]=buckets;
            buckets=new LinkedList[N*2];
            for(int i=0;i<N*2;i++){
                buckets[i]=new LinkedList<>();
            }
            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node> ll=oldBucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node=ll.get(j);
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key, V value){
            int bi=hashFunction(key);
            int di=searchLL(key, bi);//di value (di>= 0 -> data exists, if di==-1, then key doesnt exists)
            if(di==-1){ // Key doesnt exists
                buckets[bi].add(new Node(key,value));
                n++;
            }else{//Key exists
                Node node=buckets[bi].get(di);
                node.value=value;
            }

            double lambda= (double)n/N;
            if(lambda>2.0){
                //rehashing
                rehash();
            }
        }

        public V get(K key){
            int bi=hashFunction(key);
            int di=searchLL(key, bi);//di value (di>= 0 -> data exists, if di==-1, then key doesnt exists)
            if(di==-1){ // Key doesnt exists
                return null;
            }else{//Key exists
                Node node=buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key){
            int bi=hashFunction(key);
            int di=searchLL(key, bi);//di value (di>= 0 -> data exists, if di==-1, then key doesnt exists)
            if(di==-1){ // Key doesnt exists
                return false;
            }else{//Key exists
                return true;
            }
        }

        public V remove(K key){
            int bi=hashFunction(key);
            int di=searchLL(key, bi);//di value (di>= 0 -> data exists, if di==-1, then key doesnt exists)
            if(di==-1){ // Key doesnt exists
                return null;
            }else{//Key exists
                Node node=buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public boolean isEmpty(){
            return n==0;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys=new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll=buckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node=ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }
    public static void main(String[] args){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("india",120);
        map.put("China",120);
        map.put("US",100);
        ArrayList<String> keys=map.keySet();
        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }
        map.remove("India");
        System.out.println(map.get("India"));
        // while(!map.isEmpty()){

        // }
    }
}

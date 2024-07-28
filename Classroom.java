public class Classroom {
    static class Node{
        Node[] children=new Node[26];
        boolean endOfWord;
        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            endOfWord=false;
        }
    }
    static Node root= new Node();
    public static void insert(String word){
        Node cur=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(cur.children[idx]==null){
                cur.children[idx]=new Node();
            }
            if(i==word.length()-1){
                cur.children[idx].endOfWord=true;
            }
            cur=cur.children[idx];
        }
    }   
    public static boolean search(String word){
        Node cur=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(cur.children[idx]==null){
                return false;
            }
            if(i==word.length()-1 && cur.children[idx].endOfWord==false){
                return false;
            }
            cur=cur.children[idx];
        }
        return true;
    }

    
    public static void main(String[] args){
        String[] words={"the","a","there","their","any"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(search("ther"));
        System.out.println(search("an"));
    }
}

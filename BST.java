import java.util.ArrayList;
public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root, int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left,val);
        }else{
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean search(Node root, int val){
        if(root==null){
            return false;
        }
        if(root.data==val){
            return true;
        }
        if(root.data > val){
            return search(root.left, val);
        }
        return search(root.right, val);
    }
    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }else if( root.data < val){
            root.right = delete(root.right, val);
        }else{ // root.data == val
            //case 1
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            //case 3
            Node IS=inorderSuccessor(root.right);
            root.data=IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node inorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void printRange(Node root, int x, int y){
        if(root==null){
            return;
        }
        if(root.data >= x && root.data <=y){
            printRange(root.left, x, y);
            System.out.print(root.data + " ");
            printRange(root.right, x, y);
        }else if(x>root.data){
            printRange(root.right, x, y);
        }else{
            printRange(root.left, x, y);
        }
    }
    public static void printRootToLeafPaths(Node root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        arr.add(root.data);
        if(root.left==null && root.right==null){ // Leaf
            System.out.println(arr);
        }else{ // Non-leaf node
            printRootToLeafPaths(root.left, arr);
            printRootToLeafPaths(root.right, arr);
        }
        arr.remove(arr.size()-1);
    }
    public static void main(String[] args){
        int values[]={5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root,values[i]);
        }
        inorder(root);
        System.out.println();
        //printRange(root, 6, 90);
        printRootToLeafPaths(root, new ArrayList<>());
    }
}

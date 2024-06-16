import java.util.Queue;
import java.util.LinkedList;
public class BinaryTreesClass {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1)
                return null;
            Node newNode=new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;

        }
        public static void preorderTraversal(Node node){
            if(node==null)
                return;
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }

        public static void inorder(Node node){
            if(node==null){
                return;
            }
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }

        public static void postoder(Node node){
            if(node==null){
                return;
            }
            postoder(node.left);
            postoder(node.right);
            System.out.print(node.data + " ");

        }

        public static void levelorder(Node node){
            if(node==null)
                return;
            Queue<Node> q=new LinkedList<>();
            q.add(node);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }


        }
        public static int countNodes(Node node){
            if(node==null){
                return 0;
            }
            return 1+countNodes(node.left)+countNodes(node.right);
        }
        public static int sumNodes(Node node){
            if(node==null){
                return 0;
            }
            return node.data+sumNodes(node.left)+sumNodes(node.right);
        }
        public static int heightTree(Node node){
            if(node==null){
                return 0;
            }
            return 1+Math.max(heightTree(node.left),heightTree(node.right));
        }
        public static int diameter(Node node){
            if(node==null){
                return 0;
            }
            int diam1=diameter(node.left);
            int diam2=diameter(node.right);
            int diam3= heightTree(node.left) + heightTree(node.right) + 1;
            return Math.max(diam1, Math.max(diam2, diam3));
        }
        static class TreeInfo{
            int diam;
            int ht;
            TreeInfo(int diam,int ht){
                this.diam=diam;
                this.ht=ht;
            }
        }
        public static TreeInfo diam2(Node root){
            if(root==null){
                return new TreeInfo(0, 0);
            }
            TreeInfo left= diam2(root.left);
            TreeInfo right=diam2(root.right);

            int myheight = Math.max(left.ht, right.ht) + 1;
            int diam1 = left.diam;
            int diam2=right.diam;
            int diam3=1+left.ht + right.ht;
            int myDiam=Math.max(diam1,Math.max(diam2,diam3));
            
            TreeInfo temp=new TreeInfo(myDiam, myheight);
            return temp;
        }
        public static boolean isEqual(Node root1, Node root2){
            if(root1==null && root2==null){
                return true;
            }
            if(root1== null || root2==null || root1.data!=root2.data){
                return false;
            }
            return isEqual(root1.left,root2.left) && isEqual(root1.right, root2.right);
        }
        public static boolean isSubTree(Node root1, Node root2){
            if(root2==null){
                return true;
            }
            if(root1==null){
                return false;
            }
            if(root1.data==root2.data){
                if(isEqual(root1, root2)){
                    return true;
                }
            }
            return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
        }

    }
    public static void main(String[] args){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt=new BinaryTree();
        Node root = bt.buildTree(nodes);
        int nodes2[]={2,4,-1,-1,5,-1,-1};
        Node root2=bt.buildTree(nodes2);
        System.out.println(bt.isSubTree(root, root2));   
    }
    
}

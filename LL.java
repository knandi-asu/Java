public class LL {
    Node head;
    private int size;
    LL(){
        this.size=0;
    }
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
            size++;
        }
    }

    //add First
    public void adddFirst(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    //addLast
    public void addLast(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
    }

    public void printList(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data + "->");
            currNode=currNode.next;
        }
        System.out.println("null");
    }

    public void deleteNode(String data){
        if(head.data==data){
            size--;
            head=head.next;
            return;
        }
        Node currNode=head;
        Node prevNode=null;
        while(currNode!=null && currNode.data!=data){
            prevNode=currNode;
            currNode=currNode.next;
        }
        if(currNode==null){
            System.out.println("The node with data "+data+" is not present in linkedlist");
            return;
        }
        size--;
        prevNode.next=currNode.next;
    }
    public int getSize(){
        return size;
    }

    public static void main(String[] args){
        LL Llist=new LL();
        Llist.adddFirst("a");
        Llist.addLast("b");
        Llist.addLast("c");
        Llist.addLast("d");
        Llist.printList();
        System.out.println(Llist.getSize());
        Llist.deleteNode("b");
        Llist.printList();
        System.out.println(Llist.getSize());
        Llist.deleteNode("a");
        Llist.printList();
        System.out.println(Llist.getSize());
        Llist.deleteNode("d");
        Llist.printList();
        System.out.println(Llist.getSize());
    }
}

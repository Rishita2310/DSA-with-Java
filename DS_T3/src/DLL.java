public class DLL {
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int d){
            data=d;
            next=null;
            prev=null;
        }
    }
    Node first=null;
    void InsertFirst(int data){
        Node n=new Node(data);
        if(first==null){
            first=n;
        }else{
            n.next=first;
            first.prev=n;
            first=n;
        }
    }
    void InsertLast(int data){
        Node n=new Node(data);
        if(first==null){
            first=n;
        }else{
            Node temp=first;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=n;
            n.prev=temp;
            n.next=null;
        }
    }
    void DeleteFirst(){
        if(first==null){
            System.out.println("DLL is empty");
        }else{
            first=first.next;
            first.prev=null;
        }
    }
    void DeleteLast() {
        if (first == null) {
            System.out.println("DLL is empty");
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node del=temp;
            temp.prev.next = null;
            temp.prev = null;
            del=null;
        }
    }
    void Delete(int data) {
        if (first == null) {
            System.out.println("Underflow");
        } else {
            Node temp = first;
            while (temp.next != null) {
                if (temp.data == data) {
                    break;
                }
                temp = temp.next;
            }
            if (temp.next == null && temp.data != data) {
                System.out.println("Data not found");
            } else {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                if (temp.prev == null) {
                    first = first.next;
                }
            }
        }
    }
    void Display(){
        if(first==null){
            System.out.println("LL is Empty");
        }else{
            Node temp=first;
            do{
                System.out.print(temp.data+"<-->");
                temp=temp.next;
            }while (temp!=null);
        }
    }
    public static void main(String[] args) {
        DLL d=new DLL();
        d.InsertFirst(10);
        d.InsertFirst(20);
        d.InsertFirst(30);
        d.Display();
        System.out.println();
        d.InsertLast(10);
        d.InsertLast(20);
        d.InsertLast(30);
        d.Display();
        System.out.println();
        d.DeleteFirst();
        d.Display();
        System.out.println();
        d.DeleteLast();
        d.Display();
    }
}
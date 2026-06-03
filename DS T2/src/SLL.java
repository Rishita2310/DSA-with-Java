import java.util.Scanner;
public class SLL {
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    Node first=null;
    void InsertFirst(int data){
        Node n=new Node(data);
        if(first==null){
            first=n;
        }
        else{
            n.next=first;
            first=n;
        }
    }
    void InsertLast(int data){
        Node n=new Node(data);
        if(first==null){
            first=n;
        }
        else{
            Node temp=first;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=n;
        }
    }
    void Search(int data){
        int c=0,f=0;
        Node temp=first;
        while(temp!=null){
            c++;
            if(temp.data==data){
                System.out.println("Value found at "+c+" position");
                f=1;
                break;
            }
            temp=temp.next;
        }
        if(f==0){
            System.out.println("Value not found");
        }
    }
    void InsertBeforeParticularValue(int value,int data){
        int c=0,f=0;
        Node temp=first;
        while(temp!=null){
            c++;
            if(temp.data==data){
                System.out.println("Value found at "+c+" position");
                f=1;
                break;
            }
            temp=temp.next;
        }
        if(f==0){
            System.out.println("Value not found");
        }
        else{
            Node n=new Node(data);
            if(first.data==data){
                n.next=first;
                first=n;
            }
            else{
                Node tem=first;
                while(tem.next.data!=data){
                    tem=tem.next;
                }
                n.next=tem.next;
                tem.next=n;
            }
        }
    }
    void InsertAfterParticularValue(int value,int data){
        int c=0,f=0;
        Node temp=first;
        while(temp!=null){
            c++;
            if(temp.data==data){
                System.out.println("Value found at "+c+" position");
                f=1;
                break;
            }
            temp=temp.next;
        }
        if(f==0){
            System.out.println("Value not found");
        }
        else{
            Node n=new Node(value);
            Node tem=first;
            while (tem.data!=data){
                tem=tem.next;
            }
            n.next=tem.next;
            tem.next=n;
        }
    }
    void DelFirst(){
        if(first==null){
            System.out.println("Linked list is empty...");
        }
        else{
            Node del=first;
            first=first.next;
            del.next=null;
        }
    }
    void DelLast() {
        if (first == null) {
            System.out.println("Linked list is empty...");
        }
        else {
            Node temp = first;
            while (temp.next.next!=null){
                temp=temp.next;
                temp.next=null;
            }
        }
    }
    void Delete(int data){
        int c=0,f=0;
        Node temp=first;
        while(temp!=null){
            c++;
            if(temp.data==data){
                System.out.println("Value found at "+c+" position");
                f=1;
                break;
            }
            temp=temp.next;
        }
        if(f==0){
            System.out.println("Value not found");
        }
        else{
            if(first.data==data){
                DelFirst();
            }
            else{
                Node tempp = first;
                while (tempp.next.data!=data) {
                    tempp = tempp.next;
                }
                Node del=tempp.next;
                tempp.next=tempp.next.next;
                del.next=null;
            }
        }
    }
    void push(int data){
        InsertFirst(data);
    }
    void pop(){
        DelLast();
    }
    void display(){
        if(first==null){
            System.out.println("Linked list is empty...");
        }
        else{
            Node temp=first;
            while(temp!=null){
                System.out.print(temp.data+"--->");
                temp=temp.next;
            }
            System.out.println("Null");
        }
    }
}
class RN{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        SLL s=new SLL();
        s.InsertFirst(10);
        s.InsertFirst(20);
        s.InsertFirst(30);
        s.display();
        //System.out.println("Enter the element you want to search");
        //int num=sc.nextInt();
        //s.Search(num);
        s.InsertBeforeParticularValue(200,20);
        s.display();
    }
}
public class CLL {
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
            n.next=n;
        }else{
            n.next=first;
            Node temp=first;
            while (temp.next!=first){
                temp=temp.next;
            }
            temp.next=n;
            first=n;
        }
    }
    void InsertLast(int data){
        Node n=new Node(data);
        if(first==null){
            first=n;
        n.next=n;
        }else{
            Node temp=first;
            while (temp.next!=first){
                temp=temp.next;
            }
            temp.next=n;
            n.next=first;
        }
    }
    void Search(int data){
        int c=0,f=0;
        Node temp=first;
        do{
            c++;
            if(temp.data==data){
                System.out.println(data+" is found at position "+c);
                f=1;
                break;
            }
            temp=temp.next;
        }while (temp!=first);
        if(f==0){
            System.out.println("Value not found");
        }
    }
    void InsertBeforeParticularValue(int value,int data){
        int c=0,f=0;
        Node temp=first;
        do{
            c++;
            if(temp.data==data){
                System.out.println("Value found at "+c+" position");
                f=1;
                break;
            }
            temp=temp.next;
        }while (temp!=first);
        if(f==0){
            System.out.println("Value not found");
        }else{
            Node n=new Node(value);
            if(first.data==value&&first.next==first){
                n.next=first;
                Node t=first;
                while (t.next!=first){
                    t=t.next;
                }
                t.next=n;
                first=n;
            }else{
                Node tem=first;
                while(tem.next.data!=data){
                    tem=tem.next;
                }
                n.next=tem.next;
                tem.next=n;
            }
        }
    }
    void display(){
        if(first==null){
            System.out.println("LL is empty");
        }else{
            Node temp=first;
            do{
                System.out.print(temp.data+"-->");
                temp=temp.next;
            }while(temp!=first);
        }
    }
}
class Run{
    public static void main(String[] args) {
        CLL c=new CLL();
        c.InsertFirst(10);
        c.InsertFirst(20);
        c.InsertFirst(30);
        c.display();
        c.Search(30);
        c.InsertBeforeParticularValue(50,20);
        c.display();
    }
}

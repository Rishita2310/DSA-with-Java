import java.util.Scanner;

public class QueueByStack {
    int Q[];
    int temp[];
    int F,R,size;
    QueueByStack(int N){
        size=N;
        F=-1;
        R=-1;
        Q=new int[N];
        temp=new int[N];
    }
    void enQueue(int Y){
        if( (R == size - 1&&F==0)||F==R+1) {
            System.out.println("Queue Overflow");
            return;
        }
        else {
            if(R==size-1){
                R=0;
            }
            else{
                R++;
            }
            //R=(R+1)%size;
            Q[R] = Y;
            if (F == -1) {
                F = 0;
            }
            System.out.println("Data Inserted Successfully " );
        }
    }
    void Push(int X){
        enQueue(X);
    }
    int deQueue(){
        if (F == -1) {
            System.out.println("Underflow");
            return 0;
        } else {
            int Y = Q[F];
            if (F == R) {
                R = -1;
                F = -1;
            }
            else{
                F=(F+1)%size;
            }
             /*else if(F==size-1) {
                F=0;
             }
             else{
                 F++;
            }*/
            System.out.println("Deleted element : " + Y);
            return Y;
        }
    }
    void Pop(){
        QueueByStack temp=new QueueByStack(5);
        while(F!=R){
            temp.enQueue(deQueue());
        }
        System.out.println("Poped Element :"+deQueue());
        while (temp.F!=-1){
            enQueue(temp.deQueue());
        }
    }
    void display(){
        if (F == -1) {
            System.out.println("Underflow");
        }
        else {
            for (int i = F; i != R; i=(i+1)%size) {
                System.out.print(Q[i]+" | ");
            }
            System.out.print(Q[R]);
        }
    }
}
class RUN{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        QueueByStack q=new QueueByStack(5);
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.Push(40);
        q.display();
        q.Pop();
        q.display();
    }
}

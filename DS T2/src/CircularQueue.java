import java.util.Scanner;

public class CircularQueue {
    int Q[];
    int F,R,size;

    CircularQueue(int N) {
        size=N;
        Q = new int[N];
        F = -1;
        R = -1;
    }
    void enQueue(int Y){
        if( (R == size - 1&&F==0)||F==R+1) {
            System.out.println("Queue Overflow");
            return;
        }
        else {
            /*if(R==size-1){
                R=0;
            }
            else{
                R++;
            }*/
            R=(R+1)%size;
            Q[R] = Y;
            if (F == -1) {
                F = 0;
            }
            System.out.println("Data Inserted Successfully " );
        }
    }
    void deQueue(){
        if (F == -1) {
            System.out.println("Underflow");
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
class R{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of queue");
        int N = sc.nextInt();
        CircularQueue c = new CircularQueue(N);
        int choice;
        do {
            System.out.println("enter your choice");
            System.out.println(" 1.Insert " + " 2.Delete " + " 3.Display " + " 4.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter inserted element");
                    int Y = sc.nextInt();
                    c.enQueue(Y);
                    break;
                case 2:
                    c.deQueue();
                    break;
                case 3:
                    c.display();
                    break;
                case 4:
                    System.out.println(" Exit");
                    break;
            }
        }
        while (choice != 4);
    }
}
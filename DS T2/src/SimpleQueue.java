import java.util.Scanner;

public class SimpleQueue {
    int Q[];
    int F,R,size;

    SimpleQueue(int N) {
        size=N;
        Q = new int[N];
        F = -1;
        R = -1;
    }
    void enQueue(int Y) {
        if (R >= size - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        else {
            R++;
            Q[R] = Y;
            if (F == -1) {
                F = 0;
            }
            System.out.println("Data Inserted Successfully " );
        }
    }
    void deQueue() {
        if (F == -1) {
            System.out.println("Underflow");
        } else {
            int Y = Q[F];
            if (F == R) {
                R = -1;
                F = -1;
                System.out.println("Queue Reset");
            } else {
               F++;
            }
            System.out.println("Deleted element : " + Y);
        }
    }
    void display() {
        if (F == -1) {
            System.out.println("Underflow");
        }
        else {
            for (int i = F; i <= R; i++) {
                System.out.print(Q[i]+" | ");
            }
            System.out.println();
        }
    }
}
class Run{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of queue");
        int N = sc.nextInt();
        SimpleQueue s = new SimpleQueue(N);
        int choice;
        do {
            System.out.println("enter your choice");
            System.out.println(" 1.Insert " + " 2.Delete " + " 3.Display " + " 4.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter inserted element");
                    int Y = sc.nextInt();
                    s.enQueue(Y);
                    break;
                case 2:
                    s.deQueue();
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    System.out.println(" Exit");
                    break;
            }
        }
        while (choice != 4);
    }
}

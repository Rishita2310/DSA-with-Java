import java.util.Scanner;

public class DoubleEndedQueue {
    int Q[] ;
    int F,R,Y,N,size;
    DoubleEndedQueue(int N){
        size=N;
        F=-1;
        R=-1;
        Q=new int[N];
    }
    void InR(int X){
        if((F==0&&R==size-1)||F==R+1){
            System.out.println("Overflow");
        }
        else{
            if(R==-1){
                F=R=0;
            }
            else if(R==size-1){
                R=0;
            }
            else{
                R++;
            }
            Q[R]=X;
            System.out.println(X+" is inserted");
        }
    }
    void InF(int X){
        if((F==0&&R==size-1)||F==R+1){
            System.out.println("Overflow");
        }
        else{
            if(F==-1){
                F=R=0;
            }
            else if(F==0){
                F=size-1;
            }
            else{
                F--;
            }
            Q[F]=X;
            System.out.println(X+" is inserted");
        }
    }
    void DelR(){
        if(R==-1){
            System.out.println("Underflow");
        }
        else{
            int Y=Q[R];
            if(F==R){
                R=F=-1;
            }
            else if(R==0){
                R=N-1;
            }
            else{
                R--;
            }
            System.out.println(Y+ " is deleted");
        }
    }
    void DelF(){
        if(F==-1){
            System.out.println("Underflow");
        }
        else{
            int Y=Q[F];
            if(F==R){
                R=F=-1;
            }
            else if(F==N-1){
                F=0;
            }
            else{
                F++;
            }
            System.out.println(Y+ " is deleted");
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
            /*
            int i=F;
            do{
                System.out.println(Q[i]+'|');
                i=(i+1)%size;
            }
            while (i!=(R+1)%size);
            */
        }
    }
}
class Ru{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of queue");
        int N= sc.nextInt();
        DoubleEndedQueue d=new DoubleEndedQueue(N);
        int choice;
        do {
            System.out.println("enter your choice");
            System.out.println(" 1.Insert From Front " + " 2.Insert from Rear  3.Delete from Front  4.Delete from Rear" + " 5.Display " + " 6.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter inserted element");
                    int Y = sc.nextInt();
                    d.InF(Y);
                    break;
                case 2:
                    System.out.println("enter inserted element");
                    int X = sc.nextInt();
                    d.InR(X);
                    break;
                case 3:
                    d.DelF();
                    break;
                case 4:
                    d.DelR();
                    break;
                case 5:
                    d.display();
                    break;
                case 6:
                    System.out.println(" Exit");
                    break;
            }
        }
        while (choice != 6);
    }
}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        Queue q = new Queue(testCase);
        for(int i=0;i<testCase;i++){
            String s = scanner.next();
            if(s.equals("push")){
                int j= Integer.parseInt(scanner.next());
                q.push(j);
            }else if(s.equals("pop")){
                System.out.println(q.pop()+"");
            }else if(s.equals("size")){
                System.out.println(q.size()+"");
            }else if(s.equals("empty")){
                System.out.println(q.isEmpty()+"");
            }else if(s.equals("front")){
                System.out.println(q.getFront()+"");
            }else if(s.equals("back")){
                System.out.println(q.getBack()+"");
            }
        }

        scanner.close();
    }


}


class Queue{
    int front;
    int back;
    int maxSize;
    int[] list;


    public Queue(int maxSize){
        front = 0;
        back = -1;
        this.maxSize = maxSize;
        list = new int[maxSize];
    }

    public void push(int n){
        if(back==maxSize-1){
            //full
        }else {
            back++;
            list[back] = n;
        }
    }

    public int pop(){
        if(front==back+1){
            //empty
            return -1;
        }
        int ret = list[front];
        list[front]=0;
        front++;
        return ret;
    }

    public int size(){
        return back-front+1;
    }


    public int isEmpty(){
        if(front==back+1){
            return 1;
        }else {
            return 0;
        }
    }

    public int getFront(){
        if(isEmpty()==1){
            return -1;
        }
        return list[front];
    }
    public int getBack(){
        if(isEmpty()==1){
            return -1;
        }
        return list[back];
    }

}
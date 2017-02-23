import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for(int i=0;i<testCase;i++){
           int N = scanner.nextInt();   //문서의 수
           int M = scanner.nextInt();   //몇번째로 출력되는지 궁금한 문서의번호
            // 출력 중요도
            Queue pQueue = new Queue(N);
            // 출력번호
            Queue q = new Queue(N);
            int[] priority = new int[N];
            for(int j=0;j<N;j++){
                int a = scanner.nextInt();
                priority[j]=a;
                q.push(j);      //문서번호
                pQueue.push(a);//중요도
            }

            int ret = 0;

            int print = -1;
            while(print!=M){

                int maxIndex = pQueue.getMaxIndex();
                Queue newQueue = new Queue(N);
                Queue newPriorityQueue = new Queue(N);

                for(int j=maxIndex;j<=q.back;j++){
                    newPriorityQueue.push(pQueue.list[j]);
                    newQueue.push(q.list[j]);
                }
                for(int j=q.front;j<maxIndex;j++){
                    newPriorityQueue.push(pQueue.list[j]);
                    newQueue.push(q.list[j]);
                }
                pQueue = newPriorityQueue;
                q = newQueue;

                pQueue.pop();
                print = q.pop();

                ret++;

            }
            System.out.println(ret+"");
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
        list[front]=-1;
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

    public int getMaxIndex(){
        int max = 0;
        int maxIndex = 0;
        if(size()==0){
            //error
        }
        for(int i=front;i<=back;i++){
            if(max<list[i]){
                max = list[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
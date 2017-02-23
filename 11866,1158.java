import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ret="";
        int N = scanner.nextInt();  //N명의 queue를 생성
        int M = scanner.nextInt();   //M번째 사람을 제거
        LinkedQueue q = new LinkedQueue();
        for(int i=1;i<=N;i++){
            q.insert(i);
        }
        while (!q.isEmpty()){
            for(int j=0;j<M-1;j++){
                //M-1번 queue의 첫번째원소를 마지막으로 보냄
                q.insert(q.pop());
            }
            ret+=q.pop()+",";
        }
        System.out.print("<");
        String[] tmp = ret.split(",");
        for(int i=0;i<tmp.length-1;i++){
            System.out.print(tmp[i]);
            System.out.print(", ");
        }
        System.out.print(tmp[tmp.length-1]);
        System.out.println(">");

        scanner.close();
    }


}

class LinkedQueue{
    class Node{
        int data;
        Node nextNode;

        Node(int data){
            this.data = data;
            this.nextNode = null;
        }
    }

    Node front;
    Node back;


    public LinkedQueue(){
        this.front = null;
        this.back = null;
    }

    public boolean isEmpty(){
        return (front==null);
    }

    public void insert(int n){
        Node node = new Node(n);

        if(isEmpty()){
            front = node;
            back = node;
        }else {
            back.nextNode = node;
            back = node;
        }
    }

    public int pop(){
        if(isEmpty()){
            return -1;  //error
        }else {
            int ret = front.data;
            front = front.nextNode;
            return ret;
        }
    }
}



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        Deque q = new Deque();
        for(int i=0;i<testCase;i++){
            String s = scanner.next();
            if(s.equals("push_front")){
                int j= Integer.parseInt(scanner.next());
                q.insertFront(j);
            }else if(s.equals("push_back")){
                int j= Integer.parseInt(scanner.next());
                q.insertRear(j);
            }else if(s.equals("pop_front")){
                System.out.println(q.deleteFront()+"");
            }else if(s.equals("pop_back")){
                System.out.println(q.deleteRear()+"");
            }else if(s.equals("size")){
                System.out.println(q.size()+"");
            }else if(s.equals("empty")){
                if(q.isEmpty()){ System.out.println("1");
                }else { System.out.println("0");}
            }else if(s.equals("front")){
                System.out.println(q.getFront()+"");
            }else if(s.equals("back")){
                System.out.println(q.getRear()+"");
            }
        }

        scanner.close();
    }


}


class Deque{
    class Node{
        int data;
        Node nextNode;
        Node lastNode;

        Node(int data){
            this.data = data;
            this.nextNode = null;
            this.lastNode = null;
        }
    }

    int itemSize;
    Node front;
    Node rear;


    public Deque(){
        itemSize = 0;
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty(){
        return (itemSize==0);
    }

    public void insertRear(int n){
        Node node = new Node(n);

        if(isEmpty()){
            front = node;
            rear = node;
        }else {
            node.lastNode = rear;
            rear.nextNode = node;
            rear = node;
        }
        itemSize++;
    }

    public void insertFront(int n){
        Node node = new Node(n);

        if(isEmpty()){
            front = node;
            rear = node;
        }else {
            node.nextNode = front;
            front.lastNode = node;
            front = node;
        }
        itemSize++;
    }

    public int deleteFront(){
        if(isEmpty()){
            return -1;  //error
        }else if(front.nextNode!=null){
            int ret = front.data;
            front = front.nextNode;
            front.lastNode = null;
            itemSize--;
            return ret;
        }else {
            int ret = front.data;
            front = null;
            rear=null;
            itemSize--;
            return ret;
        }

    }

    public int deleteRear(){
        if(isEmpty()){
            return -1;  //error
        } else if(rear.lastNode!=null){
            int ret = rear.data;
            rear = rear.lastNode;
            rear.nextNode=null;
            itemSize--;
            return ret;
        } else {
            int ret = rear.data;
            rear = null;
            front =null;
            itemSize--;
            return ret;
        }

    }

    public int size(){
        return itemSize;
    }

    public int getFront(){
        if(front==null){
            return -1;
        }else {
            return front.data;
        }
    }

    public int getRear(){
        if(rear==null){
            return -1;
        }else {
            return rear.data;
        }
    }
}



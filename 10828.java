import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int testCase = Integer.parseInt(scanner.nextLine());
        Stack s = new Stack(testCase);
        for(int i=0;i<testCase;i++){
            String tmp = scanner.nextLine();
            if(tmp.startsWith("push")){
                s.push(Integer.parseInt(tmp.split(" ")[1]));
            }else if(tmp.equals("pop")){
                System.out.println(s.pop()+"");
            }else if(tmp.equals("size")){
                System.out.println((s.top+1)+"");
            }else if(tmp.equals("empty")){
                if(s.isEmpty()){
                    System.out.println("1");
                }else {
                    System.out.println("0");
                }
            }else if(tmp.equals("top")){
                System.out.println(s.peek()+"");
            }
        }

        scanner.close();
    }
}

class Stack{
    //스택 필수함수 >push, pop, peek
    int top;    //최상단의 인덱스
    int maxSize;
    int[] stackArray;

    public Stack(int maxSize){
        stackArray = new int[maxSize];
        top = -1;
        this.maxSize = maxSize;
    }

    public void push(int n){
        if(isFull()){
            //스택가득차서 push못함
            // 따로 주어진 예외처리가 없으므로 그냥 명령어 무시
        }else {
            top++;
            stackArray[top]=n;
        }
    }

    public int pop(){
        if(isEmpty()){ //스택이 비어있음
            return -1;
        }else {
            int ret = stackArray[top];
            stackArray[top]=0;
            top--;
            return ret;
        }
    }

    public int peek(){
        if(top==-1){
            return -1;
        }
        else {
            return stackArray[top];
        }
    }

    public boolean isEmpty(){
        if(top==-1){ return true; }
        return false;
    }

    public boolean isFull(){
        if(top==maxSize-1){ return true; }
        return false;
    }
}


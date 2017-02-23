import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        for (int i=0;i<testCase;i++){
            String line = scanner.next();
            String[] word = line.split("");

            Stack s = new Stack(word.length);

            int errorFlag=0;
            for(int j=0;j<word.length;j++){
                if(word[j].equals("(")){
                    s.push(word[j]);
                }else if(word[j].equals(")")){
                    if(s.pop()==null){
                        System.out.println("NO");
                        errorFlag=1;
                        break;
                    }
                }
            }
            if(errorFlag==0){
                if(s.top==-1){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }

        }
        scanner.close();
    }
}

class Stack{
    //스택 필수함수 >push, pop, peek
    int top;    //최상단의 인덱스
    int maxSize;
    String[] stackArray;

    public Stack(int maxSize){
        stackArray = new String[maxSize];
        top = -1;
        this.maxSize = maxSize;
    }

    public boolean push(String n){
        if(isFull()){
            //스택가득차서 push못함
            return false;
        }else {
            top++;
            stackArray[top]=n;
            return true;
        }
    }

    public String pop(){
        if(isEmpty()){ //스택이 비어있음
            return null;
        }else {
            String ret = stackArray[top];
            stackArray[top]="";
            top--;
            return ret;
        }
    }

    public String peek(){
        if(top==-1){
            return "";
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

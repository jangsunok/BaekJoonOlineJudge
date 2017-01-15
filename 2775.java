import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int i = 0; i < testCase; i++) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int ret = getResult(k, n);
            System.out.println(""+ret);
        }
        scanner.close();
    }

    public static int getResult(int k, int n) {
        if(k==0){
            return n;
        }else if(n==1){
            return 1;
        }
        int ret= getResult(k, n-1)+getResult(k-1, n);
        return ret;
    }


    public static int getResultByRecursive(int k, int n) {
        if(k==0){
            return n;
        }
        int ret=0;
        for(int j=1; j<=n; j++){
            ret += getResult(k-1,j);
        }
        return ret;
    }
}
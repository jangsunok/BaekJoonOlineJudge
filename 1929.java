
import java.util.Scanner;

public class Main {
    static int[] primeList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNum = 1000000;
        setListOfPrime(maxNum);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        for(int i=M;i<=N;i++){
            if(isPrime(i)){
                System.out.println(i+"");
            }
        }
        scanner.close();
    }

    public static void setListOfPrime(int maxNum){
        primeList = new int[maxNum+1];
        primeList[1]=-1;
        for(int i=2;i<maxNum/2;i++){
            //i=2, 3, 4, 5, 6,,,,
            if(primeList[i]!=-1){
                for(int j=i*2;j<=maxNum;j+=i){
                    //j=i;2i;3i;
                    //소수가 아니면 -1로
                    primeList[j] = -1;
                }
            }

        }
    }


    public static boolean isPrime(int X){
        if(primeList[X]==-1){
            //소수아님
            return false;
        }else {
            return true;
        }
    }

}


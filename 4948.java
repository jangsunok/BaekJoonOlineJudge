import java.util.Scanner;

public class Main {
    static int[] primeList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNum = 123456*2;
        setListOfPrime(maxNum);
        int N = scanner.nextInt();
        while(N!=0){
            System.out.println(getNumOfPrime(N+1, N*2)+"");
            N = scanner.nextInt();
        }
        scanner.close();
    }

    public static int getNumOfPrime(int start, int finish){
        int ret = 0;
        for(int i=start;i<=finish;i++){
            if(isPrime(i)){
                ret++;
            }
        }
        return ret;
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
            return false;
        }else {
            return true;
        }
    }
}


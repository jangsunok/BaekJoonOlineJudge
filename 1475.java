import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        int ret = getResult(N);
        System.out.println(""+ret);
        scanner.close();
    }

    public static int getResult(String N) {
        int[] tmp = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String[] a = (N).split("");
        for(int i=0;i<a.length;i++){
            int t = Integer.parseInt(a[i]);
            tmp[t] = tmp[t]+1;
        }

        int maxIndex=0;
        int max=0;
        for(int i=0;i<tmp.length;i++){
            if(max<=tmp[i]){
                max = tmp[i];
                maxIndex = i;
            }
        }
        if(maxIndex==6 || maxIndex==9){
            int sum = tmp[6] + tmp[9];
            if(sum%2==0){
                tmp[6] = sum/2;
            } else {
                tmp[6] = sum/2 +1;
            }
            tmp[9] = 0;
        }
        max=0;
        for(int i=0;i<tmp.length;i++){
            if(max<tmp[i]){
                max = tmp[i];
            }
        }
        return max;
    }
}
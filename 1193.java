import java.util.Scanner;

/**
 * Created by jang on 2016. 12. 23..
 */

public class Main {
    static int gun = -1;
    static int hang = -1;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        findGunHang(N);
        //3군이라면 > x/y 에서 x+y=4
        //y=gun+1-x
        //
        int x = 0;
        int y = 0;
        if(gun%2==0){
            //gun이 짝수면 x=행
            //gun이 홀수면 x=군+1-행
            x = hang;
        }else {
            x = gun+1-hang;
        }
        y = gun+1-x;
        System.out.print(x+"/"+y);

    }

    public static void findGunHang(int num){
        //3군이라면 5 = 3군2행
        //1+2 < num <= 1+2+3
        //N군이라면
        //1+...+N-1 < num <=1+...+N
        //N-1*N/2 < num <= N*N+1/2

        //5 -1
        //     -2
        //          -3 <0  >>3군
        //5-1-2 = 2 >>2행
        int tmp = num;
        int i = 1;
        while(gun<0){
            if(tmp-i<=0){
                gun = i;
                hang = tmp;
            }else{
                tmp -= i;
                i++;
            }
        }
    }

}
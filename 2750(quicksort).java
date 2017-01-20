
import java.util.Scanner;

public class Main {
    static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        quickSort(array, 0, array.length-1);

        //print array
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]+"");
        }
    }


    public static void quickSort(int[] array, int left, int right){
        int pivot = array[left];
        int l = left;
        int r = right;

        while (l<r){
            while (array[r]>=pivot && l<r){
                r--;
            }
            if(l!=r){
                array[l] = array[r];
            }
            while (array[l]<=pivot && l<r){
                l++;
            }
            if(l!=r){
                array[r] = array[l];
                r--;
            }
        }

        array[l] = pivot;
        pivot = l;

        if(left<pivot){
            quickSort(array, left, pivot-1);
        }
        if(right>pivot){
            quickSort(array, pivot+1, right);
        }

    }
}
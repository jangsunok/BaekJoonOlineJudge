//Merge sort
//Heap Sort

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

        mergeSort(array, 0, array.length-1);

        //print array
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]+"");
        }

        scanner.close();

    }

    public static void mergeSort(int[] array, int left, int right){
        int mid;
        if(left<right){
            //분할이 다 안됬을때> 분할&정복
            mid = (left+right)/2;
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right){
        int[] tmp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k=0;

        while(i<=mid && j<=right){
            if(array[i]<array[j]){
                tmp[k] = array[i];
                i++;
            }else {
                tmp[k] = array[j];
                j++;
            }
            k++;
        }

        if (i > mid){
            for (int m = j; m <= right; m++){
                tmp[k] = array[m]; k++;
            }

        } else {
            // left 블록의 index가 아직 남아있을 경우 left index를 순차적으로 결과 result에 복사
            for (int m = i; m <= mid; m++){
                tmp[k] = array[m]; k++;
            }
        }
        

        for(int a=0;a<tmp.length;a++){
            array[left+a] = tmp[a];
        }
    }
}
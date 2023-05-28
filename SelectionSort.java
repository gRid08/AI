import java.util.Scanner;

public class SelectionSort {

    public static void display(int[] arr ){
        int n = arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void SelectionSort(int[] arr){
        int n= arr.length;
        for(int i=0;i<n-1;i++){
            int min = i;
            for(int j=i+1;j<n-1;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of Array: ");
        int m = sc.nextInt();
        int[] arr = new int[m];
        System.out.println("Enter array elements: ");
        for(int i=0;i<m;i++){
            arr[i] = sc.nextInt();
        }
        display(arr);
        System.out.println();
        SelectionSort(arr);
        display(arr);


    }
}

import java.util.Scanner;

public class NQueen{

    public static void print(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j< board[0].length;j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char[][] arr, int row, int col){
        for(int i=0;i<row;i++){
            if(arr[i][col]=='Q'){
                return false;
            }
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(arr[i][j] == 'Q'){
                return false;
            }
        }

        for(int i=row-1,j=col+1;i>=0 && j<arr[0].length;i--,j++){
            if(arr[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }




    public static void nQueen(char[][] arr,int row){
        if(row == arr.length){
            print(arr);
            System.out.println();
            System.out.println("---------------------");
            return;
        }
        for(int col=0;col<arr[0].length;col++){
            if(isSafe(arr, row, col)){
                arr[row][col] = 'Q';
                nQueen(arr, row+1);
                arr[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Queens: ");
        N = sc.nextInt();
        char[][] arr = new char[N][N];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j] = '.';
            }
        }
        nQueen(arr,0);


    }

}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
            in.nextLine();
        }

        for (int i = 0; i < m; i++) {
            if(k < matrix[i][0]){
                System.out.println(-1 + " " + -1);
                return;
            }

            int result = find(matrix[i], k);
            if(result != -1){
                System.out.println(i + " " + result);
                return;
            }
        }

        System.out.println(-1 + " " + -1);

    }

    private static int find(int[] a, int k){
        int l = 0;
        int h = a.length - 1;
        while(l <= h){
            int m = (l + h) / 2;
            if(a[m] > k) h = m - 1;
            else if(a[m] < k) l = m + 1;
            else return m;
        }
        return -1;
    }


}

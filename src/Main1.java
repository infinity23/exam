import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int mod = 1000000007;

        int[][] dp = new int[n][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {

            for (int j = 1; j <= k; j++) {
                int sum = 0;
                for (int l = 1; l <= j ; l++) {
                    sum += dp[i - 1][l];
                    sum %= mod;
                }

                int sum2 = 0;
                for (int l = j + j; l <= k; l += j) {
                    sum2 += dp[i-1][l];
                    sum2 %= mod;
                }
                dp[i][j] = (sum - sum2 + mod) % mod;
            }
        }

        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += dp[n-1][i];
            sum %= mod;
        }

        System.out.println(sum);


    }

}
import java.util.Scanner;

public class PalindromeMinSplit {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String ss = s.nextLine();
        char[] chars = ss.toCharArray();
        int len = chars.length;
        int[] d = new int[len + 1];
        d[len] = -1;
        boolean[][] dp = new boolean[len][len];
        for (int i = len -1; i >=0; i--) {
            d[i] = Integer.MAX_VALUE;
            for(int j = i; j < len; j++){
                if(chars[i] == chars[j] && (j - i < 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    d[i] = Math.min(d[i],d[j+1]+1);
                }
            }
            }
        System.out.println(d[0]);
        }
}

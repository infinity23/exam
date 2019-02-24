import java.util.LinkedList;
import java.util.Scanner;

public class MaxSubSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<char[]> list = new LinkedList<>();
        while(scanner.hasNextLine()){
            list.add(scanner.nextLine().toCharArray());
        }
        while(!list.isEmpty()){
            char[] line1= list.poll();
            char[] line2= reverse(line1);
            int[][] dp = getdp(line1,line2);
            System.out.println(line1.length-dp[line1.length-1][line2.length-1]);
        }
    }

    private static int[][] getdp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int i = 1; i < str2.length; i++) {
            dp[0][i] = Math.max(dp[0][i-1], str1[0]==str2[i] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(str1[i]==str2[j]){
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - 1] + 1);
                }

            }
        }
        return dp;
    }

    private static char[] reverse(char[] str){
        char[] chars = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            chars[i] = str[str.length - i - 1];
        }
        return chars;
    }

    //如果要求最长子序列的值
    private static String subSequence(String str1,String str2){
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] dp = getdp(ch1,ch2);
        int m = ch1.length - 1;
        int n = ch2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while(index >=0){
            if(n > 0 && dp[m][n] == dp[m][n-1]){
                n--;
            }else if(m>0 && dp[m][n] == dp[m-1][n]){
                m--;
            }else{
                res[index--] = ch1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }
}

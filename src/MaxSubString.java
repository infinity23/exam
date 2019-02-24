public class MaxSubString {
    public int[][] getdp(char[] str1,char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : 0;
        }
        for (int i = 1; i < str2.length; i++) {
            dp[0][i] = str1[0] == str2[i] ? 1 : 0;
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = str1[i] == str2[j] ? dp[i-1][j-1] + 1:0;
            }
        }
        return dp;
    }

    //经典动态规划法，时间O(m*n)空间O（m*n）
    public String subString(String str1,String str2){
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] dp = getdp(ch1,ch2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if(dp[i][j] > max){
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1,end + 1);
    }

    //压缩空间为O（1），只计算斜线的值
    public String subString2(String str1,String str2){
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] dp = getdp(ch1,ch2);
        int end = 0;
        int max = 0;
        int row = 0;
        int col = ch2.length - 1;
        while(row< ch1.length){
            int i = row;
            int j = col;
            int len = 0;
            while(i < ch1.length && j < ch2.length){
                if(ch1[i] != ch2[j]){
                    len = 0;
                }else{
                    len++;
                }
                if(len>max){
                    end = i;
                    max = len;
                }
                i++;
                j++;
            }
            if(col > 0){
                col--;
            }else{
                row++;
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }
}

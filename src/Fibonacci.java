//三种方法求斐波那契问题
public class Fibonacci {
    //递归，时间复杂度O(2^n)
    public int f1(int n){
        if(n < 1){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return f1(n-1) + f1(n-2);
    }

    //顺序，时间复杂度O(n)
    public int f2(int n){
        if(n < 1){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for(int i = 3; i<=n; i++){
            tmp = res;
            res += pre;
            pre = tmp;
        }
        return res;
    }

    //动态规划，矩阵乘法，时间复杂度O(logN)
    public int f3(int n){
        if (n < 1){
            return 0;
        }
        if(n == 1 || n ==2){
            return 1;
        }
        int[][] base = {{1,1},{1,0}};
        int[][] res = matrixPower(base, n-2);
        return res[0][0] + res[1][0];
    }


    //计算矩阵乘方，一共有logN位，所以时间复杂度是O(logN)
    public int[][] matrixPower(int[][] m, int p){
        int[][] res = new int[m.length][m[0].length];
        //res设为单位矩阵
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        //幂的二进制形式，从低位开始每次计算平方,再把所有1位累乘
        for (; p!=0; p>>=1){
            if((p&1) != 0){
                res = muliMatrix(res,tmp);
            }
            tmp = muliMatrix(tmp,tmp);
        }
        return res;
    }

    //矩阵乘法
    public int[][] muliMatrix(int[][] m1, int[][] m2){
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSubMatrix {
    public int getMaxSubMatrix(int[][] map){
        int n = map.length;
        int m = map[0].length;
        int[] arr = new int[m];
        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m;j++){
                arr[j] = map[i][j] == 0 ? 0 : arr[j] + 1;
            }
            int maxEach = findMaxMatrixEachLine(arr);
            if(maxEach > max)
                max = maxEach;
        }
        return max;
    }
    private int findMaxMatrixEachLine(int[] arr){
        Deque<Integer> stack  = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty()? -1 : stack.peek();
                int matrx = (i - k - 1)&arr[j];
                max = Math.max(matrx,max);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty()? -1 : stack.peek();
            int matrix = (arr.length - k - 1)*arr[j];
            max = Math.max(matrix,max);
        }
        return max;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num == null || size < 1 || size > num.length){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0; i<num.length; i++){

            while( (!list.isEmpty()) && (num[i] >= num[list.peekLast()]) ){
                list.pollLast();
            }

            list.offerLast(i);

            if(i - list.peekFirst() == size){
                list.pollFirst();
            }

            if(i >= size - 1){
                result.add(list.peekFirst());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxInWindows(new int[]{2,3,4,2,6,2,5,1},3));
    }
}
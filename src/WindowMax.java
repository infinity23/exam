import java.util.LinkedList;

public class WindowMax {
    public int[] getMaxWindow(int arr[], int w){
        if(arr == null || w < 1 || arr.length < w){
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while(!list.isEmpty() && arr[list.peekLast()] <= arr[i]){
                list.pollLast();
            }
            list.addLast(i);
            if(list.peek() == i - w){
                list.poll();
            }
            if(i >= w - 1){
                res[index++] = arr[list.peek()];
            }
        }
        return res;
    }
}

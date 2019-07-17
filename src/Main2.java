import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author wuenbang
 * @date 2019-06-24
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0) {
            return;
        }
        scanner.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(arr[0]);
        for (int i = 1; i < n; i++) {
            int val = arr[i];
            Integer top = stack.peek();
            while (top != null && val < top) {
                sb.append(stack.pop());
                sb.append(' ');
                top = stack.peek();
            }
            stack.push(val);
        }
        while (stack.peek() != null) {
            sb.append(stack.pop());
            sb.append(' ');
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}

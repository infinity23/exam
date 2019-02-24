import java.util.Deque;
import java.util.LinkedList;

//二叉树遍历
public class BinaryTreeTraversal {

    //三种递归 先 中 后
    public void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        preOrderRecur(head.left);
        System.out.println(head.val);
        preOrderRecur(head.right);
    }

    public void posOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        preOrderRecur(head.left);
        preOrderRecur(head.right);
        System.out.println(head.val);
    }

    //非递归实现
    public void preOrderUnRecur(TreeNode head) {
        if (head != null) {
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.val);
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    public void inOrderUnRecur(TreeNode head) {
        if (head != null) {
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode cur = head;
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.val);
                    head = head.right;
                }
            }
        }
    }

    //后序遍历 双栈实现
    public void posOrderUnRecur2(TreeNode head){
        if (head != null){
            Deque<TreeNode> stack1 = new LinkedList<TreeNode>();
            Deque<TreeNode> stack2 = new LinkedList<TreeNode>();

            stack1.push(head);
            while(!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if(head.left != null){
                    stack1.push(head.left);
                }
                if (head.right != null){
                    stack1.push(head.right);
                }
            }
            while(!stack2.isEmpty()){
                System.out.println(stack2.pop().val);
            }
        }
    }
}

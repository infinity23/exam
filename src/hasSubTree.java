//判断t1树是否含有t2树全部结构
public class hasSubTree {
    public boolean contains(TreeNode t1, TreeNode t2) {
        return check(t1,t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }

    public boolean check(TreeNode h, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (h == null || h.val != t2.val) {
            return false;
        }
        return check(h.left, t2.left) && check(h.right, t2.right);
    }



}

import java.util.LinkedList;

/**
 * @author wuenbang
 * @date 2019-07-14
 */
public class BinaryTreeMaxWidth {
    public int maxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        int res = 0;
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.remove();
            int count = list.size();
            res = Math.max(res, count);
            while (count-- > 0) {
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
        }
        return res;
    }
}

public class isBinaryTreeBalence {
    public boolean isBalance(TreeNode head){
        boolean[] res = new boolean[0];
        getHeight(head, 1, res);
        return res[0];
    }

    private int getHeight(TreeNode head, int level, boolean[] res) {
        if(head == null)
            return level;
        int lh = getHeight(head.left, level + 1, res);
        if(!res[0]){
            return level;
        }
        int rh = getHeight(head.right, level + 1,res);
        if (!res[0]){
            return level;
        }
        if(Math.abs(rh - lh) > 1){
            res[0] = false;
        }
        return Math.max(lh,rh);
    }
}

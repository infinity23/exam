import java.util.HashMap;

//先中后序遍历重构二叉树
public class ReconstructBT {
    //先序和中序
    public TreeNode priInToTree(int[] pre, int[] in){
        if(pre == null || in == null){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    private TreeNode preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, HashMap<Integer, Integer> map) {
        if(pi > pj){
            return null;
        }
        TreeNode head = new TreeNode(p[pi]);
        int index = map.get(p[pi]);
        head.left = preIn(p,pi+1,pi+index-ni,n,ni,index-1,map);
        head.right = preIn(p,pi+index-ni+1,pj,n,index+1,nj,map);
        return head;
    }

    //中序和后序
    public TreeNode inPosTree(int[] in, int[] pos){
        if(in == null || pos == null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return inPos(in,0,in.length-1,pos,0,pos.length-1,map);
    }

    private TreeNode inPos(int[] n, int ni, int nj, int[] p, int pi, int pj, HashMap<Integer,Integer> map){
        if(pi > pj){
            return null;
        }
        TreeNode head = new TreeNode(p[pj]);
        int index = map.get(p[pj]);
        head.left = inPos(n, ni, index - 1, p, pi, pi + index - ni -1, map);
        head.right = inPos(n, index + 1, nj, p, pi + index - ni + 1, pj - 1, map);
        return head;
    }

    //前序和后序，需要先判断每个节点的孩子数都为0或2
    public TreeNode prePosToTree(int[] pre, int[] pos){
        if(pre == null || pos == null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pos.length; i++) {
            map.put(pre[i],i);
        }
        return prePos(pre,0,pre.length-1,pos,0,pos.length-1,map);
    }

    private TreeNode prePos(int[] p, int pi, int pj, int[] s, int si, int sj, HashMap<Integer,Integer> map){
        TreeNode head = new TreeNode(s[sj--]);
        if(pi == pj)
            return null;
        int index = map.get(p[++pj]);
        head.left = prePos(p,pi,pi+index-si,s,si,index,map);
        head.right = prePos(p,pi+index-si+1,pj,s,index+1,sj,map);
        String ss = "abcacb";
        ss.indexOf("abc");

        return head;
    }


}

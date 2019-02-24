import java.util.LinkedList;

//求矩阵左上角到右下角的最短通路P384
//使用两个队列保存坐标，使用广度优先遍历
public class MatrixMinPassage {
    public int minPassage(int[][] m){
        int res = 0;
        int[][] map = new int[m.length][m[0].length];
        map[0][0] = 1;

        LinkedList<Integer> rq = new LinkedList<>();
        LinkedList<Integer> cq = new LinkedList<>();
        rq.add(0);
        cq.add(0);
        int r = 0;
        int c = 0;
        while (!rq.isEmpty()){
            r = rq.poll();
            c = rq.poll();
            if(r == m.length - 1 && c == m[0].length - 1){
                return map[r][c];
            }
            walkTo(map[r][c],r-1,c,m,map,rq,cq);
            walkTo(map[r][c],r+1,c,m,map,rq,cq);
            walkTo(map[r][c],r,c-1,m,map,rq,cq);
            walkTo(map[r][c],r,c+1,m,map,rq,cq);
        }
        return res;
    }

    private void walkTo(int pre, int toR, int toC, int[][] m,
                        int[][] map, LinkedList<Integer> rq, LinkedList<Integer> cq) {
        if(toR < 0 || toR == m.length || toC < 0 || toC == m[0].length
                || m[toR][toC] != 1 || map[toR][toC] != 0){
            return;
        }
        map[toR][toC] = pre + 1;
        rq.add(toR);
        cq.add(toC);
    }
}

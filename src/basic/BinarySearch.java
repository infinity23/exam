package basic;

public class BinarySearch {
    public int byLoop(int[] a, int k){
        int l = 0, h = a.length - 1;
        while(l <= h){
            int mid = (l + h )/ 2;
            if(k < a[mid]) h = mid - 1;
            else if(k > a[mid]) l = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int byRecurse(int[] a, int k){
        return find(a, k, 0, a.length - 1);
    }
    private int find(int[] a, int k, int l, int h){
        if(l > h){
            return -1;
        }
        int mid = (l + h)/2;
        if(k < a[mid]) return find(a, k, l, mid - 1);
        else if(k > a[mid]) return find(a, k, mid + 1, h);
        else return mid;
    }
}

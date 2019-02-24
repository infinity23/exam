package basic;

public class Excise {
    public static int binarySearch(int[] arr, int key){
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(arr[mid] < key) lo = mid + 1;
            else if(arr[mid] > key) hi = mid - 1;
            else return mid;
        }
        return -1;
    }
}

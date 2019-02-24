public class BinarySearch {
    public int byLoop(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(key > arr[mid])
                low = mid + 1;
            else if(key < arr[mid])
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public int byRecurse(int[] arr, int key){
        return findKey(arr,0, arr.length-1,key);
    }
    private int findKey(int[] arr, int low, int high, int key){
        int mid = low + (high - low)/2;
        if(low > high)
            return -1;
        if(key < arr[mid])
            return findKey(arr,low,mid - 1,key);
        else if(key > arr[mid])
            return findKey(arr,mid + 1,high,key);
        else return mid;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.byLoop(arr,5));
        System.out.println(bs.byRecurse(arr,5));
    }

}

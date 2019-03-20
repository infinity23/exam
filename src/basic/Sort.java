package basic;

import java.util.Arrays;

public class Sort {

    public void select(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < a.length; j++) {
                if(a[j] < a[minIdx]){
                    minIdx = j;
                }
            }
            exch(a, i, minIdx);
        }
    }

    public void insert(int[] a){
        for (int i = 1; i < a.length; i++) {
            if(a[i] < a[i-1]) {
                for (int j = 0; j < i; j++) {
                    if (a[i] > a[j]) {
                        ins(a, i, j);
                    }
                }
            }
        }
    }

    private void ins(int[] a, int i, int j){
        int temp = a[j];
        System.arraycopy(a, i, a, i + 1, j - i);
        a[i] = temp;
    }
    private void exch(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void bub(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length; j > i; j--) {
                if(a[j] < a[j - 1]){
                    exch(a, j, j - 1);
                }
            }
        }
    }

    public void shell(int[] a){
        int n = a.length;
        int h = 1;
        while(h < n/3)
            h = 3 * h + 1;
        while(h >= 1){
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if(a[i] > a[j]){
                        ins(a,i,j);
                    }
                }
            }
            h = h / 3;
        }
    }

    public void merge(int[] a){
        int[] aux = new int[a.length];
        mSort(a, 0, a.length - 1, aux);
    }

    public void merge2(int[]  a){
        int n = a.length;
        int[] aux = new int[n];
        for (int sz = 0; sz < n; sz += sz) {
            for (int l = 0; l < n - sz; l += sz + sz) {
                rMerge(a, l, l + sz - 1, Math.min(l + sz + sz - 1, n - 1), aux);
            }
        }
    }


    private void mSort(int[] a, int l, int h, int[] aux){
        if(l >= h){
            return;
        }
        int mid = (l + h) / 2;
        mSort(a, l, mid, aux);
        mSort(a, mid + 1, h, aux);
        rMerge(a, l, mid, h, aux);
    }

    private void rMerge(int[] a, int l, int mid, int h, int[] aux){
        int i = l;
        int j = mid + 1;
        System.arraycopy(a, l, aux, l, h - l + 1);
        for (int k = l; k <= h ; k++) {
            if(i > mid) a[k] = aux[j++];
            else if (j > h) a[k] = aux[i++];
            else if (aux[i] > aux[j]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public void quick(int[] a){
        qSort(a, 0, a.length - 1);
    }
    private void qSort(int[] a, int l, int h){
        if(l >= h){
            return;
        }
        int j = partition(a, l, h);
        qSort(a, l, j - 1);
        qSort(a, j + 1, h);
    }


    private int partition(int[] a, int l, int h){
        int i = l, j = h + 1;
        int v = a[l];
        while(true){
            while (a[++i] < v) if(i == h) break;
            while (v < a[--j]);
            if(i >= j) break;
            exch(a, i ,j);
        }
        exch(a, l ,j);
        return j;
    }


    public void heap(int[] a){
        int len = a.length;
        for (int i = len/2; i >= 1 ; i--) {
            sink(a, i, len);
        }
        while(len > 1){
            exch(a, 1, len--);
            sink(a, 1, len);
        }
    }

    private void sink(int[] a, int i, int len) {
        while(2 * i <= len){
            int j = 2 * i;
            if (j < len && a[j] < a[j+1]) j++;
            if(a[i] >= a[j]) break;
            exch(a, i, j);
            i = j;
        }
    }


}

import java.util.Comparator;
import java.util.concurrent.CountedCompleter;

/**
 * Created by ye on 16-9-3.
 */
public class Sort {
    static public void selectSort(Comparable[] a){
        int n = a.length;
        for (int i =0; i< n; i++){
            int min =i ;
            for (int j = i+1;j<n;j++){
                if (less(a[j],a[min])){
                    min = j;
                }
            }
            exch(a,min,i);
        }
    }

    static public void insertSort(Comparable[] a){
        int n = a.length;
        for (int i=1; i<n; i++){
            for (int j = i; j>0; j--){
                if (less(a[j],a[j-1])){
                    exch(a,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    static public void merge(Comparable[] a, int lo, int mid, int hi){
        Comparable[] aux = a.clone();
        int i = lo;
        int j = mid+1;
        for (int k=lo;k<=hi; k++){
            if (i>mid){
                a[k]=aux[j++];
            }
            else if (j>hi){
                a[k]=aux[i++];
            }
            else if (less(aux[i],aux[j])){
                a[k]=aux[i++];
            }
            else{
                a[k]=aux[j++];
            }
        }
    }
    static public  void mergeSort(Comparable[] a,int lo,int hi){
        if (hi <= lo) {
            return;
        }
        int mid=lo+(hi-lo)/2;

        mergeSort(a,mid+1,hi);
        mergeSort(a,lo,mid);
        merge(a,lo,mid,hi);
    }
    static public void mergeSort(Comparable[] a){
        int n = a.length;
        for (int sz =1; sz< n; sz =sz+sz){
            for (int lo=0; lo<n-sz; lo+=sz+sz){
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1, n-1));
            }
        }
    }

    static public void shellSort(Comparable[] a){
        int n = a.length;
        int h = 1;
        while (h<n/3){
            h=3*h+1;
        }

        while (h>=1){
            for (int i =h; i<n; i++){
                for (int j =i; j>=h; j--){
                    if (less(a[j],a[j-h])){
                        exch(a,j,j-h);
                    }else{
                        break;
                    }
                }
            }
            h=h/3;
        }
    }

    static public boolean less(Comparable a,Comparable b){
        if (a.compareTo(b)<0){
            return true;
        }else {
            return false;
        }
    }
    static public void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] =temp;
    }

    static public int partition(Comparable[] a, int lo, int hi){
        int i=lo;
        int j=hi+1;
        Comparable v = a[lo];
        while (true){
            while (less(a[++i],v)) if (i==hi) break;
            while (less(v,a[--j])) if (j==lo) break;
            if (i>=j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    public static void quickSort(Comparable[] a,int lo, int hi){
        if (hi<=lo){
            return;
        }
        int j = partition(a,lo,hi);
        quickSort(a,lo,j-1);
        quickSort(a,j+1,hi);
    }


}

/**
 * Created by ye on 16-9-5.
 */
public class Search<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] vals;
    private int n;
    public Search(int capacity){
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];

    }
    public int rank(Key key, int lo, int hi){
        if (hi<lo){
            return lo;
        }
        int mid = lo + (hi-lo)/2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp<0){
            return rank(key,lo,mid-1);
        }
        else if (cmp>0){
            return rank(key,mid+1,hi);
        }else {
            return mid;
        }
    }
    public void put(Key key,Value val){
        int i = rank(key);
        if (i<n&&keys[i].compareTo(key)==0){
            vals[i]=val;return;
        }
        for (int j=n; j>i; j--){
            keys[j]=keys[j-1];
            vals[j]=vals[j-1];
        }
        keys[i]=key;
        vals[i]=val;
        n++;

        for (Key a :
                keys) {
            System.out.print(a);
        }
        System.out.println();
    }

    public int rank(Key key){
        int lo=0;
        int hi=n-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp<0){
                hi=mid-1;
            }
            else if (cmp>0){
                lo=mid+1;
            }
            else {
                return mid;
            }
        }
        return lo;
    }

}

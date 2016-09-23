
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{5,3,4,8,6,7};
        int[] d= new int[a.length];


        for(int i=0;i<d.length;i++){
            d[i]=1;
            for (int j = 0;j<i;j++){
                if (a[j]<=a[i]&&d[j]+1>d[i]) d[i]=d[j]+1;
            }
        }
        for (int i :
                d) {
            System.out.print(i);
        }
    }

    public static int rank(int[] keys,int key){
        int lo = 0;
        int hi = keys.length-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if (key == keys[mid]){
                return mid;
            }
            else if (key>keys[mid]){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return lo;
    }

    public static int rank1(int[] keys,int key,int lo,int hi){
        if(lo>=hi) return lo;
        int mid = lo+(hi-lo)/2;
        if (key==keys[mid]){
            return mid;
        }
        else if (key > keys[mid]){
            return rank1(keys,key,mid+1,hi);
        }else{
            return rank1(keys,key,lo,mid-1);
        }
    }

    public static void sortx(int[] a){
        int n = a.length;
        int h=1;
        while (h<n/3){
            h=h*3+1;
        }
        while (h>=1)
        {
            for (int i=h;i<n;i++){
                for (int j=i; j>0;j-=h){
                    if (a[j]<a[j-h]){
                        int temp = a[j];
                        a[j]=a[j-h];
                        a[j-h]=temp;
                    }
                }
            }
            h=h/3;
        }

    }

    public static int creat(int n){
        if (n==1) return 0;
        if (n==2) return 1;
        return creat(n-1)+creat(n-2);

    }

    public static List<String> getGray(int n){
        List<String> gray = new LinkedList<>();

        if (n==1){
            gray.add("4");
            gray.add("7");
        }
        else {
            List<String> lastGray = getGray(n-1);
            Iterator<String> iter = lastGray.iterator();
            for (;iter.hasNext();){
                gray.add("4"+iter.next());
            }
            iter = lastGray.iterator();
            for (;iter.hasNext();){
                gray.add("7"+iter.next());
            }
        }
        return gray;
    }

    public static void snack(int n){

        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++){
            for ( int j = 0; j < array[i].length; j++){
                array[i][j]=0;
            }
        }

        int count = 1;

        int rowNum = 0;
        int colNum = 0;

        int max=n*n;
//        int count1=0;
        while(true)
        {
//            count1++;
//            System.out.println("here");
//            if (count1>n/2)
//            {
//                break;
//            }
            if (count>max){
                break;
            }

            for (; colNum<n && array[rowNum][colNum]==0; colNum++){
                array[rowNum][colNum]=count++;
            }
            colNum--;
            rowNum++;

            for (; rowNum < n && array[rowNum][colNum]==0; rowNum++){
                array[rowNum][colNum]=count++;
            }
            rowNum--;
            colNum--;

            for (; colNum >= 0 && array[rowNum][colNum]==0; colNum--){
                array[rowNum][colNum]=count++;
            }
            rowNum--;
            colNum++;

            for (; rowNum > 0 && array[rowNum][colNum]==0; rowNum--){
                array[rowNum][colNum]=count++;
            }
            colNum++;
            rowNum++;
        }

        for (int[] row :
                array) {
            for (int i :
                    row) {
                System.out.print(i+"  ");
            }
            System.out.println();
        }
    }
}


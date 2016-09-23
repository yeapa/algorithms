import java.util.Scanner;

/**
 * Created by ye on 16-9-3.
 */
public class MaxNoContinueTwo {
    static public void  MaxSum(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] flags = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = in.nextInt();
            flags[i] = 0;
        }

        for (int i=0; i<n; i++){
            flags[i] = 1;
            if (i >=2){
                int j = i-2;
                int x = checkThree(nums,j,flags);
                if (x!=-1){
                    for (int k = j;k>=0; k--){
                        flags[k]=1;
                        int z=checkThree(nums,k,flags);
                        if (z!=-1)
                            flags[z] =0;
                    }
                }
            }

        }
        int ret = 0;
        for (int i :
                flags) {
            System.out.print(i);
        }
        System.out.println();
        for (int i=0;i<n;i++){
            if (flags[i]==1){
                ret+=nums[i];
            }
        }
        System.out.println("max:  "+ret);


    }

    static public int checkThree(int[] array,int i,int[] flags){
        int j = i+1;
        int k = j+1;
        if (flags[i]==1 && flags[i] == flags[j] && flags[j]==flags[k]){
            int ret=i;
            int orin = array[i];
            for (int o=i;o<k+1;o++){
                if (array[o]<orin){
                    ret = o;
                }
            }
            return ret;
        }else{
            return -1;
        }
    }

}

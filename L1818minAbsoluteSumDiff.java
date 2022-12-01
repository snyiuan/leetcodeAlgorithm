package leetCode;

import java.util.Arrays;

public class L1818minAbsoluteSumDiff {
    public static void main(String[] args) {       
        int[] nums1 = new int[]{1,10,4,4,2,7};
        int[] nums2 = new int[]{9,3,5,1,7,4};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));

    }

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        /* max  |a - b|- |a* - b|        
         * a* ≈ b
         */
        final int mod = (int)(1e9)+7;
        int[] copy = new int[nums1.length];
        int sum = 0;
        System.arraycopy(nums1, 0, copy, 0, nums1.length);
        Arrays.sort(copy);
        int max = 0 ;
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum =  (sum+diff)% mod;
            int index = search(copy, nums2[i]);
            if(index<copy.length){
                max = Math.max(max, diff-Math.abs(copy[index]-nums2[i]));
            }
            if(index>0){
                max = Math.max(max, diff - Math.abs(copy[index - 1] - nums2[i]));
            }

        }
        return (sum-max+mod)%mod;
    }
    public static int search(int[] arr,int target){
        int l = 0 ;
        int r = arr.length-1;
        while(l<=r){
            int mid = l + (r - l) / 2;
            if(arr[mid]<=target){
                l = mid + 1;
            }else{
                r = mid -1;
            }
        }
        return l;
    }

    public static int minAbsoluteSumDiff2(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        int sum = 0, maxn = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            int j = binarySearch(rec, nums2[i]);
            if (j < n) {
                maxn = Math.max(maxn, diff - (rec[j] - nums2[i]));
            }
            if (j > 0) {
                maxn = Math.max(maxn, diff - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum - maxn + MOD) % MOD;
    }

    public static  int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }



}

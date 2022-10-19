package leetCode;

public class L1838maxFrequency {
    
    public static void main(String[] args) {
        

    }
    public int maxFrequency(int[] nums, int k) {
        if(nums.length==1){
            return 1;
        }
        int l =0 ;
        int sum = 0 ;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            sum +=(nums[i]-nums[i-1])*(i-l);
            
            while(sum>k){
                sum -= nums[i] - nums[l];
                l++;
            }
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}

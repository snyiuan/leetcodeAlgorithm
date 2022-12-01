package leetCode;

public class L275hIndex {
    public static void main(String[] args) {

        System.out.println(hIndex(new int[] { 0, 0, 1 }));
    }
    public static int hIndex(int[] citations) {
        // 0 1 2 3 3 4 5 7 8 9
        // 1 1 1 1 1 1
        int r = 100000;
        int l = 0;
        int ans =0;
        while(l<=r){
            int mid = l+ (r-l)/2;
            if (check(citations, mid)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid -1;
            }

        }
        return ans;
    }
    public static boolean check(int[] citations, int h){
        int lcnt = 0 ;
        int rcnt = 0;
        for (int i = 0; i < citations.length; i++) {
            if(citations[i]<h){
                lcnt++;
            }else {
                rcnt++;
            }
        }
        return rcnt >= h ;
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int item : nums){
            ans = ans ^ item;
        }
        return ans;
    }
}
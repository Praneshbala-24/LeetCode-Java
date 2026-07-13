class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left=1;
        int right=1;
        int[] ans=new int[nums.length];
        int n=0;
        for(int i=0;i<nums.length;i++){
            ans[n++]=left;
            left*=nums[i];
        }
        for(int j=nums.length-1;j>=0;j--){
            ans[j]*=right;
            right*=nums[j];
        }
        return ans;
    }
}
class Solution {
    public int missingNumber(int[] nums) {
        int Sum=0;
        int arrSum=0;

        for(int i=1; i<=nums.length; i++){
            Sum = Sum + i;
        }

        for(int i=0; i<nums.length; i++){
            arrSum = arrSum + nums[i];
        }

        int result = Sum - arrSum;
        return result;
    }
}
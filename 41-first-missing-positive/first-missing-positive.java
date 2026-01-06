class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int count = 1;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] >= 0){
                set.add(nums[i]);
            }
            
        }
        for(int i = 0; i < set.size(); i++){
            if(!set.contains(count)){
                return count;
            }
            count++;
        }
        return count;
    }
}
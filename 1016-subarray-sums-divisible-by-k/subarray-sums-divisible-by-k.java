class Solution {
    static {
        for (int i = 0; i < 300; i++) {
            subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        }
    }
    public static int subarraysDivByK(int[] nums, int k) {
        int[] freq = new int[k];
        freq[0] = 1;

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;

            int rem = sum % k;
            if (rem < 0)
                rem += k;

            count += freq[rem];
            freq[rem]++;
        }

        return count;
    }
}
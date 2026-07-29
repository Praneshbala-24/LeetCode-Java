class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int half = n / 2;
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int[] halfFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }
        StringBuilder left = new StringBuilder();
        for (int pos = 0; pos < half; pos++) {
            for (int ch = 0; ch < 26; ch++) {
                if (halfFreq[ch] == 0) {
                    continue;
                }
                halfFreq[ch]--;
                long count = countPermutations(
                    halfFreq,
                    half - pos - 1,
                    k
                );
                if (count >= k) {
                    left.append((char) ('a' + ch));
                    break;
                }
                k -= count;
                halfFreq[ch]++;
            }
        }
        if (left.length() != half) {
            return "";
        }
        String right = new StringBuilder(left)
                .reverse()
                .toString();
        if (n % 2 == 1) {
            char middle = ' ';
            for (int i = 0; i < 26; i++) {
                if (freq[i] % 2 == 1) {
                    middle = (char) ('a' + i);
                    break;
                }
            }
            return left.toString() + middle + right;
        }
        return left.toString() + right;
    }
    private long countPermutations(int[] freq, int remaining, long limit) {
        long result = 1;
        int used = 0;
        for (int f : freq) {
            for (int j = 1; j <= f; j++) {
                used++;
                result = result * used / j;
                if (result >= limit) {
                    return limit;
                }
            }
        }

        return result;
    }
}
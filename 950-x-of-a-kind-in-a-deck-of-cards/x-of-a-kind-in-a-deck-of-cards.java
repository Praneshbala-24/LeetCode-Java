class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) {
            return false;
        }
        int max = 0;
        for (int card : deck) {
            if (card > max) {
                max = card;
            }
        }
        int[] freq = new int[max + 1];
        for (int card : deck) {
            freq[card]++;
        }
        int overallGcd = 0;
        for (int count : freq) {
            if (count > 0) {
                overallGcd = gcd(overallGcd, count);
            }
        }
        return overallGcd >= 2;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
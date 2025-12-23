class Solution {
    public boolean isPalindrome(String s) {
        String c = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String r = new StringBuilder(c).reverse().toString();
        return c.equals(r);
    }
}

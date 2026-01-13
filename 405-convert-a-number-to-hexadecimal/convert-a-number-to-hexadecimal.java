class Solution {
    public String toHex(int num) {
        if (num == 0)
            return "0";

        String hex = "0123456789abcdef";
        String result = "";

        while (num != 0) {
            int rem = num & 15;           
            result = hex.charAt(rem) + result;
            num = num >>> 4;             
        }

        return result;
    }
}
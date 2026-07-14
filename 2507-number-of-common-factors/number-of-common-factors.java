class Solution {
    public int commonFactors(int a, int b) {
        int c = Math.min(a,b);
        int t =0;
        for(int i =1;i<=c;i++){
            if(a % i == 0 && b % i==0){
                t++;
            }
        }
        return t;
    }
}
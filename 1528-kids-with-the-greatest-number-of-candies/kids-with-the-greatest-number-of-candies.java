class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res= new ArrayList<>(candies.length);
        int max= Arrays.stream(candies).max().getAsInt();
        for (int i=0; i<candies.length; i++){
            if(candies[i] + extraCandies >= max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}
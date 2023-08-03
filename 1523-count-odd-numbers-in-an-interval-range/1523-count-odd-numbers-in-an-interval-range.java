class Solution {
    public int countOdds(int low, int high) {
        int temp = high-low+1;
        if(temp%2==0)
            return temp/2;
        if(low%2==1)
            return temp/2 +1;
        return temp/2;
    }
}
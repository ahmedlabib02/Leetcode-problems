class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        long reach = 0;                    // we can make all sums in [1..reach]
        for (int x : coins) {
            if (x > reach + 1) 
                break;      // gap at reach+1
            reach += x;                    // extend coverage
        }
        return (int)(reach + 1);
    }
}
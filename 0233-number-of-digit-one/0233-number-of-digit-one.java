class Solution {
    List<Integer> list;
    int[][][] memo;
    
    public int countDigitOne(int n) {
        list = new ArrayList<>();
        while(n != 0) {
            list.add(0, n % 10);
            n /= 10;
        }
        memo = new int[10][10][2];
        for(int[][] x: memo)
            for(int[] z: x)
                Arrays.fill(z, -1);
          
        return dp(0, 0, 1);  
    }
    
    public int dp(int index, int sum, int tight) {
        if(index == list.size())
            return sum;
        
        if(memo[index][sum][tight] != -1)
            return memo[index][sum][tight];
        
        int num = 0;
        
        if(tight == 1) {
            for(int i = 0; i <= list.get(index); i++) {
                if(i == list.get(index)) {
                    if(i == 1)
                        num += dp(index + 1, sum + 1, 1);
                    else
                        num += dp(index + 1, sum, 1);
                } else if(i == 1) {
                    num += dp(index + 1, sum + 1, 0);
                } else {
                    num += dp(index + 1, sum, 0);
                }
            } 
            
        } else {
            for(int i = 0; i <= 9; i++) {
                if(i == 1) {
                    num += dp(index + 1, sum + 1, 0);
                } else {
                    num += dp(index + 1, sum, 0);
                }
            }
        }
        memo[index][sum][tight] = num;
        return memo[index][sum][tight];
    }
}

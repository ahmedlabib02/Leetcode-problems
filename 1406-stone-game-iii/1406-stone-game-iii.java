class Solution {
    int[][] memo;
    int[] arr;
    public String stoneGameIII(int[] stoneValue) {
        arr= stoneValue;
        memo = new int[2][stoneValue.length];
        Arrays.fill(memo[1], -1);
        Arrays.fill(memo[0], -1);
        // for(int i=0;i<memo[1].length;i++)
        //     System.out.println(memo[0][i]);
        int x= dp(0,0);
        if(x==0)
            return "Tie";
        if(x>0)
            return "Alice";
        return "Bob";
    }
    public int dp(int i, int round)
    {
        if(i==arr.length)
            return 0;
        if(memo[round%2][i]!=-1)
        {
            return memo[round%2][i];
        }
            
        if(round%2==0)
        {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(int j=i;j<arr.length && j<i+3;j++)
            {
                sum+= arr[j];
                max = Math.max(sum+dp(j+1,round+1 ), max);
            }
            memo[0][i]= max;   
            
        }
        else 
        {
            int min = Integer.MAX_VALUE;
            int sum= 0;
            for(int j=i;j<arr.length && j<i+3;j++)
            {
                sum-= arr[j];
                min = Math.min(sum+dp(j+1,round+1), min);
            }
            memo[1][i]= min;
        }
        return memo[round%2][i];
    }
}
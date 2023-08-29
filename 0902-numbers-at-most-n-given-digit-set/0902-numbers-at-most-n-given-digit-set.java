class Solution {
    boolean[] nums;
    int[][][] memo;
    List<Integer> list;
    int valid;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        valid = 0;
        nums = new boolean[10];
        nums[0]=true;
        for(String s  :digits)
        {
            int num =Integer.parseInt(s);
            valid++;
            nums[num]= true;
        }
        list = new ArrayList<>();
        while(n!=0)
        {
            list.add(0,n%10);
            n/=10;
        }
        memo  = new int[10][2][2]; // 10 for the max poss 10 digits, 2 for tight
        for(int[][] z: memo)
        for(int[] x: z)
            Arrays.fill(x,-1);
        return dp(0,1,1);
    }
    public int dp(int index, int tight, int zeros)
    {
        if(index==list.size())
            return 1;
        if(memo[index][tight][zeros]!=-1)
            return memo[index][tight][zeros];
        int count=0;
        int start = (zeros==1 && index!=list.size()-1)?0:1;
        if(tight==1)
        {
                for(int i=start;i<=list.get(index);i++)
                {
                    if(!nums[i])
                    continue;
                    int isZero = (i==0)?1:0;
                    if(i==list.get(index))
                        count+= dp(index+1, 1,isZero);
                    else
                        count+= dp(index+1,0,isZero);
            }
            
        }
        else
        {
            
            if(start==0)
                count+= dp(index+1, 0,1);
            count+=valid*dp(index+1,0,0);
        }
        memo[index][tight][zeros]= count;
        return memo[index][tight][zeros];
    }
    
    
    
}
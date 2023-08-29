class Solution {
    int[][][] memo;
    List<Integer> list;
    public int rotatedDigits(int n) {
        memo = new int[5][2][2]; //5 possbile digits 2 (valid and invalid till now) and 2 for tight
        list = new ArrayList<>();
        while(n!=0)
        {
            list.add(0,n%10);
            n/=10;
        }
        for(int[][] x: memo)
            for(int[] z: x)
                Arrays.fill(z,-1);
        int valid = 0;
        return dp(0,0,1);
    }
    
    public int dp(int index , int valid , int tight)
    {
        if(index==list.size())
            return valid;
        if(memo[index][valid][tight]!=-1)
            return memo[index][valid][tight];  
        int count = 0;
        if(tight==1)
        {
            for(int i =0;i<=list.get(index);i++)
            {
                if(i==7 || i==3 || i==4)
                    continue;
                if(i==1 || i==0 || i==8)
                {
                    if(list.get(index)==i)
                        count+= dp(index+1, valid,1);
                    else
                        count+= dp(index+1,valid, 0);
                }
                else 
                {
                    if(list.get(index)==i)
                        count+= dp(index+1, 1, 1);
                    else
                        count+= dp(index+1,1,0);
                }
            }
        }
        else
        {
            for(int i =0;i<=9;i++)
            {
                if(i==1|| i==0|| i==8)
                    count+= dp(index+1, valid, 0);
                else if(i==9 || i==5|| i==2 || i==6)
                    count+= dp(index+1, 1, 0);
            }
        }
        memo[index][valid][tight]= count;
        return memo[index][valid][tight];
    }
}
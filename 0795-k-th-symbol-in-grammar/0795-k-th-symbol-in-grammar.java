class Solution {
    public int kthGrammar(int n, int k) {
        return helper(k);
    }
    public int helper(int k)
    {
        if(k==1)
            return 0;
        int parent = helper(k/2 + k%2);
        int parity = k%2;
        if(parent==1 && parity==1)
            return 1;
        if(parent==1)
            return 0;
        if(parent==0 && parity==1)
            return 0;
        return 1;
    }
}
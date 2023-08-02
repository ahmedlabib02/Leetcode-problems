class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        int window=0;
        int x= cardPoints.length-k;
        for(int i=0;i<cardPoints.length;i++)
        {
            if(i<x)
            {
                window+= cardPoints[i];
            }
            sum+= cardPoints[i];
        }
        int temp=window;
        int i=0;
        int j=x;
        while(j<cardPoints.length)
        {
            temp= temp-cardPoints[i]+cardPoints[j];
            window=Math.min(temp,window);
            i++;
            j++;
        }

        return sum-window;
    }
}
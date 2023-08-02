class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] arrival = new double[dist.length];
        for(int i=0;i<dist.length;i++)
        {
           arrival[i]= (double) dist[i]/speed[i]; 
        }
        Arrays.sort(arrival);
        int count=0;
        for(int i=0;i<dist.length;i++)
        {
            if(arrival[i]>i)
                count++;
            else return count;
        }
        return count;
    }
    
}
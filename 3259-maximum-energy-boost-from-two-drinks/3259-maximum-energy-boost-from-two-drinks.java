class Solution {
    public long maxEnergyBoost(int[] a, int[] b) {
        long sum=0;
        int n = a.length;
        long[] maxA = new long[n+1];
        long[] maxB = new long[n+1];
        maxA[0] = a[0];
        maxB[0] = b[0];
        maxA[1] = a[0]+a[1];
        maxB[1] = b[0]+ b[1];
        for(int i=2;i<a.length;i++)
        {
            // maxA[i] = math.max(a[i], );
            maxA[i] = Math.max(a[i]+ maxB[i-2], a[i]+maxA[i-1]);
            maxB[i]=  Math.max(b[i]+ maxA[i-2], b[i]+maxB[i-1]);
        }
        return Math.max(maxA[n-1], maxB[n-1]);
    }
}
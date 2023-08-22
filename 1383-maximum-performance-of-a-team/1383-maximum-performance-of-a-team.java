class Solution {
    int mod = 1000000007;
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }
        Arrays.sort(engineers, (a, b) -> b[1] - a[1]); // Sort by efficiency in descending order
        
        long ans = 0;
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            sum += engineers[i][0];
            pq.add(engineers[i][0]);
            
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            
            ans = Math.max(ans, (sum * engineers[i][1]) ); // Multiply by efficiency
        }
        return (int) (ans% mod);
    }
}

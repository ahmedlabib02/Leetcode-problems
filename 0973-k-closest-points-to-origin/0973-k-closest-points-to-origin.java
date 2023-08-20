class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq= new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a , int[] b)
            {
                int x= a[0]*a[0] + a[1]*a[1];
                int y= b[0]*b[0]+ b[1]*b[1];
                if(x==y)
                    return 0;
                if(x<y)
                    return -1;
                return 1;
            }
        });
        for(int[] point: points)
            pq.offer(point);
        // System.out.print(pq);
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++)
            ans[i]= pq.poll();
        return ans;
            
    }
}
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
    
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            int x = nums2[a];
            int y = nums2[b];
            return y-x; // Corrected the comparison order
        }
    });
        for(int i=0;i<nums1.length;i++)
            pq.offer(i);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        long sum =0;
        long ans=0;
        int count=0;
        while(!pq.isEmpty())
        {
            int index= pq.remove();
            min.add(nums1[index]);
            sum+= nums1[index];
            if(count==k)
            {
                sum-= min.poll();
            }
            else
                count++;
            if(count==k)
                ans = Math.max(sum*nums2[index],ans);
            
            // System.out.println(ans+" "+sum);
        }
        return ans;
    }
}
class Solution {
   public int findLatestStep(int[] arr, int m) {
        if(m==arr.length)
            return m;
        int[][] intervals = new int[arr.length+2][2];
        Arrays.fill(intervals, null);
        int ans =-1;
        for(int i=0;i<arr.length;i++)
        {
            int num = arr[i];
            int[] interval = null;
            if(intervals[num-1]!=null && intervals[num+1]!=null)
            {
                int[] leftInterval = intervals[num-1]; // the num -1 is the upper bound in this interval
                int[] rightInterval = intervals[num+1]; // the num+1 is the lower bound in this interval
                if(leftInterval[1]-leftInterval[0]+1==m || rightInterval[1]-rightInterval[0]+1==m)
                {
                    ans = i; // record the latest step
                }
                leftInterval[1] = rightInterval[1];
                intervals[leftInterval[1]] = leftInterval;

            }
            else if(intervals[num-1]!=null)
            {
                interval =intervals[num-1]; // the num -1 is the upper bound in this interval
                if(interval[1]-interval[0]+1==m)
                {
                    ans = i; // record the latest step
                }
                interval[1]++;
                intervals[num] = interval;
            }
            else if(intervals[num+1]!=null)
            {
                interval =intervals[num+1]; // the num+1 is the lower bound in this interval
                if(interval[1]-interval[0]+1==m)
                {
                    ans = i; // record the latest step
                }
                interval[0]--;
                intervals[num] = interval;
            }
            else
            {
                intervals[num] = new int[]{num, num};
            }
        }
        return ans;
    }
}
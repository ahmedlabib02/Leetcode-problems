class Solution {
   public int findLatestStep(int[] arr, int m) {
        if(m==arr.length)
            return m;
        HashMap<Integer, int[]> map = new HashMap<>(arr.length);
        int ans =-1;
        for(int i=0;i<arr.length;i++)
        {
            int num = arr[i];
            int[] interval = null;
            if(map.containsKey(num-1) && map.containsKey(num+1))
            {
                int[] leftInterval = map.get(num-1); // the num -1 is the upper bound in this interval
                int[] rightInterval = map.get(num+1); // the num+1 is the lower bound in this interval
                if(leftInterval[1]-leftInterval[0]+1==m || rightInterval[1]-rightInterval[0]+1==m)
                {
                    ans = i; // record the latest step
                }
                leftInterval[1] = rightInterval[1];
                map.put(leftInterval[0], leftInterval);
                map.put(leftInterval[1], leftInterval);
            }
            else if(map.containsKey(num-1))
            {
                interval =map.get(num-1); // the num -1 is the upper bound in this interval
                if(interval[1]-interval[0]+1==m)
                {
                    ans = i; // record the latest step
                }

                interval[1]++;
                map.put(num,interval);
            }
            else if(map.containsKey(num+1))
            {
                interval =map.get(num+1); // the num+1 is the lower bound in this interval
                if(interval[1]-interval[0]+1==m)
                {
                    ans = i; // record the latest step
                }
                interval[0]--;
                map.put(num,interval);
            }
            else
            {
                map.put(num, new int[]{num, num});
            }
        }
        return ans;
    }
}
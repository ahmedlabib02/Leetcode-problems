class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] sortedTasks= new int[tasks.length][3];
        for (int i = 0; i < tasks.length; ++i) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
        int[] x = tasks[a];
        int[] y = tasks[b];
        if (y[1] == x[1])
            return a - b; // Compare based on original index
        return x[1] - y[1];
        }
        });

        
        int time = sortedTasks[0][0];
        int i =0;
        while(i<tasks.length && sortedTasks[i][0]<=time)
            pq.add(sortedTasks[i++][2]);
        int j=0;
        int[] ans=  new int[tasks.length];
        while(!pq.isEmpty())
        {
            int index=  pq.poll();
            time += tasks[index][1];
            while(i<sortedTasks.length && sortedTasks[i][0]<=time)
                pq.offer(sortedTasks[i++][2]);
            if(pq.isEmpty()&& i<tasks.length)
            {
                time = sortedTasks[i][0];
                while(i<tasks.length && sortedTasks[i][0]<=time)
                    pq.offer(sortedTasks[i++][2]);
            }
            ans[j++]= index;
         
        }
        return ans;
    }
   
}
import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int ans = w;
        Comparator<int[]> pairComparator = new Comparator<>() {
    @Override
        public int compare(int[] a, int[] b) {
        if (a[1] != b[1]) 
            return a[1] - b[1]; // sort on capital in ascending order
        else 
            return b[0] - a[0]; // sort on profit in descending order
        }
    };

        Comparator<int[]> comp = new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];    //sort on profit
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(pairComparator);
        PriorityQueue<int[]> max = new PriorityQueue<>(comp);
        for (int i = 0; i < profits.length; i++) {
            int[] pair = new int[2];
            pair[0] = profits[i];
            pair[1] = capital[i];
            pq.add(pair);
        }
        
        while(!pq.isEmpty())
        {
            int[] temp = pq.peek();
            if(temp[1]>w)
            {
                if(max.isEmpty())
                    return ans;
                int num = max.poll()[0];
                ans+= num;
                w+= num;
                k--;
            }
            else
            {
                max.add(pq.poll());
            }
            if(k==0)
                return ans;
        }
        while(k>0&& !max.isEmpty())
        {
            ans+=max.poll()[0];
            k--;
        }
            
        
       return ans; 
    }
    
    
}


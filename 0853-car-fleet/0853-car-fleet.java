class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] both = new int[position.length][2];
        for(int i=0;i<position.length;i++)
        {
            both[i][0]= position[i];
            both[i][1]= speed[i];
        }
        Arrays.sort(both, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0]==b[0])
                    return Integer.compare(a[1],b[1]);
                return Integer.compare(b[0], a[0]);
            }
        });
        // for(int[] pair : both)
        //     System.out.println(pair[0]+" "+pair[1]);
        Stack<Double> stack = new Stack<>();
        int ans=0;
        for(int[] pair: both)
        {
            double num= (double)(target-pair[0])/pair[1];
            if(stack.isEmpty())
            {
                stack.push(num);
                continue;
            }
            
            if(num>stack.peek())
            {
                ans++;
                while(!stack.isEmpty() && num>stack.peek())
                    stack.pop();
                stack.push(num);
            }
            // System.out.println(stack);
                
            
        }
        return ans+1;
    }
}
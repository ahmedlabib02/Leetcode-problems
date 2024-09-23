class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, ArrayList<Integer>> samex = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> samey = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        // Store each point as a "x,y" string in the set
        for (int i = 0; i < points.length; i++) {
            if (!samex.containsKey(points[i][0])) {
                samex.put(points[i][0], new ArrayList<>());
            }
            if (!samey.containsKey(points[i][1])) {
                samey.put(points[i][1], new ArrayList<>());
            }
            samex.get(points[i][0]).add(i);
            samey.get(points[i][1]).add(i);
            
            // Adding the point to the set as a string in the format "x,y"
            set.add(points[i][0] + "," + points[i][1]);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            ArrayList<Integer> hor = samex.getOrDefault(x, new ArrayList<>());
            ArrayList<Integer> ver = samey.getOrDefault(y, new ArrayList<>());
            for (int j = 0; j < hor.size(); j++) {
                int index = hor.get(j);
                int diaY = points[hor.get(j)][1];
                if (index == i)
                    continue;
                
                for (int w = 0; w < ver.size(); w++) {
                    int index2 = ver.get(w);
                    int diaX = points[ver.get(w)][0];
                    if (index2 == i)
                        continue;
                    
                    // Check if diagonal opposite point exists
                    if (set.contains(diaX + "," + diaY)) {
                        int area = Math.abs(x - diaX) * Math.abs(y - diaY);
                        ans = Math.min(area, ans);
                    }
                }
            }
        }
        
        // If ans was never updated, return 0 as no rectangle was found
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

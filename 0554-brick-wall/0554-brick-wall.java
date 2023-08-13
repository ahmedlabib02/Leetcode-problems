class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int width=0;
        for(Integer num:wall.get(0))
            width+=num;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans= 0;
        for(int i =0;i<wall.size();i++)
        {
            int sum=0;
            for(int j=0;j<wall.get(i).size()-1;j++)
            {
                sum+= wall.get(i).get(j);
                map.put(sum,map.getOrDefault(sum,0)+1);
                ans = Math.max(ans,map.get(sum));
            }
        }
        return wall.size()-ans;
    }
}
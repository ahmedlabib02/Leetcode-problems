class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num :arr)
        {
                map.put(num, map.getOrDefault(num,0)+1);
        }
        HashMap<Integer,ArrayList<Integer>> count = new HashMap<>();
        for(int num: map.keySet())
        {
            if(count.get(map.get(num))==null)
                count.put(map.get(num),new ArrayList<>());
            count.get(map.get(num)).add(num);
        }
        int ans = map.keySet().size();
        System.out.print(ans);
        for(int i=1;i<=k;i++)
        {
            for(int num: count.getOrDefault(i,new ArrayList<>()))
            {
                if(k<i)
                    break;
                ans--;
                k-=i;
            }
        }
         return ans;   
    }
}
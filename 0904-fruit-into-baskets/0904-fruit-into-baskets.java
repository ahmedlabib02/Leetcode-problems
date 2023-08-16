class Solution {
    public int totalFruit(int[] arr) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int i=0;
        int ans = 0;
        for(int j=0;j<arr.length;)
        {
            
            if(map.size()>2)
            {
                map.put(arr[i], map.get(arr[i])-1);
                if(map.get(arr[i])==0)
                    map.remove(arr[i]);
                i++;
            }
            else 
            {
                map.put(arr[j], map.getOrDefault(arr[j],0)+1);
                j++;
            }
            if(map.size()<=2)
                ans= Math.max(j-i,ans);
            
            // System.out.println(map+" "+ans);

        }
        return ans;
    }
}
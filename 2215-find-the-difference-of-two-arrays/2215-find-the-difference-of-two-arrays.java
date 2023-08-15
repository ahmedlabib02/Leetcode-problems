class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set1= new HashSet<>();
        HashSet<Integer> set2= new HashSet<>();
        for(int num:nums1)
            set1.add(num);
        for(int num:nums2)
            set2.add(num);
        List<Integer> x = new ArrayList<>();
        for(int num: set1)
            if(!set2.contains(num))
                x.add(num);
        ans.add(x);
        ArrayList<Integer> y = new ArrayList<>();
        for(int num:set2)
            if(!set1.contains(num))
                y.add(num);
        ans.add(y);
        return ans;
        
    }
}
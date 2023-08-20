class Solution {
    String s;
    String p;
    int[] arr;
    public int maximumRemovals(String s, String p, int[] removable) {
        this.s=s;
        this.p=p;
        arr= removable;
        int i =0; 
        int j = removable.length-1;
        while(i<=j)
        {
            
            int mid = i+(j-i)/2;
            // System.out.println(mid);
            if(check(mid))
                i=mid+1;
            else
                j=mid-1;
            
        }
        return i;
    }
    public boolean check(int last)
    {
        // System.out.println(last);
        HashSet<Integer> set = new HashSet<>();
        for(int i =0;i<=last;i++)
        {
            set.add(arr[i]);
        }
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            
            if (s.charAt(i) == p.charAt(j) && !set.contains(i) )
            {
                j++;
            }
            i++;
        }
        return j == p.length();
    }
}
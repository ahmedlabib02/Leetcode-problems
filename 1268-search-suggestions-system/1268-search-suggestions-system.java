class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        for(int p =0;p<searchWord.length();p++)
        {
            String temp = searchWord.substring(0,p+1);
            int i =0;
            int j = products.length-1;
            while(i<=j)
            {
            int mid = i+(j-i)/2;
            String s = products[mid].substring(0,Math.min(p+1,products[mid].length()));
            if(s.compareTo(temp)==0)
                j=mid-1;
            else if(s.compareTo(temp)>0)
                j=mid-1;
            else 
                i=mid+1;
            }  
            List<String> list = new ArrayList<>();
            // System.out.println(i+" "+);
            for(int x=i;x<i+3&& x<products.length;x++)
            {
                if(products[x].startsWith(temp))
                    list.add(products[x]);
            }
            ans.add(list);
        }
        return ans;
    }
}
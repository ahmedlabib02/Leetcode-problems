class Solution {
    public List<String> removeComments(String[] source) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        boolean ignore=false;
        
        for(int i=0;i<source.length;i++)
        {
            if(!ignore)
                sb = new StringBuilder();
            String line = source[i];
            for(int j=0;j<line.length();j++)
            {
                char c= line.charAt(j);
                if(ignore && c!='*' )
                    continue;
                if(c=='/' && j<line.length()-1&&line.charAt(j+1)=='/')
                    break;
                if(c=='/' && j<line.length()-1&& line.charAt(j+1)=='*')
                {
                    ignore=true;
                    j++;
                }
                
                else if(ignore &&c=='*' && line.charAt(j+1)=='/' )
                {
                    ignore=false;
                    j++;
                    
                }
                else if(!ignore)
                {
                    sb.append(c);
                }
            }
            if(sb.length()!=0 && !ignore)
                ans.add(sb.toString());
            
        }
        return ans;
    }
}
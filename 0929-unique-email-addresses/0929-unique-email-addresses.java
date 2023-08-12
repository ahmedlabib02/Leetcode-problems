class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set= new HashSet<>();
        for(String s : emails)
        {
            set.add(truncate(s));
        }
        System.out.print(set);
        return set.size();
    }
   public String truncate(String s)
   {
       String[] arr = s.split("@");
       String local = arr[0];
       String domain = arr[1];
       StringBuilder sb= new StringBuilder();
       for(char c : local.toCharArray())
       {
          if(c=='+')
              break;
           if(c!='.')
               sb.append(c);
       }
       return sb.toString()+ '@'+domain;
   }
}
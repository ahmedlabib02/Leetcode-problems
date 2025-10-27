class Solution {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        boolean isTight = true;
        int[] minSuffix = new int[s.length()];
        minSuffix[s.length()-1] = s.charAt(s.length()-1)-'0';
        for(int i=s.length()-2;i>=0;i--)
        {
            char c= s.charAt(i);
            int digit = c-'0';
            if(digit > minSuffix[i+1])
            {
                minSuffix[i] = digit-1;
            }
            else
            {
                minSuffix[i] = digit;
            }
        }
        // System.out.println(Arrays.toString(minSuffix));
        int num =0;
        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            int digit = c-'0';
            if(isTight && digit>minSuffix[i])
            {
                num*=10;
                num+= (minSuffix[i]);
                isTight =false;
            }
            else if(isTight)
            {
                num*=10;
                num+=digit;
            }
            else
            {
                num*=10;
                num+=9;
            }
        }
        return num;
    }
}
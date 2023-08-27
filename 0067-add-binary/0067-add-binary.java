class Solution {
    public String addBinary(String a, String b) {
        if(a.length()<b.length())
            return addBinary(b,a);
        StringBuilder sb  = new StringBuilder();
        int i= a.length()-1;
        int j = b.length()-1;
        int carry=0;
        while(j>=0|| i>=0)
        {
            if(j<0)
            {
                int ca = a.charAt(i)-'0';
                int res =ca^carry;
                sb.append(res);
                carry= ca&carry;
            }
            else
            {
            int ca = a.charAt(i)-'0';
            int cb = b.charAt(j)-'0';
            int res= ca^cb^carry;
            sb.append(res);
            carry = ca&cb | cb&carry | ca&carry;
            }
            i--;
            j--;
            
        }
        if(carry==1)
            sb.append(1);
        return sb.reverse().toString();
    }  
}
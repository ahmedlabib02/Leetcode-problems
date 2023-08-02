class Solution {
    public boolean checkValidString(String s) {
        int asterisk = 0;
        int count = 0;

        // Pass from left to right
        for (Character c : s.toCharArray()) {
            if (c == '*')
                asterisk++;
            else if (c == ')') {
                if (count == 0) {
                    if (asterisk == 0)
                        return false;
                    asterisk--;
                } else {
                    count--;
                }
            } else {
                count++;
            }
        }

        // Reset variables for the second pass
        count = 0;
        asterisk = 0;

        // Pass from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*')
                asterisk++;
            else if (c == '(') {
                if (count == 0) {
                    if (asterisk == 0)
                        return false;
                    asterisk--;
                } else {
                    count--;
                }
            } else {
                count++;
            }
        }

        return true;
    }
}

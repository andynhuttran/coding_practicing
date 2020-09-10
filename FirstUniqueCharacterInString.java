/*
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:
s = "leetcode"
return 0.

s = "loveleetcode"
return 2.

Note: You may assume the string contains only lowercase English letters.
*/

class Solution {
    public int firstUniqChar(String s) {
        return solution2(s);
    }
    
    public int solution2(String s) {
        
        int[] arr = new int[26];
        
        //dump char to index and count the letters
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        
        //find the letters which is 1 after encoder to index
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (arr[c - 'a'] == 1){
                return i;
            }
        }
        
        return -1;
    }
    
    
    public int solution1(String s) {
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            boolean found = false;
            
            for (int j = 0; j < s.length(); ++j) {
                if (j != i) {
                    if (c == s.charAt(j)) {
                        found = true;
                        break;
                    }
                }
            }
            
            if (!found) return i;
        }
        
        return -1;
    }
}


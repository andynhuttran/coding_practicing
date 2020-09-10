/*************
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

*************/

class Solution {
    public boolean isAnagram(String s, String t) {
        return solution1(s, t);
        
    }
    
    public boolean solution2(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] arrS = new int[26];
        int[] arrT = new int[26];
        
        for (int i = 0; i < s.length(); ++i){            
            arrS[s.charAt(i) - 'a']++;
            arrT[t.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < arrS.length; ++i){            
            if (arrS[i] != arrT[i]){
                return false;
            }
        }
     
        return true;
    }
    
    
    public boolean solution1(String s, String t) {
        if (s.length() != t.length()) return false;
        
        char[] cs1 = s.toCharArray();
        Arrays.sort(cs1);
        String newS = String.valueOf(cs1);
        
        char[] cs2 = t.toCharArray();
        Arrays.sort(cs2);
        String newT = String.valueOf(cs2);
        
        return newS.equals(newT);
        
    }
}


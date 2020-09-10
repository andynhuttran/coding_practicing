/**************

Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.


Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

*******************/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> result = new HashMap<>();
        
        for (String str : strs){
             
            //transform to char array, then order char array, then rebuild String to create key
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            
            if (result.containsKey(key)){  //add to same group              
                result.get(key).add(str);
            }
            else { //create a new group
                List<String> l = new ArrayList();
                l.add(str);                
                result.put(key, l);
            }            
        }
        
        return new ArrayList<>(result.values());
    }
}

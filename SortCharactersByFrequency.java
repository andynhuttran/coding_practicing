Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:
Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
------------------
Example 2:
Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
--------------------------
Example 3:
Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
-----------------------------

class Solution {
    
    public String frequencySort(String s) {
        
        
        return solution2(s);
        
    }
    
    public String solution2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        //convert string to map with key = character, value = number of character which appeared in String
        for (int i = 0; i < s.length(); ++i){            
            Character c = Character.valueOf(s.charAt(i));
            
            if (map.containsKey(c)){
                int value = map.get(c);
                map.replace(c, value+1);                    
            }
            else {
                map.put(c, 1);
            }            
        }
        
        //convert the map to String array, with index is the frequency of character
        StringBuilder[] arr = new StringBuilder[s.length() + 1];
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            Character c = entry.getKey();
            Integer frequency = entry.getValue();
            
            if (arr[frequency] == null){
                arr[frequency] = new StringBuilder(c.toString());
            }
            else {
                arr[frequency].append(c.toString());
            }            
        }
        
        //loop arr to from hight to low
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length-1; i >= 0; --i){            
            if (arr[i] == null) continue;            
            String value = arr[i].toString();
            
            for (int j = 0; j < value.length(); ++j){
                char c = value.charAt(j);                
                for (int k = 0; k < i; ++k){
                    builder.append(c);
                }

            }
        }
        
        return builder.toString();        
    }
    
    
    public String solution1(String s) {
        if(s.length()==0)return ""; 
      
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
      
        List<Character> count=new ArrayList<>(map.keySet());
        Collections.sort(count,(a, b) -> map.get(b) - map.get(a));
      
        StringBuilder sb=new StringBuilder();
        for(char c:count){
            int n=map.get(c);
            for(int i=0;i<n;i++){
                sb.append(c);
            }
        }
        return sb.toString();
        
    }
    
}
  
  


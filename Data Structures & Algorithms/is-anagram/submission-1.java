
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();
        int length_s = s.length();
        int length_t = t.length();
        
        if (length_s != length_t) { return false;}
        
        for (int i = 0; i < length_s; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (freq.containsKey(a)) {
                freq.put(a, freq.get(a)+1);
            } else {freq.put(a, 1);}
            
            if (freq2.containsKey(b)) {
                freq2.put(b, freq2.get(b)+1);
            } else {freq2.put(b, 1);}
            
        }

        for (Character c : freq.keySet()) {
            if (!(freq.get(c).equals(freq2.get(c)))) {return false;}
        }
        return true;
    }
}

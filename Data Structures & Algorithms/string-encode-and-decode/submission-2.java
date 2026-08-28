
class Solution {
   
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            int i = s.length();
            String preF = i+"#";
            StringBuilder temp = new StringBuilder();
            temp.append(preF);
            temp.append(s);
            sb.append(temp);
        }
        return sb.toString();

    }
    int i;    
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        while (i <str.length()) {
            if (Character.isDigit(str.charAt(i))) {
                String cur = helpDecode(str);
                res.add(cur);
            }

        }
        return res;
    }

    String helpDecode(String s) {
        int k = (s.charAt(i)) - '0';
        i++;
        while(Character.isDigit(s.charAt(i))) {
            k = 10*k + (s.charAt(i) - '0');
            i++;
        }
        // now i should be '#'
        if (s.charAt(i) == '#') {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (k>0) {
            sb.append(s.charAt(i));
            i++;
            k--;
        }
        return sb.toString();

    }
}


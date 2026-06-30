class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        if(pattern.length()!=sArray.length){
            return false;
        }
        HashMap<Character,String> wp = new HashMap<>();
        HashMap<String,Character> pw = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String word = sArray[i];
            if(wp.containsKey(ch)){
                if(!(wp.get(ch).equals(word))){
                    return false;
                }
            }
            if(pw.containsKey(word)){
               if(!(pw.get(word) == ch)) {
                return false;
               }
            }
            if(!wp.containsKey(ch) && !pw.containsKey(word)){
                wp.put(ch, word);
                pw.put(word, ch);
            }
        }
        return true;
    }
}
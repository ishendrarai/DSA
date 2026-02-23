class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(k>s.length()) return false;
        Set<String> st = new HashSet<>();
        int pow = (int)Math.pow(2,k);
        for(int i=0;i<=s.length()-k;i++){
            String sub = s.substring(i,i+k);
            if(!st.contains(sub)){
                st.add(sub);
                pow--;
            }
            if(pow==0){
                return true;
            }
        }

        return false;
    }
}
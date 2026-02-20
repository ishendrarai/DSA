class Solution {
    private String solve(String s){
        ArrayList<String> specials = new ArrayList<>();
        int start=0;
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum+=(s.charAt(i)=='1') ? 1: -1;
            if(sum==0){
                String inner = s.substring(start+1,i);
                specials.add("1"+solve(inner)+"0");
                start=i+1;
            }
        }
        Collections.sort(specials,Collections.reverseOrder());
        String ans ="";
        for(String str:specials){
            ans+=str;
        }
        return ans;
    }
    public String makeLargestSpecial(String s) {
        return solve(s);
    }
}
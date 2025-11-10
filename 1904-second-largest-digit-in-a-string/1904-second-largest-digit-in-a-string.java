class Solution {
    public int secondHighest(String s) {
    String nums = s.replaceAll("[^0-9]", "");
    int m1 = Integer.MIN_VALUE;
    int m2 = Integer.MIN_VALUE;
    for(int i=0;i<nums.length();i++){
        int c = nums.charAt(i)-'0';
       if(c>m1){
        m2=m1;
        m1=c;
       }
       if(c<m1 && c>m2){
        m2=c;
       }
    }
     return (m2 == Integer.MIN_VALUE) ? -1 : m2;
    }
}
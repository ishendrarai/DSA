class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans  = new ArrayList<>();
        for(int HH=0;HH<=11;HH++){
            for(int MM=0;MM<=59;MM++){
                if((Integer.bitCount(HH)+Integer.bitCount(MM))==turnedOn){
                    ans.add(HH+":"+(MM<10 ? "0":"") +MM);
                }
            }
        }
        return ans;
    }
}
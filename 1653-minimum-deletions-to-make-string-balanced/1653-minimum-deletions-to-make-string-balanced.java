class Solution {
    
    public int minimumDeletions(String s) {
        int N = s.length();
        int runCountR = 0, runCountL = 0;

        for(int i=N-1; i>=0; i--){
            runCountR += ('b' - s.charAt(i));
        }

        int minDeletions = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            runCountR -= ('b' - s.charAt(i));
            
            minDeletions = Math.min(minDeletions, runCountL + runCountR);

            runCountL += (s.charAt(i) - 'a');
        }

        return minDeletions; 
    }

}
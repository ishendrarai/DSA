class Solution {
    public List<Integer> getRow(int R) {
        long ans = 1;
        List<Integer> temp = new ArrayList<>();

        temp.add(1);

        for (int C = 1; C <= R; C++) {
            ans = ans * (R - C + 1);
            ans = ans / C;
            temp.add((int) ans);
        }

        return temp;
    }
}
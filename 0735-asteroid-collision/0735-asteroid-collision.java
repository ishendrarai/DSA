class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (alive && !stack.isEmpty() && stack.peekLast() > 0 && asteroid < 0) {
                if (stack.peekLast() < -asteroid) {
                    // Stack top explodes
                    stack.pollLast();
                } else if (stack.peekLast() == -asteroid) {
                    // Both explode
                    stack.pollLast();
                    alive = false;
                } else {
                    // Current asteroid explodes
                    alive = false;
                }
            }

            if (alive) {
                stack.offerLast(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        int i = 0;
        for (int asteroid : stack) {
            result[i++] = asteroid;
        }

        return result;
    }
}
class Solution {
    public int twoEggDrop(int n) {
        return (int) Math.ceil((Math.sqrt(1 + 8.0 * n) - 1) / 2);

    }
}
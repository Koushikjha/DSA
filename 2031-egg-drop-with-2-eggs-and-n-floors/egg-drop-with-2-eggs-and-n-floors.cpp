class Solution {
public:
    int twoEggDrop(int n) {
        return ceil((sqrt(1 + 8 * n) - 1) / 2.0);
    }
};
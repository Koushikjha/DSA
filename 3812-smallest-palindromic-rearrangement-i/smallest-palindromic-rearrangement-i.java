class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            left.append(String.valueOf((char) ('a' + i)).repeat(freq[i] / 2));

            if (freq[i] % 2 != 0) {
                middle = (char) ('a' + i);
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + (middle == 0 ? "" : middle) + right;
    }
}
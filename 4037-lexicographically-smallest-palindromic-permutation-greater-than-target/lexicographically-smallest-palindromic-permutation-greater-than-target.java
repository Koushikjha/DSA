class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int oddCount = 0;
        char middle = 0;

        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
                middle = (char) ('a' + i);
            }

            halfFreq[i] = freq[i] / 2;
        }

        if (oddCount > 1) {
            return "";
        }

        int halfLength = n / 2;
        String targetHalf = target.substring(0, halfLength);

        String half = smallestHalfAtLeast(halfFreq, targetHalf);

        if (half == null) {
            return "";
        }

        String candidate = buildPalindrome(half, middle, n % 2 == 1);

        if (candidate.compareTo(target) > 0) {
            return candidate;
        }

        char[] arr = half.toCharArray();

        if (!nextPermutation(arr)) {
            return "";
        }

        return buildPalindrome(new String(arr), middle, n % 2 == 1);
    }

    private String smallestHalfAtLeast(int[] freq, String target) {
        int n = target.length();
        int[] remaining = freq.clone();
        char[] result = new char[n];

        int pos = 0;

        while (pos < n) {
            int targetChar = target.charAt(pos) - 'a';

            if (remaining[targetChar] > 0) {
                result[pos] = target.charAt(pos);
                remaining[targetChar]--;
                pos++;
            } else {
                break;
            }
        }

        if (pos == n) {
            return new String(result);
        }

        for (int i = pos; i >= 0; i--) {
            if (i < pos) {
                remaining[result[i] - 'a']++;
            }

            int start = target.charAt(i) - 'a' + 1;

            for (int c = start; c < 26; c++) {
                if (remaining[c] > 0) {
                    result[i] = (char) ('a' + c);
                    remaining[c]--;

                    int index = i + 1;

                    for (int j = 0; j < 26; j++) {
                        while (remaining[j] > 0) {
                            result[index++] = (char) ('a' + j);
                            remaining[j]--;
                        }
                    }

                    return new String(result);
                }
            }
        }

        return null;
    }

    private String buildPalindrome(String half, char middle, boolean hasMiddle) {
        StringBuilder result = new StringBuilder(half);

        if (hasMiddle) {
            result.append(middle);
        }

        result.append(new StringBuilder(half).reverse());

        return result.toString();
    }

    private boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = arr.length - 1;

        while (arr[j] <= arr[i]) {
            j--;
        }

        swap(arr, i, j);
        reverse(arr, i + 1, arr.length - 1);

        return true;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left++, right--);
        }
    }
}
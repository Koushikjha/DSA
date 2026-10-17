
import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int x = nums[i];

            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }

            arr[i][0] = nums[i];
            arr[i][1] = sum;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        Map<Integer, Integer> targetIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            targetIndex.put(arr[i][0], i);
        }

        int[] original = nums.clone();
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            while (targetIndex.get(original[i]) != i) {
                int j = targetIndex.get(original[i]);

                int temp = original[i];
                original[i] = original[j];
                original[j] = temp;

                swaps++;
            }
        }

        return swaps;
    }
}

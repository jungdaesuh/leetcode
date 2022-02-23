package Array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_01 {
    static int[] bruteForce(int[] num, int target) {
        int[] result = new int[2];
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if ((num[i] + num[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }


        }
        return result;

    }

    static int[] hashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { i, map.get(complement) };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        int[] b = new int[]{3, 2, 4};
        int[] c = new int[]{3, 3};

        int target = 9;
        int [] f = bruteForce(a, target);
        System.out.println(f[0]);
        System.out.println(f[1]);


    }
}

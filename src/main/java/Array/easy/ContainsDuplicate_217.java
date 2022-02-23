package Array;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate_217 {
//    static boolean bruteForce (int[] nums) {
//        for (int i = 0; i < nums.length; i++){
//            for (int j = i + 1; j < nums.length; j++){
//                if (nums[i] == nums[j]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    static boolean sorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    static boolean hashSet(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (numbers.contains(nums[i])) {
                return true;
            }
            numbers.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
//        System.out.println(containsDuplications(nums));
        System.out.println(sorting(nums));
    }

}

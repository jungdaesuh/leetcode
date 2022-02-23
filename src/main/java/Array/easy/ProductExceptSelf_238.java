package Array;

public class ProductExceptSelf_238 {
    static int[] leftAndRightProductLists(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] output = new int[length];

        left[0] = 1;
        right[length - 1] = 1;

        // [1, 2, 3, 4]

        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        //  0 1 2 3
        // [1, 1, 2, 6]

        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            output[i] = right[i] * left[i];
        }

        return output;
    }


}

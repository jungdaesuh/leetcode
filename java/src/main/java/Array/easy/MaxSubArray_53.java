package Array.easy;

public class MaxSubArray_53 {
    static int On3 (int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {
                int currentSubArray = 0;
                for (int k = i; k < j + 1; k++) {
                    currentSubArray += nums[k];
                }

                if (max < currentSubArray)
                    max = currentSubArray;
            }

        }
        return max;
    }

    static int On2 (int[] nums) {
        int max = Integer.MIN_VALUE;


        for (int i = 0; i < nums.length; i++) {
            int currentSubArray = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubArray += nums[j];

                if (max < currentSubArray)
                    max = currentSubArray;

            }

        }
        return max;
    }

    static int kadane(int[] nums) {
        int maxSubArray = nums[0];
        int currSubArray = nums[0];


        for (int i = 1; i < nums.length; i++) {
//            currSubArray = nums[i] > nums[i] + currSubArray ? nums[i] : nums[i] + currSubArray;
//
//            maxSubArray = maxSubArray > currSubArray ? maxSubArray : currSubArray;

            currSubArray = Math.max(nums[i], currSubArray + nums[i]);
            maxSubArray = Math.max(currSubArray, maxSubArray);
        }

        return maxSubArray;
    }

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(kadane(nums));
    }

}

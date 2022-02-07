package Array;

public class maxProduct_152 {
     static int On3 (int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int currProduct = nums[i];
                for (int k = i + 1; k < j + 1; k++) {
                    currProduct = currProduct * nums[k];
                }
                if (maxProduct < currProduct)
                    maxProduct = currProduct;
            }
        }
        return maxProduct;
    }

    static int On2(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currProduct = 1; // 곱셉이니 '1'로 시작.
            for (int j = i; j < nums.length; j++) {
                currProduct *= nums[j];
                // current product 저장.
                // 그리고 바로 max product랑 비교.
                maxProduct = Math.max(maxProduct, currProduct); // 내장함수가 if문 보다 더 빠름.
                // if (maxProduct < currProduct)
                //     maxProduct = currProduct;
            }
        }
        return maxProduct;
    }

    static int dP(int[] nums) {
        if (nums.length == 0) return 0;

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = maxProduct;

        for (int i = 1; i < nums.length; i++) {
            int currProduct = nums[i];
            int tmpMax = maxProduct; // 다음 maxProduct가 계산 되기 전 값을 minProduct에 사용하기 위해 값 hold.
            maxProduct = Math.max(currProduct, Math.max(currProduct * maxProduct, currProduct * minProduct));
            minProduct = Math.min(currProduct, Math.min(currProduct * tmpMax, currProduct * minProduct));



            result = Math.max(maxProduct, result);
        }
        return result;
    }

    // 유저네임 'zuozuo' 답. 99% 빠르기.
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, product = 1;
        int len = nums.length;

        for(int i = 0; i < len; i++) {
            max = Math.max(product *= nums[i], max);
            if (nums[i] == 0) product = 1;
        }

        product = 1;

        for(int i = len - 1; i >= 0; i--) {
            max = Math.max(product *= nums[i], max);
            if (nums[i] == 0) product = 1;
        }

        return max;
    }

}

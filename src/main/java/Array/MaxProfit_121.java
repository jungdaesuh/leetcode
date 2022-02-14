package Array;

public class MaxProfit_121 {

    static int buySellStock (int[] prices){
        int output = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    if (prices[j] - prices[i] > output) {
                        output = prices[j] - prices[i];
                    }
                }
            }
        }

        return output;
    }

    static int twoPointers (int[] prices){
        int l = 0;
        int r = 1;
        int output = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[l] < prices[r]) {
                output = Math.max(output, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;

            }

        return output;
    }

    static int whileLoop (int[] prices) {
        int l = 0;
        int r = 1;
        int output = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                output = Math.max(output, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return output;
    }

    static int kevinNaughton(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = prices[i] - min;
            }
        }
        return max;
    }

    static int mySolution(int[] prices) {
        int min = Integer.MAX_VALUE;
        int output = 0;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                continue;
            }
            output = prices[i] - min;
            result = Math.max(result, output);
        }
        return result;
    }

    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

//        System.out.println(buySellStock(prices1));
//        System.out.println(buySellStock(prices2));

//        System.out.println(twoPointers(prices1));
//        System.out.println(twoPointers(prices2));

        System.out.println(whileLoop(prices1));
        System.out.println(whileLoop(prices2));
        System.out.println(kevinNaughton(prices1));
        System.out.println(kevinNaughton(prices2));

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);

        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");
    }
}

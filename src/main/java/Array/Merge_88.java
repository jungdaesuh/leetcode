package Array;

import java.util.Arrays;

public class Merge_88 {

    public void inBuiltFunction(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    public void ONplusM(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];

        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        int p1 = 0;
        int p2 = 0;
        int pW = 0;

        while (pW < nums1.length) {
            if (p2 >= n || p1 < m && nums1Copy[p1] < nums2[p2]) {
                nums1[pW] = nums1Copy[p1];
                p1++;
            } else {
                nums1[pW] = nums2[p2];
                p2++;
            }
            pW++;
        }
    }

    public void spaceConstant(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int pW = m + n - 1;

        while (pW >= 0) {
            if (p2 < 0 || p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[pW--] = nums1[p1--];
            } else {
                nums1[pW--] = nums2[p2--];
            }
        }


    }

    public void spaceSecondVersion(int[] nums1, int m, int[] nums2, int n) {
//        제약
//        nums1.length == m + n
//        nums2.length == n
//        0 <= m, n <= 200
//        1 <= m + n <= 200, 이 말은 m과 n 중 둘 다 빈 배열일 수 없다는 말임.
//        -109 <= nums1[i], nums2[j] <= 109

        int p1 = m - 1;
        int p2 = n - 1;

        for (int p = m + n - 1; p >= 0; p--) {

            // m과 n 중 1개는 꼭 값을 지내고 있어야 하므로, p1 < 0 이면 p2 > 0이고, p2 < 0이면, p1 > 0임.
            // 그래서 아래 조건을 걸어 둠.
            if (p1 < 0 || p2 >= 0 && nums2[p2] > nums1[p1]) {
                // p1 < 0, p2 > 0
                nums1[p] = nums2[p2--];
            } else {

                // p1 > 0, p2 < 0
                nums1[p] = nums1[p1--];
            }
        }
    }
}

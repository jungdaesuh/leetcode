package Array;

import java.util.Arrays;

public class merge_88 {

    public void inBuiltFunction(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    public void ONplusM(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];

        for (int i = 0; i < m; i++) {
            nums1Copy [i] = nums1[i];
        }

        int p1 = 0;
        int p2 = 0;
        int pW = 0;

        while (pW < nums1.length) {
            if ( p2 >= n ||p1 < m && nums1Copy[p1] < nums2[p2]){
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
            if ( p2 < 0 || p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[pW--] = nums1[p1--];
            } else {
                nums1[pW--] = nums2[p2--];
            }
        }
    }
}

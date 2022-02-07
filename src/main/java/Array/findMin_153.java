package Array;

public class findMin_153 {
    public int findMin(int[] nums) {
        // 배열 길이가 1개 일 때
        if (nums.length == 1) {
            return nums[0];
        }

        // Left, Right 포인터 초기화
        int left = 0, right = nums.length - 1;

        // 원래 배열 일 때는, 오름차 순이라 A[0] 이 가작 작은 수.
        // e.g. 1 < 2 < 3 < 4 < 5 < 7.
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        // 이진 검색. Rotation이 일어났을 경우
        while (right >= left) {
            // 중간 값 찾기
            int mid = left + (right - left) / 2;

            // e.g. [4, 5, 6, 7, 0, 1, 2]
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // e.g. [5, 6, 7, 0, 1, 2, 4]
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // mid 값이 [0]보다 클 경우, inflection point는 mid보다 오른쪽에 있음.
            // left pointer 이동
            // e.g. [1, 2, 4, 5, 6, 7, 0]
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                // mid가 num[0]보다 작을 경우, inflection point는 mid보다 왼쪽에 있음.
                // right pointer를 mid - 1으로 이동.
                // e.g. [6, 7, 0, 1, 2, 4, 5]
                right = mid - 1;
            }
            // 다시 반복.
        }
        return -1;
    }
}

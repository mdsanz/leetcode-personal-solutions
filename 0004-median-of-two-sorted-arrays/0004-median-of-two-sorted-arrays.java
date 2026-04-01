class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int i = 0, j = 0, index = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                mergedArray[index++] = nums1[i++];
            } else {
                mergedArray[index++] = nums2[j++];
            }
        }

        if (i < nums1.length) {
            for (int k = i; k < nums1.length; k++) {
                mergedArray[index++] = nums1[k];
            }
        } else if (j < nums2.length) {
            for (int k = j; k < nums2.length; k++) {
                mergedArray[index++] = nums2[k];
            }
        }

        int length = mergedArray.length;

        if (length % 2 == 0) {
            double median = (double) (mergedArray[(length / 2) - 1] + mergedArray[length / 2]) / 2;
            return median;
        } else {
            return mergedArray[length / 2];
        }
    }
}
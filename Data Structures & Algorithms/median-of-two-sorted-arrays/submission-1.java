class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0; int j = 0; int k = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                merged[k] = nums1[i];
                i++;
                k++;
            } else {
                merged[k] = nums2[j];
                j++;
                k++;
            }
        }

        while(i < nums1.length) {
            merged[k] = nums1[i];
            i++;
            k++;
        }

        while(j < nums2.length) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        int total = merged.length;
        if(total % 2 == 1) {
            return (double) merged[total/2];
        } else {
            // even case
            return (double) ((merged[(total/2) - 1]) + merged[total/2]) / 2;
        }
    }
}

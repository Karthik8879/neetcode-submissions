class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        minArray = float("inf")
        while low <= high:
            mid = low + (high - low) // 2
            minArray = min(minArray, nums[mid])
            if low < high and nums[low] > nums[high]:
                if nums[high] < nums[mid]:
                    low = mid+1
                else:
                    high = mid-1
            else:
                if nums[low] < nums[mid]:
                    high = mid-1
                else:
                    low = mid+1
        return minArray
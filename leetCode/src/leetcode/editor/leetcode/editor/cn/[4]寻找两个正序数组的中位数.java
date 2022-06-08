//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 5090 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         *分别求出两数组的长度
         */
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        /**
         * 假设两个数组合并为一个数组
         *
         * 两个数组合并后中位数的位置：
         * 如果合并后数组个数是奇数，那么(length1 + length2) / 2就是中位数
         * 如果合并后数组个数是偶数，那么第leftNum=(length1 + length2 + 1) / 2、(length1 + length2 + 2) / 2的平均值就是中位数
         *
         * 注意：leftNum - 1和rightNum - 1是合并后数组中与中位数相关值的对应下标
         */
        int leftNum = (length1 + length2 + 1) / 2;
        int rightNum = (length1 + length2 + 2) / 2;
        /**
         * 每次循环要抛弃中位数前面的一部分值，抛弃中位数前面的所有数就找到了中位数
         * 用aStart和bStart表示数组的起始坐标，前面的数为抛弃的数
         */
        int aStart = 0;
        int bStart = 0;

        /**
         *如果合并后数组是奇数个，只要找到下标为 length / 2 位置的元素
         *如果合并后数组是偶数个，要找到下标为 length / 2 - 1, length / 2 位置的元素
         *所以循环下标区间为[0,length /2]
         *如果数组是偶数个元素，那么需要两个变量保存，故设置两个变量 previous,current
         */
        int previous = 0;
        int current = 0;
        for (int i = 0; i <= length / 2; i++) {
            previous = current;
            /*
            抛弃中位数前面的元素:
            1.nums1数组还没有全部抛弃:aStart < length1
            2.nums1[aStart] < nums2[bStart]
            3.nums2数组已全部抛弃

            注意：
            (bStart >= length2 || nums1[aStart] < nums2[bStart])必须把索引判断放前面不然会数组索引越界，示例[0,0],[0,0],
            且括号必须要，不然也会索引越界，示例[1,2],[3,4]
             */
            if (aStart < length1 && (bStart >= length2 || nums1[aStart] < nums2[bStart])) {
                //nums1抛弃一个元素
                current = nums1[aStart++];
            } else {
                //nums2抛弃一个元素
                current = nums2[bStart++];
            }
        }

        /*
        二进制与运算：
        如果length为奇数，则 length & 1 = 1
        如果length为偶数，则 length & 1 = 0
         */
        if ((length & 1) == 0) {
            return (previous + current) / 2.0;
        } else {
            return current;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

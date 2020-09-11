package iotest01;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 处理流
 */
public class iotest01 {
    public static void main(String[] args) {
//        int[] x = {1,1,2,3,3,4,5,5};
//        removeDuplicates(x);

//        int[] x2 = {2,5,5,11};
//        twoSum(x2,10);

//        int[] nums1 ={1,3,4,5,6,7,8} ,nums2 = {2} ;
//        findMedianSortedArrays(nums1,nums2);

        String s = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel";
        longestPalindrome(s);
    }

//  删除数组中的重合元素
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 1 ; i < nums.length-1 ; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }

    //定位数组中两和为指定数字的元素位置
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) return null;
        int[] index = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i == j) continue;
                if ((nums[i]+nums[j]) == target){
                    index[0] = i;
                    index[1] = j;
                    System.out.println(index[0]+"  "+index[1]);
                    return index;
                }
            }
        }
        System.out.println(index[0]+"  "+index[1]);
        return index;
    }

    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     *
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/tencent/xx6c46/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double num = 0;
        int[] nums = new int[nums1.length+nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        for (int i = 0,j=nums1.length; i < nums2.length; i++,j++) {
            nums[j] = nums2[i];
        }

        for (int t:nums) {
            System.out.print(t);
        }
        System.out.println();

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int t = 0;
                if (nums[i]>nums[j]){
                    t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        if (nums.length%2 == 0){
            num = ((double)(nums[nums.length/2]+nums[nums.length/2-1]))/2;
        }else {
            num = nums[nums.length/2];
        }

        for (int t:nums) {
            System.out.print(t);
        }
        System.out.println();
        System.out.println(num);
        return num;
    }


    public static String longestPalindrome(String s) {
        if (s.equals("")||(s==null)) return s;
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();



        return stringBuilder.toString();
    }

    public static boolean test(char[] temps, int start, int end) {
        int max = end - start;
        if (max%2==0){
          while (start<end){
              if (temps[start]==temps[end]){
                  start++;
                  end--;
              }else {
                  return false;
              }
          }
        }else {
            while ((start!=end)&&(start<end)){
                if (temps[start]==temps[end]){
                    start++;
                    end--;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}

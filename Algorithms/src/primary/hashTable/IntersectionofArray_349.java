package primary.hashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ausdin
 * @version 1.0
 */
public class IntersectionofArray_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>(); // result直接用set就好
        for (int i :
                nums1) {
            set.add(i);
        }
        for (int i :
                nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }
        int[] res = list.stream().mapToInt(i->i).toArray();
        return res;
    }

    public int[] intersectionStandard(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }

        //方法1：将结果集合转为数组

        return resSet.stream().mapToInt(x -> x).toArray(); //比较关键

        //方法2：另外申请一个数组存放setRes中的元素,最后返回数组
//        int[] arr = new int[resSet.size()];
//        int j = 0;
//        for(int i : resSet){
//            arr[j++] = i;
//        }
//
//        return arr;
    }
}

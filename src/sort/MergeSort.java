package sort;

/**
 * 归并排序
 * 递归方法：先使两边变得有序，再合并
 * @author fcd
 * @date 2020/7/10 10:29
 * @version 1.0
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4,67,23,1,90,52,34,6,4,23,55,78,72};
        mergeSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 使一定范围内数列有序
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        //拆分数组，分别进行排序
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid + 1, right);
    }

    /**
     * 合并两个排序好的数组
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int index = 0;
        int p1 = left;
        int p2 = mid;

        while(p1 < mid && p2 <= right) {
            //当两个指针均未到达尾部时，选择当前更小的值写入辅助数组
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 < mid) {
            //当一个指针已到对位，将另一数组剩余数字一次加入辅助数组
            help[index++] = arr[p1++];
        }

        while(p2 <= right) {
            //当一个指针已到对位，将另一数组剩余数字一次加入辅助数组
            help[index++] = arr[p2++];
        }

        for(int i = 0; i < help.length; i++) {
            //遍历更新数组为排序后的结果
            arr[left + i] = help[i];
        }
    }

}

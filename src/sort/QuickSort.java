package sort;

/**
 * @author fcd
 * @date 2020/7/14 15:21
 * @version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4,67,23,1,90,52,34,6,4,23,55,78,72};
        quickSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int l = left;
            int r = right;
            int key = arr[left];
            while (left < right) {
                //从右往左，找到第一个比key小的值
                while (left < right && arr[right] >= key) {
                    right--;
                }
                //将较小值替换arr[left]
                arr[left] = arr[right];
                //从左往右，找到第一个比key大的值
                while (left < right && arr[left] <= key) {
                    left++;
                }
                //用较大值替换arr[right]
                arr[right] = arr[left];
            }
            arr[left] = key;
            //此时，left左边都比key小，right右边都比key大
            quickSort(arr, l, left - 1);
            quickSort(arr, left + 1, r);
        }
    }
}

public class SelectionSort {
/*
sort(array, start, end):
    for each swapIndex from end - 1 to start
        greatestElementIndex = start
        for each i from start + 1 to swapIndex
            if array[i] > array[greatestElementIndex]
                greatestElementIndex = i
        swap array, greatestElementIndex, swapIndex
*/

    // select largest, like the pseudocode
    public static void sort1(int[] array) {
        for (int swapIndex = array.length - 1; swapIndex >= 0; swapIndex--) {
            int greatest = 0;
            for (int i = 1; i <= swapIndex; i++) {
                if (array[i] > array[greatest]) {
                    greatest = i;
                }
            }
            
            swap(array, greatest, swapIndex);
        }
    }

    // select smallest, track swaps/comps
    public static void sort2(int[] array) {
        int swaps = 0;
        int comparisons = 0;

        for (int swapIndex = 0; swapIndex < array.length; swapIndex++) {
            int smallest = swapIndex;
            for (int i = swapIndex + 1; i < array.length; i++) {
                comparisons += 1;
                if (array[i] < array[smallest]) {
                    smallest = i;
                }
            }
            
            swaps += 1;
            swap(array, smallest, swapIndex);
            // int temp = array[smallest];
            // array[smallest] = array[swapIndex];
            // array[swapIndex] = temp;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

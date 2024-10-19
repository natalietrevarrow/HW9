public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] arr = {3, 6, 5, 9, 11};
        int[] sortedArr = MergeSort(arr, 0, arr.length - 1);
        display(sortedArr);
    }

    public static void Merge(int[] arr, int i, int j, int k) {
        int mergeSize = k - i + 1;
        int[] array = new int[mergeSize];

        int mergePos = 0;
        int leftPos = i;
        int rightPos = j+ 1;

        while (leftPos <= j && rightPos <= k) {
            if (arr[leftPos] <= arr[rightPos]) {
               array[mergePos] = arr[leftPos];
               leftPos++;
            }
            else {
               array[mergePos] = arr[rightPos];
               rightPos++;
            }
            mergePos++;
        }

        while (leftPos <= j) {
            array[mergePos] = arr[leftPos];
            leftPos++;
            mergePos++;
         }
      
         // If right partition is not empty, add remaining elements to merged numbers
         while (rightPos <= k) {
            array[mergePos] = arr[rightPos];
            rightPos++;
            mergePos++;
         }
      
         // Copy merged numbers back to numbers
         for (mergePos = 0; mergePos < mergeSize; mergePos++) {
            arr[i + mergePos] = array[mergePos];
        }
    }

    public static int[] MergeSort(int[] arr, int i, int k) {
        int j = 0;
        
        if (i < k) {
           j = (i + k) / 2;  // Find the midpoint in the partition
  
           // Recursively sort left and right partitions
           MergeSort(arr, i, j);
           MergeSort(arr, j + 1, k);
              
           // Merge left and right partition in sorted order
           Merge(arr, i, j, k);
          
        }
        return arr;
    }

    public static void display(int[] arr) {
        for(int i = 0; i < arr.length; i++)  {
            System.out.println(arr[i]);
        }
    }
}


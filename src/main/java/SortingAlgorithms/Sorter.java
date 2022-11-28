package SortingAlgorithms;


public class Sorter {
    public static void bubbleSort(int[] arr){
        boolean isSorted;
        for(int i=0; i<arr.length;i++){
            isSorted = true;
            for (int j=1; j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    swapper(arr,j-1,j);
                    isSorted = false;
                }
            }
            if(isSorted)return;
        }
    }
    private static void swapper(int[]arr,int index1,int index2){
        int temp = index2;
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

    public static void mergeSort(int[] arr){
        if(arr.length <2) return;
        //divide into two arrays
        int middle = arr.length/2;
        //copy arrys
        int[] left = new int[middle];
        for(int i=0;i<middle;i++){
            left[i] = arr[i];
        }
        int[] right = new int[arr.length-middle];
        for(int i=middle;i<arr.length;i++){
            right[i-middle] = arr[i];
        }
        //sort
        mergeSort(left);
        mergeSort(right);
        //merge
        mergeArrays(left,right,arr);
    }
    private static void mergeArrays(int[] left,int[] right,int[] result){
        int i=0,j=0,k=0;

        while(i<left.length && j<right.length){
            if(left[i] <= right[j]){
                result[k] = left[i];
                k++;
                i++;
            }else {
                result[k] = right[j];
                k++;
                j++;
            }
        }

        while (i<left.length){
            result[k] = left[i];
            k++;
            i++;
        }

        while (j<right.length){
            result[k] = right[j];
            k++;
            j++;
        }
    }

    public static void quickSort(int[] arr){
        //Partition
        //sort left
        //sort right
    }
//    private static int partition(int[]arr){
//        //assume that the pivot is the last element in this array
//    }
}

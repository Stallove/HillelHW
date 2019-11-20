package HW14;

public class Algorithm {

    public static void insertSort(int arrr[]) {
        int temp;
        int j;

        for(int i = 0; i < arrr.length; i++) {
            temp = arrr[i];
            for (j = i;  j > 0 && arrr[j - 1] >= temp ; j--) {
                arrr[j] = arrr[j - 1];
            }
            arrr[j] = temp;
        }
    }

    public static int interpolationSearch(int arrr[], int key) {
        int left = 0;
        int right = arrr.length - 1;
        int mid;

        while(arrr[left] < key && key < arrr[right]) {
            mid = left + (key - arrr[left]) * (right - left) / (arrr[right] - arrr[left]);
            if(arrr[mid] < key) {
                left = mid + 1;
            } else if(arrr[mid] > key) {
                right = mid - 1;
            } else {
                break;
            }
        }

        if (arrr[left] == key) {
            return  left;
        } else if(arrr[right] == key) {
            return  right;
        } else {
            return  -1;
        }
    }
}

package algorithms.sorting;

public class SortingAlgo {

    private void swap(int[] a,int i,int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private int randomNumber(int low, int high) {
        return low + (int)(Math.random()*(high-low));
    }

    public SortingAlgo(){}

    public void quickSort(int[] a,int l, int r) {
        if (l >= r) {
            return;
        }
        int partitionIdx = partition(a,l,r);
        quickSort(a,l,partitionIdx-1);
        quickSort(a,partitionIdx+1,r);
    }

    private int partition(int[] a,int l, int r) {
        int randomIdx = randomNumber(l,r);
        swap(a,randomIdx,r);
        int partitionIdx = l;
        for (int i = l ; i < r ; i++) {
            if (a[i] < a[r]) {
                swap(a,partitionIdx,i);
                partitionIdx++;
            }
        }
        swap(a,partitionIdx,r);
        return partitionIdx;
    }

    public void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i;
            while (j > 0 && a[j-1] > key) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = key;
        }
    }

    public void mergeSort(int[] a, int left,int right) {
        if (left < right) {
            int mid = left+(right-left)/2;
            mergeSort(a,left,mid);
            mergeSort(a,mid+1,right);
            merge(a,left,mid,right);
        }
    }

    private void merge(int[] a, int left, int mid, int right) {
        int n = mid-left+1;
        int m = right-mid;
        int[] lSorted = new int[n];
        int[] rSorted = new int[m];

        System.arraycopy(a, left, lSorted, 0, n);
        System.arraycopy(a,mid+1,rSorted,0,m);

        int i,j,k;

        i = 0;
        j = 0;
        k = left;

        while (i < lSorted.length && j < rSorted.length) {
            if (lSorted[i] < rSorted[j]) {
                a[k] = lSorted[i];
                i++;
            } else {
                a[k] = rSorted[j];
                j++;
            }
            k++;
        }

        while (i < lSorted.length) {
            a[k] = lSorted[i];
            i++;
            k++;
        }

        while (j < rSorted.length) {
            a[k] = rSorted[j];
            j++;
            k++;
        }
    }

    public void bubbleSort(int[] a) {
        boolean sorted = true;
        for (int i = 0 ; i < a.length;i++) {
            sorted = true;
            for (int j = 0 ; j < a.length-1;j++) {
                if (a[j] > a[j+1]) {
                    sorted = false;
                    swap(a,j,j+1);
                }
            }
            if (sorted) {
                return;
            }
        }
    }
}

package algorithms.searching;

public class SearchAlgo {

    public SearchAlgo(){}

    public boolean binarySearch(int[] a, int target) {
        if (a.length == 0) {
                return false;
        }
        int l,m,r;
        l = 0; r = a.length-1;
        while (l <= r) {
            m = l+(r-l)/2;
            if (a[m] == target) {
                return true;
            } else if (a[m] > target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return false;
    }

    public int nextNumber(int[] a,int v) {
        int l,m,r;
        l = 0; r = a.length-1;
        while (l < r) {
            m = l+(r-l)/2;
            if (a[m] > v) {
                r = m;
            } else {
                l = m+1;
            }
        }
        return a[l];
    }

    public int prevNumber(int[] a, int v) {
        int l,m,r;
        l = 0; r = a.length-1;
        while (l < r) {
            m = l+(r-l)/2 + 1;
            if (a[m] >= v) {
                r = m-1;
            } else {
                l = m;
            }
        }
        return a[l];
    }

    public int[] bounds(int[] a, int v) {
        int l,m,r,leftBound,rightBound;

        l = 0; r = a.length-1;
        while (l < r) {
            m = l+(r-l)/2 + 1;
            if (a[m] >= v) {
                r = m-1;
            } else {
                l = m;
            }
        }
        leftBound = l;

        l = 0; r = a.length-1;
        while (l < r) {
            m = l+(r-l)/2;
            if (a[m] > v) {
                r = m;
            } else {
                l = m+1;
            }
        }
        rightBound = l;

        return new int[]{leftBound+1,rightBound-1};
    }
}

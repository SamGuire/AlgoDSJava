package datastructures.heap;

import java.util.Arrays;

public class MinHeap {

    private int[] heap;
    private final int MAXSIZE;

    private int currentSize;



    public MinHeap(int size) {
        this.MAXSIZE = size;
        this.heap = new int[this.MAXSIZE];
        this.currentSize = 0;
    }

    public int peek() {
        if (this.currentSize == 0) {
            return -1;
        }
        return this.heap[0];
    }

    public void insert(int v) {
        if (this.currentSize != this.MAXSIZE) {
            this.heap[this.currentSize] = v;
            this.bubbleUp(this.currentSize);
            this.currentSize++;
        }
    }

    public int poll() {
        if (this.currentSize == 0) {
            return -1;
        } else {
            int minVal = this.heap[0];
            this.heap[0] = this.heap[currentSize-1];
            this.heap[currentSize-1] = 0;
            this.currentSize--;
            this.bubbleDown(0);
            return minVal;
        }
    }
    private void bubbleUp(int startIdx) {
        int parentIdx = this.parent(startIdx);
        if (startIdx != 0) {
            if (this.heap[parentIdx] > this.heap[startIdx]) {
                int tmp = this.heap[parentIdx];
                this.heap[parentIdx] = this.heap[startIdx];
                this.heap[startIdx] = tmp;
                this.bubbleUp(parentIdx);
            }
        }
    }

    private void bubbleDown(int startIdx) {
        int leftIdx = this.leftChild(startIdx);
        int rightIdx = this.rightChild(startIdx);
        int minIdx = startIdx;
        if (leftIdx < this.currentSize && this.heap[minIdx] > this.heap[leftIdx]) {
            minIdx = leftIdx;
        }
        if (rightIdx < this.currentSize && this.heap[minIdx] > this.heap[rightIdx]) {
            minIdx = rightIdx;
        }
        if (minIdx != startIdx) {
            int tmp = this.heap[startIdx];
            this.heap[startIdx] = this.heap[minIdx];
            this.heap[minIdx] = tmp;
            bubbleDown(minIdx);
        }
    }

    private int leftChild(int idx) {
        return idx*2+1;
    }
    private int rightChild(int idx) {
        return idx*2+2;
    }

    private int parent(int idx) {
        return (idx-1)/2;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.heap);
    }


}

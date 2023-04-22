package datastructures.heap;

public class Client {

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);
        heap.insert(8);
        heap.insert(1);
        heap.insert(4);
        heap.insert(15);
        System.out.println(heap);
        heap.poll();
        System.out.println(heap);
    }
}

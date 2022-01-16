package study.java.datastructure.algo.leetcode.leetcode50;

// 295
// Hard

import java.util.*;

public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.minHeap);
        System.out.println(finder.maxHeap);
        System.out.println(finder.findMedian());
        System.out.println();
        finder.addNum(3);
        System.out.println(finder.minHeap);
        System.out.println(finder.maxHeap);
        System.out.println(finder.findMedian());
        System.out.println();
    }

}

class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.add(num);
        checkSize(minHeap, maxHeap);
        checkNumbers(minHeap, maxHeap);
    }

    public void checkSize(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.size() == minHeap.size() + 1 || maxHeap.size() == minHeap.size()) {
            return;
        }

        minHeap.add(maxHeap.remove());
        checkNumbers(minHeap, maxHeap);
        return;
    }

    public void checkNumbers(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.isEmpty() || minHeap.isEmpty() || maxHeap.peek() <= minHeap.peek()) {
            return;
        }

        maxHeap.add(minHeap.remove());
        checkSize(minHeap, maxHeap);
        return;
    }

    public double findMedian() {
        boolean isEven = (minHeap.size() + maxHeap.size()) % 2 == 0;
        if (isEven) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            if (minHeap.size() > maxHeap.size()) return minHeap.peek();
            else return maxHeap.peek();
        }
    }

}
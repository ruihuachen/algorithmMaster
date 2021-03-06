package com.algorithm.剑指offer.滑动窗口的最大值;

import java.util.*;

/**
 * create by Ernest on 2020/3/1.
 */
public class MaxSlidingWindow {

    /**
     * heap: 维护O(logK) 查找O(1) -> 时间复杂度O(nlogK)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0 || nums == null) {
            return new int[]{};
        }

        //最小堆,元素按照自然排序,数字从小到大
        Queue<Integer> minHeap = new PriorityQueue<>();

        //最大堆 == 大顶堆
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        //存储返回结果
        int[] res = new int[nums.length - k + 1];

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.size() == k || i == nums.length - 1) {
                res[index++] = maxHeap.peek();
                maxHeap.remove(nums[i- k]);
            }
            maxHeap.offer(nums[i]);
        }

        res[index] = maxHeap.poll();
        return res;
    }

    /**
     * 双端队列 -> deque
     * 时间复杂度:O(n)
     * @param nums
     * @param k
     * @return
     */
    public static ArrayList<Integer> maxSlidingWindow_using_deque(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        if (nums.length == 0 || nums == null || k <= 0) {
            return result;
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            //删除队列中小于窗口左边下标的元素
            if (i >= k && i - k + 1 > deque.peek()) {
                //each remove head element of deque
                deque.remove();
            }

            //从队列右侧开始, 删除小于nums[i] 的元素（即准备插入下标为i）
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.add(i);
            //队列左侧是最大值,加入结果
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }

        for (Integer item : res) {
            result.add(item);
        }

        return result;
    }


    public static ArrayList<Integer> maxSlidingWindow_(int[] nums, int size) {
        ArrayList<Integer> res = new ArrayList<>();

        if (nums.length == 0 || nums == null || size <= 0) {
            return res;
        }

        int index;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            index = i - size + 1;
            if (dq.isEmpty()) {
                dq.add(i);
            }else if (index > dq.peek()) {
                dq.remove();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.add(i);
            if (index >= 0) {
                res.add(nums[dq.peek()]);
            }
        }

        return res;
    }

}

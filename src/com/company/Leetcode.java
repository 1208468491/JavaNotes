package com.company;

/// 在文件中定义的类不能被关键字 public 标记
class ListNode {
    int val;
    ListNode next;

    ListNode() { }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this(val);
        this.next = next;
    }
}

public class Leetcode {
    /// 21. 合并两个有序链表
    // #迭代
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    }

    // #递归
    public static ListNode mergeTwoListsCur(ListNode list1, ListNode list2) {

    }
}

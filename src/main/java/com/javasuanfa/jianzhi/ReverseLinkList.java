package com.javasuanfa.jianzhi;

import java.util.ArrayList;

/**
 * @program: yarn
 * @description:
 * @author: liang.man
 * @create: 2019-03-11 14:18
 **/
public class ReverseLinkList {
    public static class ListNode{
        public int val;
        public ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
    }


    public static ArrayList<Integer> reverseList(ListNode root){
        if(root==null)
            return new ArrayList<Integer>();
        ListNode head = root;
        ListNode cur = head.next;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = head;
            head = cur;
            cur = tmp;
        }
        root.next=null;
        ArrayList<Integer> res = new ArrayList<Integer>();

        while(head!=null){
            res.add(head.val);
            head= head.next;
        }
        return res;

    }

    public static void main(String[] args){
        ListNode root = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode thrid = new ListNode(3);
        ListNode four = new ListNode(4);
        root.next=second;
        second.next=thrid;
        thrid.next=four;
        ArrayList<Integer> integers = reverseList(root);
        for (Integer a :integers) {
            System.out.println(a);
        }

    }
}

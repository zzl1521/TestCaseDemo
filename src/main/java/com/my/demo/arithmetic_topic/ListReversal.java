package com.my.demo.arithmetic_topic;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 链表反转
 *
 * @author: ZhangZhiLe
 * @date: Created in 2018/11/13 18:02
 */
public class ListReversal {


    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 借助递归实现
     * 1 2 两个节点
     * @author: ZhangZhiLe
     * @date: Created in 2018/11/14 16:45
     * @param:
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ListNode currNode=listNode;
        if (currNode!=null){
            if (currNode.next!=null){
                arrayList=this.printListFromTailToHead(currNode.next);
            }
            arrayList.add(currNode.val);
        }
        return arrayList;
    }



    /**
     * 链表反转
     * @author: ZhangZhiLe
     * @date: Created in 2018/11/14 16:44
     * @param:
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        ListNode currNode=listNode;
        ListNode pre=null;
        ListNode next=null;
        while (currNode!=null) {
             next = currNode.next;
             currNode.next=pre;
             pre=currNode;
             currNode=next;
        }

        while (pre!=null){
            arrayList.add(pre.val);
            pre=pre.next;
        }
        return arrayList;
    }


    /**
     * 借助栈实现
     * @author: ZhangZhiLe
     * @date: Created in 2018/11/14 16:45
     * @param:
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        Stack<ListNode> stack=new Stack();
        ListNode pre=listNode;
        while (pre!=null){
            stack.add(pre);
            pre=pre.next;
        }
        while (!stack.empty()){
            arrayList.add(stack.pop().val);
        }
        return arrayList;
    }

}

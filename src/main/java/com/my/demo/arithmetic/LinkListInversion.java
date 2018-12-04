package com.my.demo.arithmetic;

/**
 * 链表反转
 * @author: ZhangZhiLe
 * @date: Created in 2018/10/28 15:37
 */
public class LinkListInversion {


    public static void main(String[] args) {
        Node node1=new Node("node1");
        Node node2=new Node("node2");
        Node node3=new Node("node3");
        node1.setNext(node2);
        node2.setNext(node3);
        Node inversion = inversion(node1);
        System.out.println("反转后的数据："+inversion.getData());
        while (inversion!=null){
            System.out.println(inversion.getData()+":"+inversion.getNext());
            inversion=inversion.getNext();
        }
    }

    public static Node inversion(Node node){
        if (node==null){
            return null;
        }
        if (node.getNext()==null){
            return node;
        }
        Node preNode=null;
        Node currNode=node;
        Node nextNode=null;
        while (currNode!=null){
            nextNode=currNode.getNext();
            currNode.setNext(preNode);
            preNode=currNode;
            currNode=nextNode;
        }
        return preNode;
    }

    //节点1  节点2  节点3
    //节点3  节点2  节点1



    /**
     * 节点
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/29 15:09
     * @param:
     */
    public static class Node{
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

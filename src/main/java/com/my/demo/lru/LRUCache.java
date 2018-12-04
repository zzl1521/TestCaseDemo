package com.my.demo.lru;

import java.util.HashMap;


public class LRUCache<K, V> {

    private int currentCacheSize;
    private int CacheCapcity; //�����ʼ����Ĺ̶���С
    private HashMap<K,CacheNode> caches;//��������
    private CacheNode first;//(ʵ��˫����)����ͷ
    private CacheNode last;//(ʵ��˫����)����β

    public LRUCache(int size){
        currentCacheSize = 0;
        this.CacheCapcity = size;
        caches = new HashMap<K,CacheNode>(size);
    }

    public void put(K k,V v){
        CacheNode node = caches.get(k);
        if(node == null){
            if(caches.size() >= CacheCapcity){
                caches.remove(last.key);
                removeLast();
            }
            node = new CacheNode();
            node.key = k;
        }
        node.value = v;
        moveToFirst(node);
        caches.put(k, node);
    }

    public Object  get(K k){
        CacheNode node = caches.get(k);
        if(node == null){
            return null;
        }
        moveToFirst(node);
        return node.value;
    }

    public Object remove(K k){
        CacheNode node = caches.get(k);
        if(node != null){
            if(node.pre != null){
                node.pre.next=node.next;
            }
            if(node.next != null){
                node.next.pre=node.pre;
            }
            if(node == first){
                first = node.next;
            }
            if(node == last){
                last = node.pre;
            }
        }

        return caches.remove(k);
    }

    public void clear(){
        first = null;
        last = null;
        caches.clear();
    }


    private void moveToFirst(CacheNode node){
        if(first == node){
            return;
        }
        if(node.next != null){
            node.next.pre = node.pre; //�ƶ�node�ڵ�ǰ���˽ڵ�ǰ��ڵ�� pre��nest�ڵ��������
        }
        if(node.pre != null){
            node.pre.next = node.next;//�ƶ�node�ڵ�ǰ���˽ڵ�ǰ��ڵ�� pre��nest�ڵ��������
        }
        if(node == last){
            last= last.pre;//�����ǰnode�ڵ������ڵ㽫node�ڵ��ǰ�ڵ���Ϊ���ڵ�
        }
        if(first == null || last == null){
            first = last = node;//�����ǰnode�ڵ��ǵ�һ��cache�ڵ㣬��ôfirst��last�϶�����node
            return;
        }

        node.next=first;//��֮ǰ��first�ڵ���Ϊnode�ڵ��next�ڵ�
        first.pre = node;//��֮ǰ��first�ڵ��pre�ڵ���Ϊnode�ڵ�
        first = node;
        first.pre=null;

    }

    private void removeLast(){
        if(last != null){
            last = last.pre;//ɾ���ڵ�ǰ��last�ڵ��pre�ڵ���Ϊ���һ���ڵ�
            if(last == null){//���last�ڵ�Ϊnull�϶�first�ڵ�ҲӦ��Ϊnull
                first = null;
            }else{//���last�ڵ㲻Ϊnull��last�ڵ�next�ڵ���null
                last.next = null;
            }
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        CacheNode node = first;
        while(node != null){
            sb.append(String.format("%s:%s ", node.key,node.value));
            node = node.next;
        }

        return sb.toString();
    }

    class CacheNode{
        CacheNode pre;
        CacheNode next;
        Object key;
        Object value;
        public CacheNode(){

        }
    }

    public static void main(String[] args) {

        LRUCache<Integer,String> lru = new LRUCache<Integer,String>(3);

        lru.put(1, "a");    // 1:a
        System.out.println(lru.toString());
        lru.put(2, "b");    // 2:b 1:a
        System.out.println(lru.toString());
        lru.put(3, "c");    // 3:c 2:b 1:a
        System.out.println(lru.toString());
        lru.put(4, "d");    // 4:d 3:c 2:b
        System.out.println(lru.toString());
        lru.put(1, "aa");   // 1:aa 4:d 3:c
        System.out.println(lru.toString());
        lru.put(2, "bb");   // 2:bb 1:aa 4:d
        System.out.println(lru.toString());
        lru.put(5, "e");    // 5:e 2:bb 1:aa
        System.out.println(lru.toString());
        lru.get(1);         // 1:aa 5:e 2:bb
        System.out.println(lru.toString());
        lru.remove(11);     // 1:aa 5:e 2:bb
        System.out.println(lru.toString());
        lru.remove(1);      //5:e 2:bb
        System.out.println(lru.toString());
        lru.put(1, "aaa");  //1:aaa 5:e 2:bb
        System.out.println(lru.toString());
    }

}

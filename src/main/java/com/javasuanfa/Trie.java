package com.javasuanfa;

import java.util.TreeMap;

/**
 * @program: yarn
 * @description:
 * @author: liang.man
 * @create: 2019-03-06 10:56
 **/
public class Trie {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap();
        }

        public Node() {
            this(false);
        }

    }


    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }


    public void add(String word) {
        Node cur = root;
        char[] chars = word.toCharArray();
        for (Character c : chars) {
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);

        }
        if (cur.isWord == false) {
            cur.isWord = true;
            size++;
        }
    }


    public boolean search(String word) {
        Node cur = root;
        char[] chars = word.toCharArray();
        for (Character c : chars) {
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return true;    //与查询是否包含操作唯一不同之处
    }


}



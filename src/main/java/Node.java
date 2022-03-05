//package trie;

import java.util.*;
class Node {
    char s;
    HashMap<Character, Node> subNode = new HashMap<Character, Node>();
    boolean isLast;
    public Node(){
        this.s = s;
    }
}
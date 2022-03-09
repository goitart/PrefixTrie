/*
Вариант 13 -- префиксное дерево
Хранит строки в виде префиксного дерева.
Корневой узел такого дерева не хранит ничего,
узлы 1-го уровня хранят первый символ строки,
2-го уровня -- второй символ и так далее.
Методы: добавление строки в дерево,
удаление строки из дерева, поиск строки в дереве,
поиск всех строк в дереве с заданным префиксом.
*/
//package trie;

import java.util.*;
class Node {
    char letter;
    HashMap<Character, Node> subNode = new HashMap<Character, Node>();
    boolean isLast;
    public Node(char ch){
        letter = ch;
        subNode = new HashMap<Character, Node>();
        isLast = false;
    }
}

public class Trie {
//    static class Node {
//        private boolean isLast;
//        private Map<Character, Node> subNode = new HashMap<Character, Node>();
//        char s;
//
//        public Node() {
//            this.s = s;
//        }
//
//        public boolean getIsLast() {
//            return isLast;
//        }
//
//        public void setIsLast(boolean isLast) {
//            this.isLast = isLast;
//        }
//    }

    Node root;

    Trie() {
        root = new Node(' ');
    }


    public void addWord(String string) {
        Node thisNode = root;
        Map<Character, Node> subNode = root.subNode;
        if (string.isEmpty()) {
            return;
        }
        for (int i = 0; i < string.toCharArray().length; i++) {
            char letter = string.charAt(i);
            if (subNode.containsKey(letter)) {
                thisNode = subNode.get(letter);//поиск по ключу(value) или null
            }
            else {
                Node nextNode = new Node(letter);
                subNode.put(letter, nextNode);//добавление пары, если такое нет
                thisNode = nextNode;
            }
        }
        thisNode.isLast = true;
    }
    public boolean findWord(String word) {
        Node thisNode = root;
        for (char letter : word.toCharArray()) {
            if (!thisNode.subNode.containsKey(letter)) {
                return false;
            }
        }
        return true;
    }
    public List<String> findWithPrefix(String prefix) {
        Node thisNode = root;
        for (char letter : prefix.toCharArray()) {
            if (!thisNode.subNode.containsKey(letter)) {
                return null;
            }

        }
        return null;
    }


    public static void main(String[] args) {
    }
}

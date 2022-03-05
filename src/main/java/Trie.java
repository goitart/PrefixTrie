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

    private Node root;

    public Trie() {
        root = new Node();
    }


    public void addWord(String word) {
        Map<Character, Node> subNode = root.subNode;
        if (word.isEmpty()) {
            return;
        }
        for (int i = 0; i < word.toCharArray().length; i++) {

        }

//        isLast = true;
    }


    public static void main(String[] args) {
    }
}

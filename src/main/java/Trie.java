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
//class Node {
//    char letter;
//    HashMap<Character, Node> subNode = new HashMap<Character, Node>();
//    boolean isLast;
//    public Node(char ch){
//        letter = ch;
//        subNode = new HashMap<Character, Node>();
//        isLast = false;
//    }
//}

public class Trie {
    public static class Node {
        char letter;
        HashMap<Character, Node> subNode = new HashMap<Character, Node>();
        boolean isLast;
        public Node(char ch){
            letter = ch;
            subNode = new HashMap<Character, Node>();
            isLast = false;
        }
    }
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
        String prefixWord = "";
        List<String> listOfWord = new ArrayList<>();
        if (prefix.length() == 0) {
            return null;
        }
        for (char letter : prefix.toCharArray()) {
            if (!thisNode.subNode.containsKey(letter)) {
                return null;
            } else {
                prefixWord += letter;
                thisNode = thisNode.subNode.get(letter);
                if (thisNode.isLast) {
                    listOfWord.add(prefixWord);
                }
            }
        }
        return listOfWord;
    }
    public void delete(String word) {
        Node thisNode = root;
        Map<Character, Node> subNode = root.subNode;
        if (word.isEmpty()) {
            return;
        }
        for (int i = 0; i < word.toCharArray().length; i++) {
            char letter = word.charAt(i);
            if (subNode.containsKey(letter)) {
                thisNode = subNode.get(letter);//поиск по ключу(value) или null
            }
            else {
                Node nextNode = new Node(letter);
                subNode.put(letter, nextNode);//добавление пары, если такое нет
                thisNode = nextNode;
            }
        }
        thisNode.isLast = false;
    }


//    public static void main(String[] args) {
//    }
}

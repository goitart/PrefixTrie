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

    public static class Node {
        char letter;
        HashMap<Character, Node> subNode = new HashMap<Character, Node>();
        boolean isLast;

        public Node(char ch) {
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
//        Map<Character, Node> subNode = root.subNode;
        if (string.isEmpty()) {
            return;
        }
        for (int i = 0; i < string.toCharArray().length; i++) {
            char letter = string.charAt(i);
            if (thisNode.subNode.containsKey(letter)) {
                thisNode = thisNode.subNode.get(letter);//поиск по ключу(value) или null
            } else {
                Node nextNode = new Node(letter);
                thisNode.subNode.put(letter, nextNode);//добавление пары, если такое нет
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
            } else thisNode = thisNode.subNode.get(letter);
        }
        return thisNode.isLast;
    }

    public void getAllWords(Node thisNode, StringBuilder word, List<String> words) {
        for (char letter : thisNode.subNode.keySet()) {
            word.append(letter);
            getAllWords(thisNode.subNode.get(letter), word, words);
        }
        if (!words.contains(String.valueOf(word))) {
            words.add(String.valueOf(word));
        }
    }

    public List<String> findWithPrefix(String prefix) {
        Node thisNode = root;
        StringBuilder prefixWord = new StringBuilder();
        List<String> emptyList = new ArrayList<>();
        List<String> listOfWords = new ArrayList<>();
        if (prefix.length() == 0) {
            return listOfWords;
        }
        for (char letter : prefix.toCharArray()) {
            if (thisNode.subNode.containsKey(letter)) {
                prefixWord.append(letter);
                String stringWord = prefixWord.toString();
                thisNode = thisNode.subNode.get(letter);
            } else {
                return listOfWords;
            }
        }
        if (thisNode.isLast) {
//            String stringWord = prefixWord.toString();
//            listOfWords.add(stringWord);
            listOfWords.add(String.valueOf(prefixWord));
        }
        getAllWords(thisNode, prefixWord, listOfWords);
        return listOfWords;
    }


    // delete удаляет не узлы, а указатель на конец слова
    public void delete(String word) {
        Node thisNode = root;
        if (word.isEmpty()) {
            return;
        }
        for (int i = 0; i < word.toCharArray().length; i++) {
            char letter = word.charAt(i);
            if (thisNode.subNode.containsKey(letter)) {
                thisNode = thisNode.subNode.get(letter);//поиск по ключу(value) или null
            } else break;
        }
        thisNode.isLast = false;
    }
}

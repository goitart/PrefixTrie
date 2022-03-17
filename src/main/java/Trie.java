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

class Trie {

    public static class Node {
        char letter;
        HashMap<Character, Node> subNode;
        boolean isLast;

        Node(char ch) {
            letter = ch;
            subNode = new HashMap<>();
            isLast = false;
        }
    }

    Node root;

    Trie() {
        root = new Node(' ');
    }


    public void addWord(String string) {
        Node thisNode = root;
        if (string.isEmpty()) {
            return;
        }

        for (int i = 0; i < string.toCharArray().length; i++) {
            char letter = string.charAt(i);
            if (thisNode.subNode.containsKey(letter)) {
                thisNode = thisNode.subNode.get(letter);
            }
            else {
                Node nextNode;
                thisNode.subNode.putIfAbsent(letter, nextNode = new Node(letter));
                thisNode = nextNode;
            }

//            Node nextNode;

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

    public void getAllWords(Node thisNode, StringBuilder word, HashSet<String> words) {
        for (char s : thisNode.subNode.keySet()) {
            word.append(s);
            if (thisNode.subNode.get(s).isLast) {
                words.add(String.valueOf(word));
            }
            getAllWords(thisNode.subNode.get(s), word, words);
            word.deleteCharAt(word.length() - 1);
        }

    }

    public HashSet<String> findWithPrefix(String prefix) {
        Node thisNode = root;
        StringBuilder prefixWord = new StringBuilder();
        HashSet<String> emptyList = new HashSet<>();
        HashSet<String> listOfWords = new HashSet<>();
        if (prefix.length() == 0) {
            return emptyList;
        }

        for (char letter : prefix.toCharArray()) {
            if (thisNode.subNode.containsKey(letter)) {
                prefixWord.append(letter);
                String stringWord = prefixWord.toString();
                thisNode = thisNode.subNode.get(letter);
            } else {
                return emptyList;
            }
        }
        if (thisNode.isLast) {
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
//            if (thisNode.subNode.containsKey(letter)) {
//                thisNode = thisNode.subNode.get(letter);
//            } else break;

            thisNode = thisNode.subNode.get(letter);
            thisNode.subNode = null;

        }
        thisNode.isLast = false;
    }
}

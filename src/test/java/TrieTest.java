import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {
    @Test
    void find() {
        Trie newTrie = new Trie();
        newTrie.addWord("port");
//        newTrie.addWord("dog");
        newTrie.addWord("sponge");
//        newTrie.addWord("dog");
//        newTrie.addWord("portal");

        assertTrue(newTrie.findWord("port"));
//        assertTrue(newTrie.findWord("p"));
//        assertFalse(newTrie.findWord("p"));
//        assertTrue(newTrie.findWord("dog"));
        assertTrue(newTrie.findWord("sponge"));
//        assertFalse(newTrie.findWord("d"));
//        assertTrue(newTrie.findWord("porta"));


    }
}
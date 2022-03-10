import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TrieTest {
    @Test
    void testFind() {
        Trie newTrie = new Trie();

        newTrie.addWord("port");
        newTrie.addWord("sponge");
        newTrie.addWord("dog");
        newTrie.addWord("portal");
        newTrie.addWord("dog");
        newTrie.addWord("");

        assertTrue(newTrie.findWord("port"));
        assertFalse(newTrie.findWord("spo"));
        assertTrue(newTrie.findWord("dog"));
        assertTrue(newTrie.findWord("sponge"));
        assertFalse(newTrie.findWord("d"));
        assertTrue(newTrie.findWord("portal"));
        assertFalse(newTrie.findWord("porta"));
        assertFalse(newTrie.findWord(""));

    }
    @Test
    void testFindWithPrefix() {
        Trie newTrie = new Trie();
        newTrie.addWord("port");
        newTrie.addWord("sponge");
        newTrie.addWord("dog");
        newTrie.addWord("portal");
        newTrie.addWord("dog");
        newTrie.addWord("");
        newTrie.addWord("portopit");

        assertEquals(newTrie.findWithPrefix("k"), List.of());
        assertEquals(List.of("port", "portal", "portopit"), newTrie.findWithPrefix("p0"));
    }
    @Test
    void testDelete() {
        Trie newTrie = new Trie();

        newTrie.addWord("port");
        newTrie.addWord("sponge");
        newTrie.addWord("dog");
        newTrie.addWord("portal");
        newTrie.addWord("dog");
        newTrie.addWord("");

        newTrie.delete("port");
        newTrie.delete("");
        newTrie.delete("dog");
        newTrie.delete("dog");

        assertFalse(newTrie.findWord("port"));
        assertFalse(newTrie.findWord("spo"));
        assertFalse(newTrie.findWord("dog"));
        assertTrue(newTrie.findWord("sponge"));
        assertFalse(newTrie.findWord("d"));
        assertTrue(newTrie.findWord("portal"));
        assertFalse(newTrie.findWord("porta"));
        assertFalse(newTrie.findWord(""));

    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.List;
import java.util.Set;

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
    //Элементы в list стоят в другом порядке, из-за этого тест не проходит.
    @Test
    void testFindWithPrefix() {
        Trie newTrie = new Trie();
        newTrie.addWord("pop");
        newTrie.addWord("port");
        newTrie.addWord("portport");
        newTrie.addWord("portal");
        newTrie.addWord("sponge");
        newTrie.addWord("dog");
        newTrie.addWord("dog");
        newTrie.addWord("dogdog");
        newTrie.addWord("death");

        assertEquals(newTrie.findWithPrefix("k"), List.of());
        assertEquals(List.of("pop", "port", "portport","portal"), newTrie.findWithPrefix("po"));
        assertEquals(List.of("dog", "death", "dogdog"), newTrie.findWithPrefix("d"));
        assertEquals(List.of(), newTrie.findWithPrefix(""));
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
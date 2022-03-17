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
        assertTrue(newTrie.findWord("port"));
        newTrie.addWord("sponge");

        newTrie.addWord("dog");

        newTrie.addWord("portal");

        assertTrue(newTrie.findWord("portal"));

        newTrie.addWord("dog");

        newTrie.addWord("");



        assertFalse(newTrie.findWord("spo"));

        assertTrue(newTrie.findWord("dog"));

        assertTrue(newTrie.findWord("sponge"));

        assertFalse(newTrie.findWord("d"));

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

        assertEquals(Set.of(), newTrie.findWithPrefix("k"));
        assertEquals(Set.of("pop", "port", "portport","portal"), newTrie.findWithPrefix("po"));
        assertEquals(Set.of("dog", "death", "dogdog"), newTrie.findWithPrefix("d"));
        assertEquals(Set.of(), newTrie.findWithPrefix(""));
    }
    @Test
    void testDelete() {
        Trie newTrie = new Trie();

        newTrie.addWord("port");
        assertTrue(newTrie.findWord("port"));
        newTrie.addWord("sponge");
        assertTrue(newTrie.findWord("sponge"));
        newTrie.addWord("dog");
        assertTrue(newTrie.findWord("dog"));
        newTrie.addWord("portal");
        assertTrue(newTrie.findWord("portal"));
        newTrie.addWord("dog");
        assertTrue(newTrie.findWord("dog"));
        newTrie.addWord("");

        newTrie.delete("port");
        assertFalse(newTrie.findWord("port"));
        newTrie.delete("");
        newTrie.delete("dog");
        assertFalse(newTrie.findWord("dog"));
        newTrie.delete("dog");
        assertFalse(newTrie.findWord("dog"));
        newTrie.delete("joke");
        assertFalse(newTrie.findWord("joke"));

        assertFalse(newTrie.findWord("port"));
        assertFalse(newTrie.findWord("spo"));
        assertFalse(newTrie.findWord("dog"));
        assertTrue(newTrie.findWord("sponge"));
        assertFalse(newTrie.findWord("d"));
        assertTrue(newTrie.findWord("portal"));
        assertFalse(newTrie.findWord("porta"));
        assertFalse(newTrie.findWord(""));
        assertFalse(newTrie.findWord("joke"));
    }
}
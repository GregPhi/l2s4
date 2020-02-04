import tptrie.trie.Trie;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrieTest {

	@Test
	public void testCreate() {
		Trie t = new Trie();
		assertNotNull(t);
	}

	@Test
	public void testAdd() {
		Trie t = new Trie();
		assertFalse(t.contains("banane"));
		t.add("banane");
		assertTrue(t.contains("banane"));
	}

	@Test
	public void testContains(){
		Trie t = new Trie();
		assertFalse(t.contains("cerise"));
		t.add("cerise");
		assertTrue(t.contains("cerise"));
		assertFalse(t.contains("ceriso"));
		assertFalse(t.contains("risece"));
	}

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(TrieTest.class);
    }

}

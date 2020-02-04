import tptrie.trie.CompactTrie;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompactTrieTest {

	@Test
	public void testCreate(){
		CompactTrie cT = new CompactTrie();
		assertNotNull(cT);
	}

	@Test
	public void testCommonLetters(){
		CompactTrie cT = new CompactTrie();
		assertEquals(3,cT.commonLetters("ban","banane"));
	}

	@Test
	public void testadd() {
		CompactTrie cT = new CompactTrie();
		assertFalse(cT.contains("banane"));
		cT.add("banane");
		assertTrue(cT.contains("banane"));
	}

	@Test
	public void testcontains() {
		CompactTrie cT = new CompactTrie();
		assertFalse(cT.contains("cerise"));
		cT.add("cerise");
		assertTrue(cT.contains("cerise"));
		assertFalse(cT.contains("ceriso"));
		assertFalse(cT.contains("risece"));
	}

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(CompactTrieTest.class);
    }

}

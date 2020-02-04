trie:
	clear
	rm -rf classes/*
	javac -sourcepath src src/tptrie/*.java -d classes
	javac -sourcepath src src/tptrie/trie/*.java -d classes

dc:
	clear
	rm -rf docs/*
	javadoc -d docs -cp src/ -subpackages tptrie

TrieMain: tp
	java -classpath classes tptrie.TrieMain

CompactTrieMain: tp
	java -classpath classes tptrie.CompactTrieMain

Main: tp
	java -classpath classes tptrie.Main

compileTest:
	clear
	rm -rf test/*.class
	javac -classpath test-1.7.jar test/*.java

testo:
	make compileTest
	java -jar test-1.7.jar TrieTest
	java -jar test-1.7.jar CompactTrieTest

png:
	clear
	dot -Tpng trie.dot > trie.png
	dot -Tpng compactTrie.dot > compactTrie.png

tp: trie dc compileTest

rendu : tp clean

clean:
	rm -rf classes/*
	rm -rf docs/*
	rm -rf test/*.class

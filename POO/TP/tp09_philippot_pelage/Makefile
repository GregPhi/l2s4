goosegame:
	rm -rf classes
	mkdir classes
	javac -sourcepath src src/goosegame/*.java -d classes
	javac -sourcepath src src/goosegame/board/*.java -d classes
	javac -sourcepath src src/goosegame/cell/*.java -d classes

docs:
	rm -rf docs
	mkdir docs
	javadoc -d docs -cp src/ -subpackages goosegame

compileTest:
	rm -rf test/*.class
	javac -classpath test-1.7.jar test/*.java

testo: compileTest PlayerTest BoardTest CellTest
PlayerTest:
	java -jar test-1.7.jar PlayerTest
BoardTest:
	java -jar test-1.7.jar BoardTest
CellTest:
	java -jar test-1.7.jar CellTest

jar_c:
	make goosegame
	make docs
	make compileTest
	jar cvfm goosegame.jar manifest-ex docs test -C classes goosegame
	jar cvfm goosegame2.jar manifest-ex2 docs test -C classes goosegame

run:
	java -jar goosegame.jar
	clear
	java -jar goosegame2.jar

rendu: jar_c clean

clean:
	rm -rf classes
	rm -rf docs
	rm -rf test/*.class

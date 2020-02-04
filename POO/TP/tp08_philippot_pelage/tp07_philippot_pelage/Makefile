all_com_doc:
	make compile
	rm -rf docs
	make docs
	make compileTest
	make GameJar_c

compile:
	rm -rf classes
	mkdir classes
	javac -sourcepath src src/game/*.java -d classes
	javac -sourcepath src src/game/strategy/*.java -d classes
	javac -sourcepath src src/game/util/*.java -d classes

gameMain:
	java -classpath classes game.GameMain

docs:
	rm -rf docs
	mkdir docs
	javadoc -d docs -cp src/ -subpackages game

compileTest:
	rm -rf test/*.class
	javac -classpath test-1.7.jar test/*.java

make testo:
	make compileTest
	make GameTest
	make PlayerTest

GameTest:
	java -jar test-1.7.jar GameTest

PlayerTest:
	java -jar test-1.7.jar PlayerTest

GameJar_c:
	jar cvfm appli.jar manifest-ex docs test -C classes game

GameJar:
	java -jar appli.jar

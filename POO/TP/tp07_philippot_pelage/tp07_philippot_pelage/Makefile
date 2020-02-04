all:
	make compile
	make docs
	make gameMain
	make compileTest

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
	make ImageTest
	make PixelTest
	make ColorTest

ImageTest:
	java -jar test-1.7.jar ImageTest

PixelTest:
	java -jar test-1.7.jar PixelTest

ColorTest:
	java -jar test-1.7.jar ColorTest

GameJar_c:
	jar cvfm appli.jar manifest-ex docs test -C classes game

GameJar:
	java -jar appli.jar

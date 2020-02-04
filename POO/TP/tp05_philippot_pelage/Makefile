compile:
	make clean_classes
	mkdir classes
	javac -sourcepath src src/hanoi/Hanoi.java -d classes
	javac -sourcepath src src/hanoi/util/Disc.java -d classes
	javac -sourcepath src src/hanoi/util/Tower.java -d classes
	javac -sourcepath src src/hanoi/util/TowerIsEmptyException.java -d classes
	javac -sourcepath src src/hanoi/util/TowerIsFullException.java -d classes
	javac -sourcepath src src/hanoi/HanoiMain.java -d classes
	javac -sourcepath src src/hanoi/HanoiInteractiveMain.java -d classes
	javac -sourcepath src src/hanoi/io/HanoiInput.java -d classes
	javac -sourcepath src src/hanoi/io/Input.java -d classes

clean_classes:
	rm -rf classes

main:
	java -classpath classes hanoi.HanoiMain

docs:
	rm -rf docs
	mkdir docs
	javadoc -d docs -cp src/ -subpackages hanoi

clean_docs:
	rm -rf docs

compileTest:
	make clean_test
	javac -classpath test-1.7.jar test/DiscTest.java
	javac -classpath test-1.7.jar test/TowerTest.java

clean_test:
	rm -rf test/*class

testo :
	make DiscTest
	make TowerTest

DiscTest:
	java -jar test-1.7.jar DiscTest

TowerTest:
	java -jar test-1.7.jar TowerTest

HanoiJar_c:
	jar cvfm hanoiMain.jar manifest-ex docs test -C classes hanoi

HanoiJar:
	java -jar hanoiMain.jar 3

all:
	make compile
	make docs
	make compileTest
	make testo
	make HanoiJar_c
	make HanoiJar

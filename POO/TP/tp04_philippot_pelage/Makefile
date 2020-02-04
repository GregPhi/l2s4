all: compile docs compileTest RobotJar_c

mak: RobotTest BoxTest main RobotJar

compile:
	mkdir classes
	javac -sourcepath src src/robot/util/ConveyerBelt.java -d classes
	javac -sourcepath src src/robot/util/Box.java -d classes
	javac -sourcepath src src/robot/Robot.java -d classes

docs:
	mkdir docs
	javadoc -d docs -cp src/ -subpackages robot

compileTest:
	javac -classpath test-1.7.jar test/BoxTest.java
	javac -classpath test-1.7.jar test/RobotTest.java

RobotTest:
	java -jar test-1.7.jar RobotTest

BoxTest:
	java -jar test-1.7.jar BoxTest

main:
	java -classpath classes robot.Robot

RobotJar_c:
	jar cvfm appli.jar manifest-ex docs test -C classes robot

RobotJar:
	java -classpath appli.jar robot.Robot

clean:
	rm -rf docs classes test/*.class

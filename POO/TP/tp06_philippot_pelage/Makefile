all:
	make compile
	make docs
	make image_example
	make compileTest
	make testo
	make ImageJar_c
	make ImageJar

compile:
	rm -rf classes
	mkdir classes
	javac -sourcepath src src/image/color/GrayColor.java -d classes
	javac -sourcepath src src/image/Image.java -d classes
	javac -sourcepath src src/image/ImageDisplayer.java -d classes
	javac -sourcepath src src/image/ImageExample.java -d classes
	javac -sourcepath src src/image/ImageInterface.java -d classes
	javac -sourcepath src src/image/ImageMain.java -d classes
	javac -sourcepath src src/image/Pixel.java -d classes
	javac -sourcepath src src/image/UnknownPixelException.java -d classes

image_example:
	java -classpath classes image.ImageExample

docs:
	rm -rf docs
	mkdir docs
	javadoc -d docs -cp src/ -subpackages image

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

ImageJar_c:
	jar cvfm appli.jar manifest-ex docs test images -C classes image

ImageJar:
	java -jar appli.jar /images/lamp.pgm 15 16

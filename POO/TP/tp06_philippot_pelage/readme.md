Philippot Gregoire & Pelage François-Xavier

TP : Images

Objectif du TP :

  - codez la classe GrayColor

  - codez la classe Pixel

  - codez la classe Image

  - codez la classe ImageExample

  - codez la classe ImageMain

  Pour générer une documentation, il faut d'abord créer un dossier "docs",
  puis d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> creation doc
  	"make docs"
  		- rm -rf docs
  		- mkdir docs
  		- javadoc -d docs -cp src/ -subpackages image

  Pour compiler les classes du projet et éxécuter le main,
  il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> compiler
  	"make compile"
  		- rm -rf classes
  		- mkdir classes
      - javac -sourcepath src src/image/color/GrayColor.java -d classes
      -	javac -sourcepath src src/image/Image.java -d classes
      -	javac -sourcepath src src/image/ImageDisplayer.java -d classes
      -	javac -sourcepath src src/image/ImageExample.java -d classes
      -	javac -sourcepath src src/image/ImageInterface.java -d classes
      -	javac -sourcepath src src/image/ImageMain.java -d classes
      -	javac -sourcepath src src/image/Pixel.java -d classes
	    - javac -sourcepath src src/image/UnknownPixelException.java -d classes

    ==> éxécuter
  	"make image_example"
  		- java -classpath classes image.ImageExample

  Pour compiler et exécuter les test ,
  il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> compiler
  	"make compileTest"
  		- rm -rf test/*class
  		- javac -classpath test-1.7.jar test/*.java

  	==> éxécuter
  	"make ImageTest"	pour tester les tests liés à la class Image
  		java -jar test-1.7.jar ImageTest
    "make PixelTest" pour tester les tests liés à la class Pixel
      - java -jar test-1.7.jar PixelTest
  	"make ColorTest" pour tester les tests liés à la class Color
  		- java -jar test-1.7.jar ColorTest

  Pour compiler et éxécuter un .jar,
  il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> compiler
  	"make ImageJar_c"
  		- jar cvfm appli.jar manifest-ex docs test images -C classes image

  	==> éxécuter
  	"make ImageJar"
  		- java -jar appli.jar /images/lamp.pgm 15 16


  Afin d'éxécuter toutes les commandes dans l'ordre :

  	==> make all
  	"make all"
    	- make compile
      -	make docs
      -	make image_example
      -	make compileTest
      -	make testo
      -	make ImageJar_c
      -	make ImageJar

  Etat du projet:

  	- Tp terminé

  	- Pour éxécuter le programme "graphique", il faut éxcuter la/les commande/s:

  			- make ImageJar

  			- java -jar appli.jar /images/"nom de l'image".png "edge" "decrease"

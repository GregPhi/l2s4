Philippot Gregoire & Pelage François-Xavier

              TP : Agency

Objectif du TP :

  - codez

  Pour générer une documentation, il faut d'abord créer un dossier "docs",
  puis d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> creation doc
  	"make docs"
  		- rm -rf docs
  		- mkdir docs
  		- javadoc -d docs -cp src/ -subpackages rental

  Pour compiler les classes du projet et éxécuter le main,
  il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> compiler
  	"make compile"
  		- rm -rf classes
  		- mkdir classes
      - javac -sourcepath src src/rental/*.java -d classes

    ==> éxécuter
  	"make main"
  		- make MainQ2
      - make MainQ5
      - make MainQ7

  Pour compiler et exécuter les test ,
  il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> compiler
  	"make compileTest"
  		- rm -rf test/*class
  		- javac -classpath test-1.7.jar test/*.java

  	==> éxécuter
  	"make "	pour tester les tests liés à la class
  		java -jar test-1.7.jar
    "make " pour tester les tests liés à la class
      - java -jar test-1.7.jar
  	"make " pour tester les tests liés à la class
  		- java -jar test-1.7.jar

  Pour compiler et éxécuter un .jar,
  il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> compiler
  	"make appli_c"
  		- jar cvfm appli.jar manifest-ex docs test images -C classes image

  	==> éxécuter
  	"make appli"
  		- java -jar appli.jar


  Afin d'éxécuter toutes les commandes dans l'ordre :

  	==> make all
  	"make all"
    	- make compile
      -	make docs
      -	make main
      -	make compileTest
      -	make testo
      -	make appli_c
      -	make appli

  Etat du projet:

  	- Tp terminé

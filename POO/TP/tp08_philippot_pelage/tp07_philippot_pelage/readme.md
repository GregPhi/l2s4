Philippot Gregoire & Pelage François-Xavier

TP : Pierre-Feuille-Ciseaux

Objectif du TP :

  - codez les classes Game, GameMain, Player, Shape, Strategy

  - codez les classes CounterStrategy, PaperStrategy, PlayerStrategy, RandomStrategy, RockStrategy, ScissorStrategy

  Pour générer une documentation, il faut d'abord créer un dossier "docs",
  puis d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> creation doc
  	"make docs"
  		- rm -rf docs
  		- mkdir docs
  		- javadoc -d docs -cp src/ -subpackages game

  Pour compiler les classes du projet et éxécuter le main,
  il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> compiler
  	"make compile"
  		- rm -rf classes
  		- mkdir classes
    	- javac -sourcepath src src/game/*.java -d classes
    	- javac -sourcepath src src/game/strategy/*.java -d classes
    	- javac -sourcepath src src/game/util/*.java -d classes

  Pour compiler et exécuter les test ,
  il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> compiler
  	"make compileTest"
  		- rm -rf test/*class
  		- javac -classpath test-1.7.jar test/*.java

  	==> éxécuter
  	"make GameTest"	pour tester les tests liés à la class Game
  		java -jar test-1.7.jar GameTest
    "make PlayerTest" pour tester les tests liés à la class Player
      - java -jar test-1.7.jar PlayerTest

  Pour compiler et éxécuter un .jar, il faut avoir compiler les classes du package game et les test, et la création de la doc.
  il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> compiler
  	"make GameJar_c"
  		- jar cvfm appli.jar manifest-ex docs test -C classes game

  	==> éxécuter
  	"make GameJar"
  		- java -jar appli.jar


  Afin d'éxécuter toutes les commandes dans l'ordre :

  	==> make all
  	"make all"
    	- make compile
      - rm -rf docs
      -	make docs
      -	make compileTest
      -	make GameJar_c

  Etat du projet:

  	- Tp terminé

  	- Pour éxécuter le jeu : java -jar appli.jar

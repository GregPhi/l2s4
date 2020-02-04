Philippot Gregoire & Pelage François-Xavier

              TP : GooseGame

Il existe 2 méthodes principales : Main, et MainNoChoice.
Main permet de choisir si il s'agit d'un board classic, ou random, puis vous pouvez choisir le nombre de joueur qui participeront à la partie avec leur pseudo.
MainNoChoice lance une partie de goosegame, avec un board classic sans pouvoir rien choisir (tout est déja implémenté).

Objectif du TP :

  - codez les classes : Board, Cell, Game, Player et Main
  - codez les classes : ClassicBoard et RandomBoard héritant de la classe Board
  - codez les classes : GooseCell, NormalCell, TpCell, TrapCell et WaitCell héritant de la classe Cell

  Pour générer une documentation, il faut d'abord créer un dossier "docs",
  puis d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> creation doc
  	"make docs"
  		- rm -rf docs
  		- mkdir docs
  		- javadoc -d docs -cp src/ -subpackages goosegame

  Pour compiler les classes du projet et éxécuter le main,
  il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> compiler
  	"make compile"
  		- rm -rf classes
  		- mkdir classes
      - javac -sourcepath src src/goosegame/*.java -d classes
	    - javac -sourcepath src src/goosegame/board/*.java -d classes
	    - javac -sourcepath src src/goosegame/cell/*.java -d classes

  Pour compiler et exécuter les test ,
  il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> compiler
  	"make compileTest"
  		- rm -rf test/*class
  		- javac -classpath test-1.7.jar test/*.java

  	==> éxécuter
  	"make PlayerTest"	pour tester les tests liés à la classe PlayerTest
  		java -jar test-1.7.jar BoardTest
    "make BoardTest" pour tester les tests liés à la classe BoardTest
      - java -jar test-1.7.jar BoardTest
  	"make BoardTest" pour tester les tests liés à la classe BoardTest
  		- java -jar test-1.7.jar BoardTest

  Pour compiler et éxécuter un .jar,
  il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

  	==> compiler
    "make jar_c"
    	- make goosegame
	    - make docs
	    - make compileTest
	    - jar cvfm goosegame.jar manifest-ex docs test -C classes goosegame

  	==> éxécuter
  	"make run"
  		- java -jar goosegame.jar


  Afin d'éxécuter toutes les commandes dans l'ordre :

  	==> make all
  	"make all"
    	- make compile
      -	make docs
      -	make compileTest
      -	make testo, permet d'effectuer les test Player, Board et Cell
      -	make jar_c
      -	make run

  Etat du projet:

  	- Tp terminé

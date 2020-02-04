Pelage François-Xavier & Philippot Gregoire

TP : TOURS D'HANOI

Objectif du TP :

	- coder les classes : Hanoi, Disc et Tower

	- coder une classe HanoiMain

	- coder une classe HanoiInteractiveMain


Pour générer une documentation, il faut d'abord créer un dossier "docs",
puis d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

	==> creation doc
	"make docs"
		- make clean_docs
		- mkdir docs
		- javadoc -d docs -cp src/ -subpackages hanoi

Pour compiler les classes du projet et éxécuter le main,
il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

	==> compiler
	"make compile"
		- make clean_classes
		- mkdir classes
		- javac -sourcepath src src/hanoi/Hanoi.java -d classes
		- javac -sourcepath src src/hanoi/util/Disc.java -d classes
		- javac -sourcepath src src/hanoi/util/Tower.java -d classes
		- javac -sourcepath src src/hanoi/util/TowerIsEmptyException.java -d classes
		- javac -sourcepath src src/hanoi/util/TowerIsFullException.java -d classes
		- javac -sourcepath src src/hanoi/HanoiMain.java -d classes
		- javac -sourcepath src src/hanoi/HanoiInteractiveMain.java -d classes
		- javac -sourcepath src src/hanoi/io/HanoiInput.java -d classes
		- javac -sourcepath src src/hanoi/io/Input.java -d classes

	==> éxécuter
	"make main"
		- java -classpath classes hanoi.HanoiMain

Pour compiler et exécuter les test ,
il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

	==> compiler
	"make compileTest"
		- make clean_test
		- javac -classpath test-1.7.jar test/*.java

	==> éxécuter
	"make DiscTest"	pour tester les tests liés à la class Disc
		- java -jar test-1.7.jar DiscTest
	"make TowerTest" pour tester les tests liés à la class Tower
		- java -jar test-1.7.jar TowerTest

Pour compiler et éxécuter un .jar,
il suffit d' ouvrir le dossier racine du projet dans le terminal et d'utiliser la commande :

	==> compiler
	"make HanoiJar_c"
		- jar cvfm hanoiMain.jar manifest-ex docs test -C classes hanoi

	==> éxécuter
	"make HanoiJar"
		- java -jar hanoiMain.jar 3


Afin d'éxécuter toutes les commandes dans l'ordre :

	==> make all
	"make all"
		- make compile
		- make docs
		- make compileTest
		- make testo
		- make HanoiJar_c
		- make HanoiJar


Etat du projet:

	- Tp terminé

	- Pour éxécuter le programme "graphique", il faut éxcuter la/les commande/s:

			- make HanoiJar

			- java -jar hanoiMain.jar "la taille du plus grand disque"(ici 3)

	- Nous avons mis dans Hanoi.java deux versions pour afficher les tours et leurs disques (celle en commentaire affichait les tours de façon verticale), pour celle ne se trouvant pas en commentaire elle affiche les tours jusqu'a une taille de disque d'environ 20.

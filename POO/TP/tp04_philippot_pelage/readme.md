Pelage François-Xavier & Philippot Gregoire

				TP : Manipulations

Objectif du TP :
	- apprendre la compilation
	- éxécuter un programme
	- générer de la documentation
	- gérer (compiler/éxécuter) des tests
	- gérer (compiler/éxécuter) une archive

Nous avons renommé le dossier example par robot
Les dossiers classes et docs seront créés en compilant et en générant la documentation, mais si vous voulez relancer la commande de compilation ou de génération de docs,
il faudra éxécuter cette commande dans le dossier racine :
  "make clean"
	  rm -rf docs classes test/*.class

Pour générer une documentation,
Il faut se placer dans le dossier racine et lancé un terminal à cet emplecement,
puis éxécuter cette commande :
	"make docs"
		mkdir docs
		javadoc -d docs -cp src/ -subpackages robot

Pour compiler les classes du projet et éxécuter le main,
Il faut se placer dans le dossier racine et lancer un terminal à cet emplecement,
puis éxécuter cette commande :
	==> compiler
	"make compile"
	 	mkdir classes
		javac -sourcepath src src/robot/util/ConveyerBelt.java -d classes
		javac -sourcepath src src/robot/util/Box.java -d classes
		javac -sourcepath src src/robot/Robot.java -d classes

	==> éxécuter
	"make main"
		java -classpath classes robot.Robot

Pour compiler et exécuter les test ,
Il faut se placer dans le dossier racine et lancer un terminal à cet emplecement,
puis éxécuter cette commande :
	==> compiler
	"make compileTest"
		javac -classpath test-1.7.jar test/BoxTest.java
		javac -classpath test-1.7.jar test/RobotTest.java

	==> éxécuter
	"make BoxTest"	pour tester les tests liés à la class Box
		java -jar test-1.7.jar BoxTest
	"make RobotTest" pour tester les tests liés à la class Robot
		java -jar test-1.7.jar RobotTest

Pour compiler et éxécuter un .jar,
Il faut se placer dans le dossier racine et lancer un terminal à cet emplecement,
puis éxécuter cette commande :
	==> compiler
	"make RobotJar_c"
		jar cvfm appli.jar manifest-ex docs test -C classes robot

	==> éxécuter
	"make RobotJar"
		java -classpath appli.jar robot.Robot

Etat du projet:
  - Tp terminé.
  - Nous avons créé un Makefile, les commandes sont renseignés au dessus.
	- Nous avons rencontré un problème lorsque nous mettions test-1.7.jar dans le dossier test, nous n'arrivions plus à compiler les tests.

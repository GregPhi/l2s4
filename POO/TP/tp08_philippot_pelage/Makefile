all: rental docs compileTest

m: main testo

rental:
	rm -rf classes
	mkdir classes
	javac -sourcepath src src/rental/UnknowVehicleException.java -d classes
	javac -sourcepath src src/rental/BrandCriterion.java -d classes
	javac -sourcepath src src/rental/Vehicle.java -d classes
	javac -sourcepath src src/rental/Client.java -d classes
	javac -sourcepath src src/rental/Criterion.java -d classes
	javac -sourcepath src src/rental/InterCriterion.java -d classes
	javac -sourcepath src src/rental/PriceCriterion.java -d classes
	javac -sourcepath src src/rental/RentalAgency.java -d classes
	javac -sourcepath src src/rental/SuspiciousRentalAgency.java -d classes
	javac -sourcepath src src/rental/Car.java -d classes
	javac -sourcepath src src/rental/Motorbike.java -d classes
	javac -sourcepath src src/rental/MainQ2.java -d classes
	javac -sourcepath src src/rental/MainQ5.java -d classes
	javac -sourcepath src src/rental/MainQ7.java -d classes

docs:
	rm -rf docs
	mkdir docs
	javadoc -d docs -cp src/ -subpackages rental

compileTest:
	rm -rf test/rental/*.class
	javac -classpath test-1.7.jar test/rental/*.java

testo: CarTest MotorbikeTest BrandCriterionTest ClientTest InterCriterionTest PriceCriterionTest RentalAgencyTest SuspiciousRentalAgencyTest VehicleTest

CarTest:
	java -jar test-1.7.jar rental.CarTest

MotorbikeTest:
	java -jar test-1.7.jar rental.MotorbikeTest

BrandCriterionTest:
	java -jar test-1.7.jar rental.BrandCriterionTest

ClientTest:
	java -jar test-1.7.jar rental.ClientTest

InterCriterionTest:
	java -jar test-1.7.jar rental.InterCriterionTest

PriceCriterionTest:
	java -jar test-1.7.jar rental.PriceCriterionTest

RentalAgencyTest:
	java -jar test-1.7.jar rental.RentalAgencyTest

SuspiciousRentalAgencyTest:
	java -jar test-1.7.jar rental.SuspiciousRentalAgencyTest

VehicleTest:
	java -jar test-1.7.jar rental.VehicleTest

main:
	make jar
	make mainQ2
	make mainQ5
	make mainQ7

mainQ2:
	java -classpath classes rental.MainQ2
	java -jar MainQ2.jar

jar:
	jar cvfm MainQ2.jar manifest-ex2 docs test -C classes rental
	jar cvfm MainQ5.jar manifest-ex5 docs test -C classes rental
	jar cvfm MainQ7.jar manifest-ex7 docs test -C classes rental

mainQ5:
	java -classpath classes rental.MainQ5
	java -jar MainQ5.jar

mainQ7:
	java -classpath classes rental.MainQ7
	java -jar MainQ7.jar

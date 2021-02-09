JFLAGS=-g
JC=javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGES) $*.java
CLASSES = \
	  User.java \
	  Seat.java \
	  Car.java \
	  CarSeatTable.java \
	  Place.java \
	  PlaceList.java \
	  Ticket.java \
	  SystemKernal.java \
	  main.java 
default: classes
classes:$(CLASSES:.java=.class)

clean:
	$(RM) *.class

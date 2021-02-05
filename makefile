JFLAGS=-g
JC=javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGES) $*.java
CLASSES = \
	  Place.java \
	  SystemKernal.java \
	  main.java
default: classes
classes:$(CLASSES:.java=.class)

clean:
	$(RM) *.class

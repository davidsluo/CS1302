JFLAG = -g
RM = rm
JCLASSDIR = ./build
JC = javac -cp ./libs/junit-4.12.jar -sourcepath ./src
RT = java -cp "./libs/junit-4.12.jar:./libs/hamcrest-core-1.3.jar:./build/" MyStackTester
.SUFFIXES: .java .class
.java.class:
		$(JC) -d $(JCLASSDIR) $(JFLAG) $*.java

CLASSES = \
		src/MyStack/StackADT.java \
		src/MyStack/Stack.java \
		src/MyStack/IntegerStackEmulator.java \
		src/MyStack/Exceptions/FullStackException.java \
		src/MyStack/Exceptions/EmptyStackException.java \
		src/Test/MyStackTester.java \

default: classes test

classes: $(CLASSES:.java=.class)

clean:
	$(RM) $(JCLASSDIR)/*.class

test:
	$(RT)

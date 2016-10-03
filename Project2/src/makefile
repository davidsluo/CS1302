JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
    $(JC) $(JFLAGS) $*.java

CLASSES = \
    PizzaTest.java \
    Pizza.java \
    Appetizer.java \
    Drink.java \
    CustomerOrder.java \
    Order.java \
    PizzaStore.java

default: classes

classes: $(CLASSES:.java=.class)

clean: $(RM) *.class
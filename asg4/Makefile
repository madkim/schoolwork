# Matthew D. Kim & Susan Inha Kim
# madkim
# cmps12b
# 12/8/14
# Makefile
# Makefile for cyoa.java

JAVASRC = cyoa.java
MAINCLASS = cyoa
CLASSES = cyoa.class DoublyLinkedToThePast.class LinkToThePast.class Option.class Room.class

${CLASSES}: ${JAVASRC}
	javac -Xlint ${JAVASRC}

test: all
	javac cyoa.java 
	java cyoa demo.adventure

clean:
	rm ${CLASSES} 

.PHONY: clean all
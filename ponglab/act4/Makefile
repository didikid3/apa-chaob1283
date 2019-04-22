JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Block.java \
	Wall.java \
	Locatable.java \
	Ball.java \
	Collidable.java \
	Paddle.java \
	Score.java \
	Pong.java \
	TheGame.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

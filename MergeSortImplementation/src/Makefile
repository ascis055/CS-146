#
# Makefile for compiling Java project
#
TARGETCLASS = MergeSortImplementation

TARGET = $(TARGETCLASS).jar

OTHERFILES = 

all: $(TARGET)

run: $(TARGET)
	java -jar $<

clean:
	$(RM) $(TARGET) \
	*.class \
	*~

$(TARGET): $(TARGETCLASS).class $(OTHERFILES)
	jar --create --file $@ \
	--main-class $(TARGETCLASS) $^

%.class: %.java
	javac $<

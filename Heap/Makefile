#
# Makefile for compiling Java project
#
TARGETCLASS = Heap
TARGETCLASSPACKAGE = heap

OTHERCLASS1 = WordFreq

TARGETCLASSPACKAGEPATH = $(subst .,/,$(TARGETCLASSPACKAGE))
TARGET = $(TARGETCLASS).jar

OTHERFILES = 

all: $(TARGET)

run: $(TARGET)
	java -jar $<

clean:
	$(RM) $(TARGET) \
	$(TARGETCLASSPACKAGEPATH)/*.class \
	$(TARGETCLASSPACKAGEPATH)/*~

$(TARGET): $(TARGETCLASSPACKAGEPATH)/$(TARGETCLASS).class \
 $(TARGETCLASSPACKAGEPATH)/$(OTHERCLASS1).class
	jar --create --file $@ \
	--main-class $(TARGETCLASSPACKAGE).$(TARGETCLASS) $^

%.class: %.java
	javac $<

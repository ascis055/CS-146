#!/bin/sh
JUNITDIR="/usr/share/java"

if [ "$1" = "" ]; then
    echo "No test class specified" 1>&1
    exit 1
fi
if [ ! -f "${1}.java" ]; then
    echo "Test source file ${1}.java does not exist" 1>&1
    exit 1
fi

javac --class-path "${JUNITDIR}/junit-platform-console-standalone.jar:." \
      "${1}.java" && \
java -jar "${JUNITDIR}/junit-platform-console-standalone.jar" \
     execute --class-path . -c "${1}"
rm -f "${1}.class"

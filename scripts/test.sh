#!/usr/bin/env bash
SOURCE="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

RESULT = echo 5 \
| java -jar $SOURCE/../multiplication/build/libs/multiply-1.0-SNAPSHOT.jar 2 \
| java -jar $SOURCE/../addition/build/libs/addition-1.0-SNAPSHOT.jar 3 \
| java -jar $SOURCE/../subtraction/build/libs/subtraction-1.0-SNAPSHOT.jar 4

echo "Actual $RESULT"
echo "Expected 9=(5*2)+3-4"
#!/usr/bin/env bash
SOURCE="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
java -jar $SOURCE/../addition/build/libs/addition-1.0-SNAPSHOT.jar $@
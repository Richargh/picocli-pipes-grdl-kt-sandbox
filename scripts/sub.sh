#!/usr/bin/env bash
SOURCE="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
java -jar $SOURCE/../subtraction/build/libs/subtraction-1.0-SNAPSHOT.jar $@
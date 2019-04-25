#!/usr/bin/env bash
SOURCE="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
echo $SOURCE
java -jar $SOURCE/../multiplication/build/libs/multiply-1.0-SNAPSHOT.jar $@
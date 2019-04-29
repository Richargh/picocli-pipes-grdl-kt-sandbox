# Sandbox: Kotlin Picocli with pipes

This sandbox attempts to figure out how to build pipepable command line clients in java. Turns out it's not exactly obvious and there are some kinks to work out.

## Usage

First run `./gradlew build`, then you can use the jar in `*/build/libs` like so:

### Direct Usage

* Create a file with test contents: `echo 2 > foo.txt`
* Pipe file contents to the jar: `java -jar addition/build/libs/addition-1.0-SNAPSHOT.jar < foo.txt`
* Pipe file contents to the jar: `cat foo.txt | java -jar addition/build/libs/addition-1.0-SNAPSHOT.jar`

### Script Usage

Use the scripts in the `scripts` folder. Both examples should return 9=(5*2)+3-4

* Pipe multiple scripts in row `echo 5 | ./scripts/mul.sh 2 | ./scripts/add.sh 3 | ./scripts/sub.sh 4`
* Pipe multiple scripts in row `./scripts/test.sh`
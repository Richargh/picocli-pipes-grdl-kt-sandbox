# Sandbox: Kotlin Picocli with pipes

## Usage

Run `./gradlew build`, then you can use the jar in `build/libs` like so:

* Create a file with test contents: `echo "foo\nbar" > foo.txt`
* Pipe file contents to the jar: `java -jar build/libs/sandboxCli-1.0-SNAPSHOT.jar < foo.txt`
* Pipe file contents to the jar: `cat foo.txt | java -jar build/libs/sandboxCli-1.0-SNAPSHOT.jar`


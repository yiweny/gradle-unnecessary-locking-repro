# gradle-unnecessary-locking-repro

This is a repro for an unnecessary locking issue in Gradle 7.4.2, where parallelism is enabled. The project applies the open-source gradle-conjure plugins to its two subprojects.  

Example runs:

```
$ ./gradlew :kuromi-api:publishNewCharacter
Configuration on demand is an incubating feature.

> Task :buildSrc:compileJava
Note: /Volumes/git/yyuan/gradle-unnecessary-locking-repro/buildSrc/src/main/java/cute/characters/ExamplePlugin.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

> Task :kuromi-api:publishNewCharacter FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Could not determine the dependencies of task ':extractConjure'.
> Current thread does not hold the state lock for root project 'gradle-unnecessary-locking-repro'

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.

* Get more help at https://help.gradle.org

Deprecated Gradle features were used in this build, making it incompatible with Gradle 8.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

See https://docs.gradle.org/7.4.2/userguide/command_line_interface.html#sec:command_line_warnings

BUILD FAILED in 4s
3 actionable tasks: 3 executed
```

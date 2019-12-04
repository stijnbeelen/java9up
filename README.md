# JAVA 9 UP

Repository with new features of Java 9, 10, 11, 12 & 13.

## Java 9

[Features](src/main/java/be/infosupport/java9up/java9/Java9Features.java): 
- [new HttpClient & HttpRequest](src/main/java/be/infosupport/java9up/java9/Java9Features.java#L29)
- [Process API improvements](src/main/java/be/infosupport/java9up/java9/Java9Features.java#L49)
- [Killing Processes](src/main/java/be/infosupport/java9up/java9/Java9Features.java#L67)
- [Private interface methods](src/main/java/be/infosupport/java9up/java9/JavaFeatures.java#L8)
- [Collection factory methods](src/main/java/be/infosupport/java9up/java9/Java9Features.java#L86)
- optional class improvements
    - [.stream()](src/main/java/be/infosupport/java9up/java9/Java9Features.java#L141)
    - .ifPresentOrElse()
    - .or()
- [anonymous diamond operators](src/main/java/be/infosupport/java9up/java9/Java9Features.java#L154)
- stream API improvements [see here](https://www.tutorialspoint.com/java9/java9_stream_api_improvements.htm)
    - takeWhile()
    - dropWhile()
    - iterate()
    - ofNullable()
- completable future API improvements
    - delays & timeouts
    - subclassing
    - new factory methods
- improved javadoc
- improved [@Deprecated](src/main/java/be/infosupport/java9up/java9/Java9Features.java#L114)
- Modules
- REPL
- Multi release JAR's
- Garbage collector
- try with resources improvement

## Java 10

[Features](https://www.baeldung.com/java-10-overview):
- [Local variable type inference](https://www.baeldung.com/java-10-local-variable-type-inference)
    - var (compiler infers the type of message from the type of the initializer present on the right-hand side)
    - var is not a keyword
    - no runtime overhead
- Unmodifiable collections
    - [List.copyOf()](https://www.baeldung.com/java-copy-list-to-another)
    - [Set.copyOf()](https://www.baeldung.com/java-copy-sets)
    - Stream.toUnmodifiable()
- optional class improvements
    - .orElseThrow()
- [performance improvements](https://www.baeldung.com/java-10-performance-improvements)
- container awareness
    - `-XX:-UseContainerSupport` disables container awareness
    - `-XX:ActiveProcessorCount=count` specifies the number of CPU's the JVM will use
    - system memory control
        - `-XX:InitialRAMPercentage` 
        - `-XX:MaxRAMPercentage`
        - `-XX:MinRAMPercentage`
- Time-based Release Versioning
    - 1 release each 6 months
    - feature release support will only last 6 months
    - LTS release will be supported for 3 years
- [Graal](https://www.baeldung.com/graal-java-jit-compiler)
    - `-XX:+UnlockExperimentalVMOptions -XX:+UseJVMCICompiler`

## Java 11

Features:
- [launching single-file source-code programs](https://www.baeldung.com/java-single-file-source-code)
- [local variable lambda parameters](https://www.baeldung.com/java-var-lambda-params)
- [String API additions](https://www.baeldung.com/java-11-string-api)
- [Nest based access control](https://www.baeldung.com/java-nest-based-access-control) ???
- [Http client updates](https://www.baeldung.com/java-9-http-client)
- [Epsilon GC](https://www.baeldung.com/jvm-epsilon-gc-garbage-collector)
- [jlink](https://www.baeldung.com/jlink)
- [Predicate.not()](https://www.baeldung.com/java-negate-predicate-method-reference)

Sources:
- [Baeldung](https://github.com/eugenp/tutorials/tree/master/core-java-modules/core-java-11)

## Java 12

Features:
- [String API additions](https://www.baeldung.com/java12-string-api)
- Switch preview
- Number formatting
- Collectors.teeing()

## Java 13

- Text Block Preview
- Switch preview

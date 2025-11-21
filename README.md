# lib-version

A small Maven library that exposes its packaged version at runtime through a VersionUtil class.
The version is loaded from a bundled version.properties file on the classpath.

## Features
### Version Lookup

The library provides:

```java
String version = VersionUtil.getVersion();
```

`VersionUtil` loads `/version.properties` from `src/main/resources` and returns the value of the `version` property, falling back to `"UNKNOWN"` if the file cannot be read.

### Packaged With Maven

The project builds a JAR artifact:
- groupId: `sms`
- artifactId: `lib-version`
- version: `X.Y.Z`

### Released to GitHub Packages

A release workflow (`release.yml`) deploys the library to the GitHub Maven Package Registry when a tag matching `vX.Y.Z` is pushed.

The workflow:
- Checks out the repo
- Sets up JDK 17
- Runs `mvn deploy`
- Publishes using the repo's `${{ secrets.GITHUB_TOKEN }}`
- Uses the version declared in `pom.xml` as the single source of truth

## Usage in Other Projects

Add the GitHub package repository and dependency:

```xml
<dependency>
  <groupId>sms</groupId>
  <artifactId>lib-version</artifactId>
  <version>0.0.4</version>
</dependency>
```

Also check out [documentation](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry) with further instructions on installing Maven packages published to GitHub Packages

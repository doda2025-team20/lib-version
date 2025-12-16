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

### Automated Releases

The project uses GitHub Actions for automated releases to the GitHub Maven Package Registry.

#### Official Release (`release-lib-version.yml`)
- **Trigger:** Manual (`workflow_dispatch`).
- **Process:**
  1. Removes `-SNAPSHOT` from the version in `pom.xml`.
  2. Deploys the artifact to GitHub Packages.
  3. Creates a git tag `vX.Y.Z`.
  4. Bumps the version to the next snapshot (e.g., `0.0.5-SNAPSHOT` -> `0.0.6-SNAPSHOT`).
  5. Pushes the commits and tag back to `main`.

#### Pre-release (`prerelease-lib-version.yml`)
- **Trigger:** Push to any branch except `main`.
- **Process:**
  1. Generates a version based on the branch name and timestamp (e.g., `0.0.5-feature-branch-20231217-120000`).
  2. Deploys the artifact to GitHub Packages.
  3. Does **not** commit changes or create tags.

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

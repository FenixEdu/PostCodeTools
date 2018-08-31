# Post Code Tools


## Overview

This library provides a simple Java API for validating a post code for any country.


## Building

```bash
mvn install
```

## Using

First, add the dependency to the SDK in your project, module or application.
If you use maven, add the following dependency, adjusting the version adequately:

```xml
   <dependency>
      <groupId>org.fenixedu</groupId>
      <artifactId>postCodeTools</artifactId>
      <version>${version.org.fenixedu.postCodeTools}</version>
   </dependency>
```

This artifact is available in the following maven repository:

```xml
    <repositories>
        <repository>
            <id>fenixedu-maven-repository</id>
            <url>https://repo.fenixedu.org/fenixedu-maven-repository</url>
        </repository>
    </repositories>
```

The org.fenixedu.PostalCodeValidator provides a static method for validating post codes.
The method only validates the post code format, not weather the post code actually exists.
The first argument is the ISO 3166 Alfa-2 two letter country code.


## Examples

```java
org.fenixedu.PostalCodeValidator.isValidAreaCode("PT", "1049-001");
org.fenixedu.PostalCodeValidator.isValidAreaCode("ES", "1049-001");
```


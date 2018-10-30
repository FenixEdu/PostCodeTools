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


## Java API

The class org.fenixedu.PostalCodeValidator provides a Java API for validating post code 
formats. This class will also provides an example post code and a "human readable" expected 
format for each country,

```java
public static boolean isValidAreaCode(final String countryCode, final String postCode) { ... }
public static String examplePostCodeFor(final String countryCode) { ... }
public static String formatFor(final String countryCode) { ... }
```


## Examples

In the following invocation, the first call will return true, and the second call will return false:

```java
org.fenixedu.PostalCodeValidator.isValidAreaCode("PT", "1049-001");
org.fenixedu.PostalCodeValidator.isValidAreaCode("ES", "1049-001");
```


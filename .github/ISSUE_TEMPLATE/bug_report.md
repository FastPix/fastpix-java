---
name: Bug Report
about: Report a bug or unexpected behavior in the FastPix Java SDK
title: '[BUG] '
labels: ['bug', 'needs-triage']
assignees: ''
---

# Bug Report

Thank you for taking the time to report a bug with the FastPix Java SDK. To help us resolve your issue quickly and efficiently, please provide the following information:

## Description
**Clear and concise description of the bug:**
```
<!-- Please provide a detailed description of what you're experiencing -->
```

## Environment Information

### System Details
- **Java Version:** [e.g., Java 11, Java 17, Java 21]
- **Operating System:** [e.g., Windows 10, macOS 12.0, Ubuntu 20.04, etc.]
- **Build Tool:** [e.g., Maven, Gradle]
- **IDE:** [e.g., IntelliJ IDEA, Eclipse, VS Code, etc.] (Optional but helpful)

### SDK Information
- **FastPix Java SDK Version:** [e.g., 1.0.3, 1.0.2, etc.]
- **Java Runtime:** [e.g., OpenJDK, Oracle JDK, etc.]

## Reproduction Steps

1. **Setup Environment:**
   ```xml
   <!-- Maven -->
   <dependency>
       <groupId>com.fastpix</groupId>
       <artifactId>fastpix-java</artifactId>
       <version>1.0.0</version>
   </dependency>
   ```
   ```gradle
   // Gradle
   implementation 'com.fastpix:fastpix-java:1.0.0'
   ```

2. **Code to Reproduce:**
   ```java
   // Please provide a minimal, reproducible example
   import com.fastpix.FastpixSDK;
   import com.fastpix.models.components.Security;

   public class Example {
       public static void main(String[] args) {
           FastpixSDK fastpix = FastpixSDK.builder()
               .security(Security.builder()
                   .username("your-username")
                   .password("your-password")
                   .build())
               .build();
           
           // Your code here that causes the issue
       }
   }
   ```

3. **Expected Behavior:**

    ```
    <!-- Describe what you expected to happen -->
    ```

4. **Actual Behavior:**

    ```
    <!-- Describe what actually happened -->
    ```

5. **Error Messages/Logs:**
   ```
   <!-- Paste any error messages, stack traces, or logs here -->
   ```

## Debugging Information

### Console Output
```
<!-- Paste the complete console output here -->
```

### Error Stack Traces
```java
// Complete stack trace for Java errors
Exception in thread "main" java.lang.NullPointerException
    at com.fastpix.SomeClass.someMethod(SomeClass.java:123)
    at com.yourpackage.YourClass.yourMethod(YourClass.java:45)
    at com.yourpackage.YourClass.main(YourClass.java:12)
```

### HTTP Requests
```http
# Raw HTTP request (remove sensitive headers and credentials)
POST /api/endpoint HTTP/1.1
Host: [FastPix API endpoint]
Authorization: Basic ***
Content-Type: application/json

<!-- Remove credentials and sensitive headers before pasting -->
```

### Screenshots
```
<!-- If applicable, please attach screenshots that help explain your issue -->
```

## Additional Context

### Configuration
```java
// Please share your SDK configuration (remove sensitive information)
FastpixSDK fastpix = FastpixSDK.builder()
    .security(Security.builder()
        .username("***") // Redacted
        .password("***") // Redacted
        .build())
    // Any other configuration options
    .build();
```

### Build Configuration
- **Maven/Gradle Version:** [e.g., Maven 3.8, Gradle 7.5]
- **Project Structure:** [e.g., Standard Maven/Gradle project]

### Workarounds
```
<!-- If you've found any workarounds, please describe them here -->
```

## Priority
Please indicate the priority of this bug:

- [ ] Critical (Blocks production use)
- [ ] High (Significant impact on functionality)
- [ ] Medium (Minor impact)
- [ ] Low (Nice to have)

## Checklist
Before submitting, please ensure:

- [ ] I have searched existing issues to avoid duplicates
- [ ] I have provided all required information
- [ ] I have tested with the latest SDK version
- [ ] I have removed any sensitive information (credentials, API keys, etc.)
- [ ] I have provided a minimal reproduction case
- [ ] I have checked the documentation

---

**Thank you for helping improve the FastPix Java SDK! 🚀**


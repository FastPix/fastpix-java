---
name: Question/Support
about: Ask questions or get help with the FastPix Java SDK
title: '[QUESTION] '
labels: ['question', 'needs-triage']
assignees: ''
---

# Question/Support

Thank you for reaching out! We're here to help you with the FastPix Java SDK. Please provide the following information:

## Question Type
- [ ] How to use a specific feature
- [ ] Integration help
- [ ] Configuration question
- [ ] Performance question
- [ ] Troubleshooting help
- [ ] Threading/concurrency
- [ ] Error handling
- [ ] Spring Boot integration
- [ ] Other: _______________

## Question
**What would you like to know?**
```
<!-- Please provide a clear, specific question -->
```
## What You've Tried
**What have you already attempted to solve this?**

```java
// Please share any code you've tried
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
        
        // Your attempted code here
    }
}
```

## Current Setup
**Describe your current setup:**

### Environment
- **Java Version:** [e.g., Java 11, Java 17, Java 21]
- **Operating System:** [e.g., Windows 10, macOS 12.0, Ubuntu 20.04, etc.]
- **FastPix Java SDK Version:** [e.g., 1.0.3, 1.0.2]
- **Build Tool:** [e.g., Maven, Gradle]
- **IDE:** [e.g., IntelliJ IDEA, Eclipse, VS Code, etc.]

### Configuration
```java
// Your current SDK configuration (remove sensitive information)
FastpixSDK fastpix = FastpixSDK.builder()
    .security(Security.builder()
        .username("***") // Redacted
        .password("***") // Redacted
        .build())
    // Any other configuration
    .build();
```

## Expected Outcome
**What are you trying to achieve?**
```
<!-- Describe your end goal -->
```
## Error Messages (if any)
```
<!-- If you're getting errors, paste them here -->
```

## Additional Context

### Use Case
**What are you building?**

- [ ] Web application (Spring Boot)
- [ ] REST API service
- [ ] Microservice
- [ ] Desktop application
- [ ] Library/package
- [ ] Other: _______________

### Project Details
- **Project Type:** [e.g., Spring Boot, Maven project, Gradle project, etc.]
- **Framework:** [e.g., Spring Boot, Quarkus, Micronaut, etc.]

### Timeline
**When do you need this resolved?**

- [ ] ASAP (blocking development)
- [ ] This week
- [ ] This month
- [ ] No rush

### Resources Checked
**What resources have you already checked?**

- [ ] README.md
- [ ] Documentation
- [ ] Examples
- [ ] Stack Overflow
- [ ] GitHub Issues
- [ ] Java documentation
- [ ] Other: _______________

## Priority
Please indicate the urgency:

- [ ] Critical (Blocking production deployment)
- [ ] High (Blocking development)
- [ ] Medium (Would like to know soon)
- [ ] Low (Just curious)

## Checklist
Before submitting, please ensure:

- [ ] I have provided a clear question
- [ ] I have described what I've tried
- [ ] I have included my current setup
- [ ] I have checked existing documentation
- [ ] I have provided sufficient context
- [ ] I have removed any sensitive information (credentials, API keys, etc.)

---

**We'll do our best to help you get unstuck! 🚀**

**For urgent issues, please also consider:**
- [FastPix Documentation](https://docs.fastpix.io/)
- [Stack Overflow](https://stackoverflow.com/questions/tagged/fastpix)
- [GitHub Discussions](https://github.com/FastPix/java-language-sdk-server-side/discussions)


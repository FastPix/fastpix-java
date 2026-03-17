# What Will Print If You Copy-Paste That Code?

## Answer: **NOTHING** ❌

The code you provided has **no print statements**, so it will run silently and produce **zero output**.

### What the Code Does:

```java
if (res.object().isPresent()) {
    // handle response  <-- This is just a comment, does nothing!
}
```

### What Actually Happens:

1. ✅ SDK initializes (silently)
2. ✅ API call executes (silently)  
3. ✅ Response is checked (silently)
4. ❌ **Nothing is printed** - the `if` block is empty except for a comment

### If Credentials Are Wrong:

You'll get an **exception** printed to stderr:
```
Exception in thread "main" io.fastpix.sdk.models.errors.AuthException: ...
```

### To See Output, Add Print Statements:

```java
if (res.object().isPresent()) {
    // handle response
    var responseBody = res.object().get();
    System.out.println("✅ Direct upload request created!");
    System.out.println("Response: " + responseBody);
    
    if (responseBody.data() != null && responseBody.data().isPresent()) {
        var uploadData = responseBody.data().get();
        if (uploadData.url().isPresent()) {
            System.out.println("📤 Upload URL: " + uploadData.url().get());
        }
    }
} else {
    System.out.println("❌ No response");
}
```

---

**Summary:** The code runs but prints **nothing** because there are no `System.out.println()` statements.


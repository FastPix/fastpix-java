# How to Run CreateMediaExample

## Prerequisites

1. **Publish SDK to Maven Local** (if not already done):
   ```bash
   cd /Users/sravanimaramreddy/Downloads/maven-publish-java
   ./gradlew publishToMavenLocal --no-daemon
   ```

2. **Set Environment Variables**:
   ```bash
   export FASTPIX_ACCESS_TOKEN='your-access-token'
   export FASTPIX_SECRET_KEY='your-secret-key'
   ```

## Running the Example

### Option 1: Using Gradle (Recommended) ✅

```bash
cd test-example
export FASTPIX_ACCESS_TOKEN='your-access-token'
export FASTPIX_SECRET_KEY='your-secret-key'
./gradlew run
```

### Option 2: One-liner with Environment Variables

```bash
cd test-example
FASTPIX_ACCESS_TOKEN='your-token' FASTPIX_SECRET_KEY='your-key' ./gradlew run
```

### Option 3: Using Java Directly

```bash
cd test-example
export FASTPIX_ACCESS_TOKEN='your-access-token'
export FASTPIX_SECRET_KEY='your-secret-key'
./gradlew build
java -cp "build/classes/java/main:$(./gradlew -q printClasspath)" com.fastpix.example.CreateMediaExample
```

## What the Example Does

1. **Initializes the SDK** with your credentials from environment variables
2. **Lists media** from your FastPix workspace
3. **Prints formatted JSON** response showing:
   - Up to 20 media items
   - Sorted in descending order
   - Pretty-printed with indentation

## Expected Output

```json
{
  "data" : [ {
    "id" : "...",
    "status" : "...",
    "createdAt" : "...",
    ...
  } ],
  ...
}
```

## Troubleshooting

### Error: "package io.fastpix.sdk does not exist"
- **Solution**: Run `./gradlew publishToMavenLocal` in the parent directory first

### Error: "FASTPIX_ACCESS_TOKEN and FASTPIX_SECRET_KEY environment variables must be set"
- **Solution**: Set the environment variables before running:
  ```bash
  export FASTPIX_ACCESS_TOKEN='your-token'
  export FASTPIX_SECRET_KEY='your-key'
  ```

### Error: "Authentication failed"
- **Solution**: Verify your credentials are correct and have proper permissions


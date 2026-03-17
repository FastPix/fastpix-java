# Test Example: Create Media from URL

This example demonstrates how to use the FastPix SDK locally to create media from a URL.

## Prerequisites

1. **SDK Published Locally**
   ```bash
   cd /path/to/maven-publish-java
   ./gradlew publishToMavenLocal
   ```

2. **FastPix Credentials**
   - Access Token
   - Secret Key

## Setup

1. **Set Environment Variables**
   ```bash
   export FASTPIX_ACCESS_TOKEN='your-access-token'
   export FASTPIX_SECRET_KEY='your-secret-key'
   ```

2. **Run the Example**
   ```bash
   cd test-example
   ./gradlew run
   ```

   Or if you don't have gradlew in test-example:
   ```bash
   cd test-example
   gradle run
   ```

## What This Example Does

1. Initializes the FastPix SDK with your credentials
2. Creates a media request with a sample video URL
3. Calls the `createMedia` API
4. Displays the created media ID and status

## Expected Output

```
✅ SDK initialized successfully
Creating media from URL...

✅ Media created successfully!
Media ID: <media-id>
Status: <status>

You can now use this media ID for other operations:
  - Get media details: sdk.manageVideos().get().id(mediaId).call()
  - List all media: sdk.manageVideos().list().call()
```

## Troubleshooting

### SDK Not Found
If you get "Could not resolve: io.fastpix:sdk:1.0.0", make sure:
- You've run `./gradlew publishToMavenLocal` in the parent directory
- The version matches (1.0.0)

### Authentication Error
If you get authentication errors:
- Verify your credentials are correct
- Check that environment variables are set: `echo $FASTPIX_ACCESS_TOKEN`

### Network Error
If you get network errors:
- Check your internet connection
- Verify the FastPix API endpoint is accessible


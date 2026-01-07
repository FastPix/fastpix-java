# AiFeatures

## Overview

### Available Operations

* [updateMediaSummary](#updatemediasummary) - Generate video summary

## updateMediaSummary

This endpoint allows you to generate the summary for an existing media.

#### How it works
1. Send a `PATCH` request to this endpoint, replacing `<mediaId>` with the ID of the media you want to summarize.
2. Include the `generate` parameter in the request body.
3. Include the `summaryLength` parameter, specify the desired length of the summary in words (for example, 120 words), this determines how concise or detailed the summary will be. If no specific summary length is provided, the default length will be 100 words.
4. The response includes the updated media data and confirmation of the changes applied.

You can use the <a href="https://docs.fastpix.io/docs/ai-events#videomediaaisummaryready">video.mediaAI.summary.ready</a> webhook event to track and notify about the summary generation.





**Use case**: This is particularly useful when a user uploads a video and later chooses to generate a summary without needing to re-upload the video.

Related guide: <a href="https://docs.fastpix.io/docs/generate-video-summary">Video summary</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="update-media-summary" method="patch" path="/on-demand/{mediaId}/summary" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.UpdateMediaSummaryRequestBody;
import org.openapis.openapi.models.operations.UpdateMediaSummaryResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdateMediaSummaryResponse res = sdk.aiFeatures().updateMediaSummary()
                .mediaId("your-media-id")
                .body(UpdateMediaSummaryRequestBody.builder()
                    .generate(true)
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `mediaId`                                                                                  | *String*                                                                                   | :heavy_check_mark:                                                                         | The unique identifier assigned to the media when created. The value must be a valid UUID.<br/> | your-media-id                                                                               |
| `body`                                                                                     | [UpdateMediaSummaryRequestBody](../../models/operations/UpdateMediaSummaryRequestBody.md)  | :heavy_check_mark:                                                                         | N/A                                                                                        | {<br/>"generate": true,<br/>"summaryLength": 100<br/>}                                     |

### Response

**[UpdateMediaSummaryResponse](../../models/operations/UpdateMediaSummaryResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |
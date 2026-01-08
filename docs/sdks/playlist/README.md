# Playlist

## Overview

Operations for playlist management

### Available Operations

* [updateMediaOrder](#updatemediaorder) - Change media order in a playlist by ID
* [removeMedia](#removemedia) - Delete media in a playlist by ID

## updateMediaOrder

This endpoint allows you to change the order of media items within a playlist. By passing the complete list of media IDs in the desired sequence, the playlist's play order is updated accordingly.
#### How it works

 - When a user sends a PUT request to this endpoint with the `playlistId` as path parameter and the reordered list of all media IDs in the request body, FastPix updates the playlist to reflect the new media sequence and returns the updated playlist details.

#### Example
An e-learning platform rearranges the "Beginner Python Series" playlist by submitting a reordered list of media IDs. The playlist now follows the new sequence, providing learners with a better structured learning path.

### Example Usage

<!-- UsageSnippet language="java" operationID="change-media-order-in-playlist" method="put" path="/on-demand/playlists/{playlistId}/media" -->
```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.MediaIdsRequest;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.ChangeMediaOrderInPlaylistResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        ChangeMediaOrderInPlaylistResponse res = sdk.playlist().updateMediaOrder()
                .playlistId("<id>")
                .body(MediaIdsRequest.builder()
                    .mediaIds(List.of(
                        "your-media-id-1",
                        "your-media-id-2",
                        "your-media-id-3"))
                    .build())
                .call();

        if (res.playlistByIdResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `playlistId`                                                        | *String*                                                            | :heavy_check_mark:                                                  | The unique id of the playlist you want to perform the operation on. |
| `body`                                                              | [MediaIdsRequest](../../models/components/MediaIdsRequest.md)       | :heavy_check_mark:                                                  | N/A                                                                 |

### Response

**[ChangeMediaOrderInPlaylistResponse](../../models/operations/ChangeMediaOrderInPlaylistResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## removeMedia

This endpoint allows you to delete one or more media items from an existing playlist. By passing the media ID(s) in the request, the specified media items are removed from the playlist.
#### How it works

 - When a user sends a DELETE request to this endpoint with the playlist ID as the path parameter and the media ID(s) to be removed in the request body, FastPix deletes the specified media items from the playlist and returns the updated playlist details.

#### Example
An e-learning platform removes outdated video tutorials from the "Beginner Python Series" playlist by specifying their media IDs in the request. The playlist is updated to exclude these items, ensuring learners only access relevant content.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-media-from-playlist" method="delete" path="/on-demand/playlists/{playlistId}/media" -->
```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.MediaIdsRequest;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.DeleteMediaFromPlaylistResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        DeleteMediaFromPlaylistResponse res = sdk.playlist().removeMedia()
                .playlistId("<id>")
                .body(MediaIdsRequest.builder()
                    .mediaIds(List.of(
                        "your-media-id-1",
                        "your-media-id-2",
                        "your-media-id-3"))
                    .build())
                .call();

        if (res.playlistByIdResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                | Type                                                                     | Required                                                                 | Description                                                              |
| ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ |
| `playlistId`                                                             | *String*                                                                 | :heavy_check_mark:                                                       | The unique id of the playlist you want to perform the operation on.      |
| `body`                                                                   | [Optional\<MediaIdsRequest>](../../models/components/MediaIdsRequest.md) | :heavy_minus_sign:                                                       | N/A                                                                      |

### Response

**[DeleteMediaFromPlaylistResponse](../../models/operations/DeleteMediaFromPlaylistResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |
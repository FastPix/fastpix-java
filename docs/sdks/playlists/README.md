# Playlists

## Overview

### Available Operations

* [create](#create) - Create a new playlist
* [list](#list) - Get all playlists
* [get](#get) - Get a playlist by ID
* [update](#update) - Update a playlist by ID
* [delete](#delete) - Delete a playlist by ID
* [addMedia](#addmedia) - Add media to a playlist by ID

## create

This endpoint creates a new playlist within a specified workspace. A playlist acts as a container for organizing media items either manually or based on filters and metadata. <br> <br>
### Playlists can be created in two modes
- **Manual:** Creates an empty playlist without any initial media items. Use this mode for manual curation, where you add items later in a user-defined sequence.
- **Smart:** Auto-populates the playlist at creation time based on the filter criteria (for example, a video creation date range) that you provide in the request.

For more details, see <a href="https://docs.fastpix.io/docs/create-and-manage-playlist">Create and manage playlist</a>.

#### How it works 

 - When you send a `POST` request to this endpoint, FastPix creates a playlist and returns a playlist ID, using which items can be added later in a user-defined sequence.
 - You can create a smart playlist that is auto-populated based on the metadata in the request body.


#### Example
An e-learning platform creates a new playlist titled Beginner Python Series through the API. The response returns a unique playlist ID. The platform uses this ID to add a series of video tutorials to the playlist in a defined order. The playlist appears on the frontend as a structured learning path for learners.

> **Note:** In the examples below, `package hello.world;` is used for demonstration purposes. When creating your own Java files, ensure the package name matches your directory structure (e.g., if your file is at `src/main/java/com/example/MyApp.java`, use `package com.example;`).

### Example Usage

<!-- UsageSnippet language="java" operationID="create-a-playlist" method="post" path="/on-demand/playlists" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.*;
import io.fastpix.sdk.models.operations.CreateAPlaylistResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        CreatePlaylistRequest req = CreatePlaylistRequestSmart.builder()
                .name("playlist name")
                .referenceId("a1")
                .type(CreatePlaylistRequestSmartType.SMART)
                .playOrder(PlaylistOrder.CREATED_DATE_ASC)
                .metadata(Metadata.builder()
                    .createdDate(DateRange.builder()
                        .startDate("your-start-date") // Example 2024-11-11
                        .endDate("your-end-date") // Example 2024-11-11
                        .build())
                    .updatedDate(DateRange.builder()
                        .startDate("your-start-date") //Example 2024-11-11
                        .endDate("your-end-date") //Example 2024-12-12
                        .build())
                    .build())
                .description("your-playlist-description")
                .limit(20L)
                .build();

        CreateAPlaylistResponse res = sdk.playlists().create()
                .request(req)
                .call();

        if (res.playlistCreatedResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.playlistCreatedResponse().get()));
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [CreatePlaylistRequest](../../models/shared/CreatePlaylistRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[CreateAPlaylistResponse](../../models/operations/CreateAPlaylistResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

This endpoint retrieves all playlists in a specified workspace. It allows you to view the collection of manual and smart playlists along with their associated metadata.
#### How it works

 - When a user sends a GET request to this endpoint, FastPix returns a list of all playlists in the workspace, including details such as playlist IDs, titles, creation mode (manual or smart), and other relevant metadata.

#### Example

  An e-learning platform requests all playlists within a workspace to display an overview of available learning paths. The response includes multiple playlists like "Beginner Python Series" and "Advanced Java Tutorials," enabling the platform to show users a catalog of curated content collections.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-all-playlists" method="get" path="/on-demand/playlists" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.GetAllPlaylistsResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GetAllPlaylistsResponse res = sdk.playlists().list()
                .limit(1L)
                .offset(1L)
                .call();

        if (res.getAllPlaylistsResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.getAllPlaylistsResponse().get()));
        }
    }
}
```

### Parameters

| Parameter                                                                                          | Type                                                                                               | Required                                                                                           | Description                                                                                        | Example                                                                                            |
| -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- |
| `limit`                                                                                            | *Optional\<Long>*                                                                                  | :heavy_minus_sign:                                                                                 | The number of playlists to return (default is 10, max is 50).                                      | 1                                                                                                  |
| `offset`                                                                                           | *Optional\<Long>*                                                                                  | :heavy_minus_sign:                                                                                 | The page number to retrieve, starting from 1. Use this parameter to paginate the playlist results. | 1                                                                                                  |

### Response

**[GetAllPlaylistsResponse](../../models/operations/GetAllPlaylistsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## get

This endpoint retrieves detailed information about a specific playlist using its unique `playlistId`. It provides comprehensive metadata about the playlist, including its title, creation mode (manual or smart), media items along with the metadata of each media in the playlist.


#### Example
An e-learning platform requests details for the playlist "Beginner Python Series" by providing its unique `playlistId`. The response includes the playlist"s title, creation mode, and the ordered list of video tutorials contained within, enabling the platform to present the full learning path to users.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-playlist-by-id" method="get" path="/on-demand/playlists/{playlistId}" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.GetPlaylistByIdResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GetPlaylistByIdResponse res = sdk.playlists().get()
                .playlistId("<id>")
                .call();

        if (res.playlistByIdResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.playlistByIdResponse().get()));
        }
    }
}
```

### Parameters

| Parameter                                           | Type                                                | Required                                            | Description                                         |
| --------------------------------------------------- | --------------------------------------------------- | --------------------------------------------------- | --------------------------------------------------- |
| `playlistId`                                        | *String*                                            | :heavy_check_mark:                                  | The unique id of the playlist you want to retrieve. |

### Response

**[GetPlaylistByIdResponse](../../models/operations/GetPlaylistByIdResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## update

This endpoint allows you to update the name and description of an existing playlist. It enables modifications to the playlist's metadata without altering the media items or playlist structure.
#### How it works

 - When a user sends a PUT request to this endpoint with the `playlistId` and updated name and description in the request body, FastPix updates the playlist metadata accordingly and returns the updated playlist details.

#### Example
An e-learning platform updates the playlist titled "Beginner Python Series" to rename it as "Python Basics" and add a more detailed description. The updated metadata is reflected when retrieving the playlist, helping users better understand the playlist content.

### Example Usage

<!-- UsageSnippet language="java" operationID="update-a-playlist" method="put" path="/on-demand/playlists/{playlistId}" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.UpdatePlaylistRequest;
import io.fastpix.sdk.models.operations.UpdateAPlaylistResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdateAPlaylistResponse res = sdk.playlists().update()
                .playlistId("<id>")
                .body(UpdatePlaylistRequest.builder()
                    .name("updated name")
                    .description("updated description")
                    .build())
                .call();

        if (res.playlistCreatedResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.playlistCreatedResponse().get()));
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               | Example                                                                   |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `playlistId`                                                              | *String*                                                                  | :heavy_check_mark:                                                        | The unique id of the playlist you want to retrieve.                       |                                                                           |
| `body`                                                                    | [UpdatePlaylistRequest](../../models/components/UpdatePlaylistRequest.md) | :heavy_check_mark:                                                        | N/A                                                                       | {<br/>"name": "updated name",<br/>"description": "updated description"<br/>} |

### Response

**[UpdateAPlaylistResponse](../../models/operations/UpdateAPlaylistResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

This endpoint allows you to delete an existing playlist from the workspace. After deleted, the playlist and its metadata are permanently removed and cannot be recovered.
#### How it works
 - When a user sends a DELETE request to this endpoint with the `playlistId`, FastPix removes the specified playlist from the workspace and returns a confirmation of successful deletion.

#### Example
An e-learning platform deletes an outdated playlist titled "Old Python Tutorials" by providing its unique playlist ID. The platform receives confirmation that the playlist has been removed, ensuring learners no longer see the obsolete content.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-a-playlist" method="delete" path="/on-demand/playlists/{playlistId}" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.DeleteAPlaylistResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        DeleteAPlaylistResponse res = sdk.playlists().delete()
                .playlistId("<id>")
                .call();

        if (res.playlistDeleteResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.playlistDeleteResponse().get()));
        }
    }
}
```

### Parameters

| Parameter                                         | Type                                              | Required                                          | Description                                       |
| ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| `playlistId`                                      | *String*                                          | :heavy_check_mark:                                | The unique id of the playlist you want to delete. |

### Response

**[DeleteAPlaylistResponse](../../models/operations/DeleteAPlaylistResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## addMedia

This endpoint allows you to add one or more media items to an existing playlist. By passing the media ID(s) in the request, the specified media items are appended to the playlist in the order provided.
#### How it works

 - When a user sends a PATCH request to this endpoint with the `playlistId` as path parameter and a list of media ID(s) in the request body, FastPix adds the specified media items to the playlist and returns the updated playlist details.

#### Example
An e-learning platform adds new video tutorials to the "Beginner Python Series" playlist by sending their media IDs in the request. The playlist is updated with the new content, ensuring learners have access to the latest tutorials in sequence.

### Example Usage

<!-- UsageSnippet language="java" operationID="add-media-to-playlist" method="patch" path="/on-demand/playlists/{playlistId}/media" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.List;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.MediaIdsRequest;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.AddMediaToPlaylistResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        AddMediaToPlaylistResponse res = sdk.playlists().addMedia()
                .playlistId("your-playlist-id")
                .body(MediaIdsRequest.builder()
                    .mediaIds(List.of(
                        "your-media-id-1",
                        "your-media-id-2",
                        "your-media-id-3"))
                    .build())
                .call();

        if (res.playlistByIdResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.playlistByIdResponse().get()));
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

**[AddMediaToPlaylistResponse](../../models/operations/AddMediaToPlaylistResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |
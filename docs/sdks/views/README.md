# Views

## Overview

Operations involving views

### Available Operations

* [list](#list) - List video views
* [getDetails](#getdetails) - Get details of video view
* [listByTopContent](#listbytopcontent) - List by top content

## list

Retrieves a list of video views that fall within the specified filters and have been completed within a defined timespan. It lets you to analyse viewer interactions with your video content effectively. 


#### How it works

  1. Send a `GET` request to this endpoint with the desired query parameters. 

  2. Specify the timespan for which you want to retrieve the video views using the `timespan[]` parameter. 

  3. Filter the views based on dimensions such as browser, device, video title, viewer ID, etc., using the `filterby[]` parameter. Get the dimensions by calling <a href="https://docs.fastpix.io/reference/list_dimensions">list the dimensions</a> endpoint. 

  4. Paginate the results using the `limit` and `offset` parameters. 

  5. You can also filter by `viewerId`, `errorCode`, `orderBy` a specific field, and `sortOrder` in ascending or descending order. 

  6. You receive a response containing the list of video views matching the specified criteria.

Each view in the response includes a unique `viewId`. You can use this `viewId` with the  <a href="https://docs.fastpix.io/reference/get_video_view_details">Get Video View Details</a> endpoint to retrieve more detailed information about that specific view.


#### Example

If you manage a video streaming service and want to analyze content performance across devices and browsers. By calling the List Video Views endpoint with filters such as `browser_name` and `device_type`, you can identify which platforms are most popular with your audience. This information helps optimize content for widely used platforms and troubleshoot playback issues on less common devices.


  Related guide: <a href="https://docs.fastpix.io/docs/audience-metrics">Audience metrics</a>, <a href="https://docs.fastpix.io/docs/understand-dashboard-ui#1-views-dashboard">Views dashboard</a>

### Example Usage

<!-- UsageSnippet language="java" operationID="list_video_views" method="get" path="/data/viewlist" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.*;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        ListVideoViewsRequest req = ListVideoViewsRequest.builder()
                .timespan(ListVideoViewsTimespan.TWENTY_FOURHOURS)
                .filterby("browser_name:Chrome")
                .viewerId("your-viewer-id")
                .errorCode("1002")
                .build();

        ListVideoViewsResponse res = sdk.views().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [ListVideoViewsRequest](../../models/operations/ListVideoViewsRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[ListVideoViewsResponse](../../models/operations/ListVideoViewsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getDetails

Retrieves detailed information about a specific video view using its unique `viewId`. This provides insights into individual viewer interactions with your video content, helping you enhance user experience and improve engagement with your videos. 

To use this endpoint, send `GET` request with the `viewId`. The response includes detailed metrics and attributes related to the specified video view. 


#### Example

If a developer receives a report of a poor viewing experience for a specific user. By using this endpoint with the users `viewId`, the developer can retrieve metrics like buffering duration, playback errors, and session length. This data allows the developer to pinpoint issues (such as poor connectivity or a browser-specific problem) and take steps to improve the user experience.


Related guide: <a href="https://docs.fastpix.io/page/what-video-data-do-we-capture#/">What Video Data do we capture?</a>

### Example Usage

<!-- UsageSnippet language="java" operationID="get_video_view_details" method="get" path="/data/viewlist/{viewId}" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.GetVideoViewDetailsResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GetVideoViewDetailsResponse res = sdk.views().getDetails()
                .viewId("<id>")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter          | Type               | Required           | Description        |
| ------------------ | ------------------ | ------------------ | ------------------ |
| `viewId`           | *String*           | :heavy_check_mark: | Pass View Id       |

### Response

**[GetVideoViewDetailsResponse](../../models/operations/GetVideoViewDetailsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## listByTopContent

Retrieves a list of the top video views that fall within the specified filters and have been completed within a defined timespan. It lets you to identify the most popular content based on viewer interactions. 

#### How it works

  1. Send a `GET` request to this endpoint with the desired query parameters. 

  2. Specify the timespan for which you want to retrieve the top content using the `timespan[]` parameter. 

  3. Filter the views based on dimensions such as browser, device, video title, etc., using the `filterby[]` parameter. 

  4. You can use `Limit` to control number of top views returned. 

  5. You receive a response containing the list of top video views matching the specified criteria.


  Related guide: <a href="https://docs.fastpix.io/page/how-to-get-top-performing-content">Get top-performing content</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="list_by_top_content" method="get" path="/data/viewlist/top-content" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.ListByTopContentResponse;
import org.openapis.openapi.models.operations.ListByTopContentTimespan;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        ListByTopContentResponse res = sdk.views().listByTopContent()
                .timespan(ListByTopContentTimespan.TWENTY_FOURHOURS)
                .filterby("browser_name:Chrome")
                .limit(10L)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                                                         | Type                                                                                                                                                                                                                                                                                                                                                                                                                              | Required                                                                                                                                                                                                                                                                                                                                                                                                                          | Description                                                                                                                                                                                                                                                                                                                                                                                                                       | Example                                                                                                                                                                                                                                                                                                                                                                                                                           |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `timespan`                                                                                                                                                                                                                                                                                                                                                                                                                        | [Optional\<ListByTopContentTimespan>](../../models/operations/ListByTopContentTimespan.md)                                                                                                                                                                                                                                                                                                                                        | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                | This parameter specifies the time span between which the video views list must be retrieved by. You can provide either from and to unix epoch timestamps or time duration. The scope of duration is between 60 minutes to 30 days.<br/><br/>**Accepted formats are:**<br/><br/>array of epoch timestamps for example  <br/>`timespan[]=1498867200&timespan[]=1498953600`<br/><br/>duration string for example  <br/>`timespan[]=24:hours` or `timespan[]=7:days`<br/> | 24:hours                                                                                                                                                                                                                                                                                                                                                                                                                          |
| `filterby`                                                                                                                                                                                                                                                                                                                                                                                                                        | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                | Pass the dimensions and their corresponding values you want to filter the views by. For excluding the values in the filter we can pass "!" before the filter value. The list of filters can be obtained from list of dimensions endpoint.<br/>Example Values : [ browser_name:Chrome , os_name:macOS , !device_name:Galaxy ]<br/>                                                                                                 | browser_name:Chrome                                                                                                                                                                                                                                                                                                                                                                                                               |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                                                           | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                | Pass the limit to display only the rows specified by the value.<br/>                                                                                                                                                                                                                                                                                                                                                              | 10                                                                                                                                                                                                                                                                                                                                                                                                                                |

### Response

**[ListByTopContentResponse](../../models/operations/ListByTopContentResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |
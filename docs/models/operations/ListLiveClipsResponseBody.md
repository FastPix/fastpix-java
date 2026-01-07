# ListLiveClipsResponseBody

List of video media


## Fields

| Field                                                                          | Type                                                                           | Required                                                                       | Description                                                                    | Example                                                                        |
| ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ |
| `success`                                                                      | *Optional\<Boolean>*                                                           | :heavy_minus_sign:                                                             | Demonstrates whether the request is successful or not.                         | true                                                                           |
| `data`                                                                         | List\<[LiveMediaClips](../../models/components/LiveMediaClips.md)>             | :heavy_minus_sign:                                                             | Displays the result of the request.                                            |                                                                                |
| `pagination`                                                                   | [Optional\<Pagination>](../../models/components/Pagination.md)                 | :heavy_minus_sign:                                                             | Pagination organizes content into pages for better readability and navigation. |                                                                                |
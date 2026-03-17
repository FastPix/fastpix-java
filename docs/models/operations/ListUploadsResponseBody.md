# ListUploadsResponseBody

List of video media


## Fields

| Field                                                                          | Type                                                                           | Required                                                                       | Description                                                                    | Example                                                                        |
| ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ |
| `success`                                                                      | *Optional\<Boolean>*                                                           | :heavy_minus_sign:                                                             | Shows the request status. Returns true for success and false for failure.      | true                                                                           |
| `data`                                                                         | List\<[UnusedDirectUpload](../../models/components/UnusedDirectUpload.md)>     | :heavy_minus_sign:                                                             | Displays the result of the request.                                            |                                                                                |
| `pagination`                                                                   | [Optional\<Pagination>](../../models/components/Pagination.md)                 | :heavy_minus_sign:                                                             | Pagination organizes content into pages for better readability and navigation. |                                                                                |
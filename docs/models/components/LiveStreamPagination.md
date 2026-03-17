# LiveStreamPagination

Pagination organizes content into pages for better readability and navigation.


## Fields

| Field                                                                    | Type                                                                     | Required                                                                 | Description                                                              | Example                                                                  |
| ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ |
| `totalRecords`                                                           | *Optional\<Long>*                                                        | :heavy_minus_sign:                                                       | It gives the total number of media assets that are accessible overall.   | 12                                                                       |
| `currentOffset`                                                          | *Optional\<Long>*                                                        | :heavy_minus_sign:                                                       | Determines the current point for data retrieval within a paginated list. | 5                                                                        |
| `offsetCount`                                                            | *Optional\<Long>*                                                        | :heavy_minus_sign:                                                       | The offset count is expressed as total records by limit.                 | 2                                                                        |
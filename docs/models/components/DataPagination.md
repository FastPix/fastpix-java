# DataPagination

Pagination organizes content into pages for better readability and navigation.


## Fields

| Field                                                       | Type                                                        | Required                                                    | Description                                                 | Example                                                     |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `totalRecords`                                              | *Optional\<Long>*                                           | :heavy_minus_sign:                                          | The total number of records retrieved within the timespan.<br/> | 2                                                           |
| `currentOffset`                                             | *Optional\<Long>*                                           | :heavy_minus_sign:                                          | The current offset value. <br/><br/>Default: 1<br/>         | 1                                                           |
| `offsetCount`                                               | *Optional\<Long>*                                           | :heavy_minus_sign:                                          | The total number of offsets based on limit.<br/>            | 1                                                           |
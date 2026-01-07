# SigningKeysPagination

Pagination organizes content into pages for better readability and navigation.


## Fields

| Field                                                                           | Type                                                                            | Required                                                                        | Description                                                                     | Example                                                                         |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `totalRecords`                                                                  | *Optional\<Long>*                                                               | :heavy_minus_sign:                                                              | It gives the total number of Signing keys that are created by a user.           | 1                                                                               |
| `currentOffset`                                                                 | *Optional\<Long>*                                                               | :heavy_minus_sign:                                                              | Offset determines the current point for data retrieval within a paginated list. | 1                                                                               |
| `offsetCount`                                                                   | *Optional\<Long>*                                                               | :heavy_minus_sign:                                                              | The offset count is expressed as total records by limit                         | 10                                                                              |
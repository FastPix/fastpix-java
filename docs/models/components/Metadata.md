# Metadata

Required when the playlist type is `smart`. Media created between `startDate` and `endDate` of `createdDate` is added. Optionally, you can include media based on `updatedDate`.


## Fields

| Field                                                        | Type                                                         | Required                                                     | Description                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| `createdDate`                                                | [Optional\<DateRange>](../../models/components/DateRange.md) | :heavy_minus_sign:                                           | Date range with start and end dates.                         |
| `updatedDate`                                                | [Optional\<DateRange>](../../models/components/DateRange.md) | :heavy_minus_sign:                                           | Date range with start and end dates.                         |
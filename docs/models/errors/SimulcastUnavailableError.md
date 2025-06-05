# SimulcastUnavailableError

Returns the problem that has occured.



## Fields

| Field                                                                          | Type                                                                           | Required                                                                       | Description                                                                    | Example                                                                        |
| ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ |
| `code`                                                                         | *Optional\<Long>*                                                              | :heavy_minus_sign:                                                             | An error code indicating the type of the error.<br/>                           | 400                                                                            |
| `message`                                                                      | *Optional\<String>*                                                            | :heavy_minus_sign:                                                             | A descriptive message providing more details for the error<br/>                | Simulcast is not available for trial streams                                   |
| `description`                                                                  | *Optional\<String>*                                                            | :heavy_minus_sign:                                                             | A detailed explanation of the possible causes for the error.<br/>              | The requested resource (eg:streamId/playbackId) doesn't exist in the workspace |
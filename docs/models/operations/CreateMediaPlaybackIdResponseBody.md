# CreateMediaPlaybackIdResponseBody

Playback ID for a media content.


## Fields

| Field                                                                        | Type                                                                         | Required                                                                     | Description                                                                  | Example                                                                      |
| ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| `success`                                                                    | *Optional\<Boolean>*                                                         | :heavy_minus_sign:                                                           | Shows the request status. Returns true for success and false for failure.    | true                                                                         |
| `data`                                                                       | [Optional\<CreatePlaybackId>](../../models/components/CreatePlaybackId.md)   | :heavy_minus_sign:                                                           | A collection of Playback ID objects utilized for crafting HLS playback urls. |                                                                              |
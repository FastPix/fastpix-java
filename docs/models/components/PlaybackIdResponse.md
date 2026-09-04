# PlaybackIdResponse

A collection of Playback ID objects utilized for crafting HLS playback urls.


## Fields

| Field                                                                             | Type                                                                              | Required                                                                          | Description                                                                       | Example                                                                           |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `id`                                                                              | *Optional\<String>*                                                               | :heavy_minus_sign:                                                                | Unique identifier for the playbackId                                              | your-playback-id                                              |
| `accessPolicy`                                                                    | *Optional\<String>*                                                               | :heavy_minus_sign:                                                                | Determines if access to the streamed content is kept private or available to all. | public                                                                            |
| `accessRestrictions`                                                              | [Optional\<PlaybackIdAccessRestrictions>](../../models/components/PlaybackIdAccessRestrictions.md)| :heavy_minus_sign:                                                                | Domain and user-agent access restrictions applied to the playback ID.             |                                                                                   |

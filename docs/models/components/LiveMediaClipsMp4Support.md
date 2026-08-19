# LiveMediaClipsMp4Support

One downloadable MP4 rendition generated for the media, along with its generation status.


## Fields

| Field    | Type                                                                                                   | Required           | Description                                                                                                                                 | Example   |
|----------|--------------------------------------------------------------------------------------------------------|--------------------|---------------------------------------------------------------------------------------------------------------------------------------------|-----------|
| `type`   | [Optional\<LiveMediaClipsMp4SupportType>](../../models/components/LiveMediaClipsMp4SupportType.md)     | :heavy_minus_sign: | The MP4 rendition type. `capped_4k` is a downloadable MP4 video capped at 4K resolution, `audioOnly` is a downloadable m4a audio-only file. | capped_4k |
| `status` | [Optional\<LiveMediaClipsMp4SupportStatus>](../../models/components/LiveMediaClipsMp4SupportStatus.md) | :heavy_minus_sign: | Generation status of this MP4 rendition.                                                                                                    | ready     |
| `height` | *Optional\<Long>*                                                                                      | :heavy_minus_sign: | Pixel height of the rendition. Omitted for the `audioOnly` type.                                                                            | 1080      |
| `width`  | *Optional\<Long>*                                                                                      | :heavy_minus_sign: | Pixel width of the rendition. Omitted for the `audioOnly` type.                                                                             | 1920      |
| `ext`    | [Optional\<LiveMediaClipsMp4SupportExt>](../../models/components/LiveMediaClipsMp4SupportExt.md)       | :heavy_minus_sign: | File extension of the downloadable rendition.                                                                                               | mp4       |

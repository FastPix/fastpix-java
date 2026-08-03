# SourceAccessMediaMp4Support

One downloadable MP4 rendition generated for the media, along with its generation status.


## Fields

| Field    | Type                                                                                                         | Required           | Description                                                                                                                                 | Example   |
|----------|--------------------------------------------------------------------------------------------------------------|--------------------|---------------------------------------------------------------------------------------------------------------------------------------------|-----------|
| `type`   | [Optional\<SourceAccessMediaMp4SupportType>](../../models/components/SourceAccessMediaMp4SupportType.md)     | :heavy_minus_sign: | The MP4 rendition type. `capped_4k` is a downloadable MP4 video capped at 4K resolution, `audioOnly` is a downloadable m4a audio-only file. | capped_4k |
| `status` | [Optional\<SourceAccessMediaMp4SupportStatus>](../../models/components/SourceAccessMediaMp4SupportStatus.md) | :heavy_minus_sign: | Generation status of this MP4 rendition.                                                                                                    | ready     |
| `height` | *Optional\<Long>*                                                                                            | :heavy_minus_sign: | Pixel height of the rendition. Omitted for the `audioOnly` type.                                                                            | 1080      |
| `width`  | *Optional\<Long>*                                                                                            | :heavy_minus_sign: | Pixel width of the rendition. Omitted for the `audioOnly` type.                                                                             | 1920      |
| `ext`    | [Optional\<SourceAccessMediaMp4SupportExt>](../../models/components/SourceAccessMediaMp4SupportExt.md)       | :heavy_minus_sign: | File extension of the downloadable rendition.                                                                                               | mp4       |

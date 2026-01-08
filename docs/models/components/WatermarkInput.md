# WatermarkInput

Contains configuration details for applying a watermark overlay to a video.  
The watermark is placed over the media content during processing.  
For detailed setup steps and customization options, refer to the 
<a href="https://docs.fastpix.io/docs/watermark-your-videos" target="_blank">FastPix Watermark Guide</a>.



## Fields

| Field                                                               | Type                                                                | Required                                                            | Description                                                         | Example                                                             |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `type`                                                              | [WatermarkInputType](../../models/components/WatermarkInputType.md) | :heavy_check_mark:                                                  | Type of overlay (currently only supports "watermark").              | watermark                                                           |
| `url`                                                               | *String*                                                            | :heavy_check_mark:                                                  | URL of the watermark image.                                         | https://static.fastpix.io/watermark-4k.png                          |
| `placement`                                                         | [Optional\<Placement>](../../models/components/Placement.md)        | :heavy_minus_sign:                                                  | N/A                                                                 |                                                                     |
| `width`                                                             | *Optional\<String>*                                                 | :heavy_minus_sign:                                                  | Width of the watermark in percentage or pixels.                     | 25%                                                                 |
| `height`                                                            | *Optional\<String>*                                                 | :heavy_minus_sign:                                                  | Height of the watermark in percentage or pixels.                    | 25%                                                                 |
| `opacity`                                                           | *Optional\<String>*                                                 | :heavy_minus_sign:                                                  | Opacity of the watermark in percentage.                             | 80%                                                                 |
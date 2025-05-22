# Subtitles

Generates subtitle files for audio/video files.



## Fields

| Field                                                                        | Type                                                                         | Required                                                                     | Description                                                                  | Example                                                                      |
| ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| `languageName`                                                               | *Optional\<String>*                                                          | :heavy_minus_sign:                                                           | Name of the language for the subtitles.                                      | english                                                                      |
| `metadata`                                                                   | [Optional\<SubtitlesMetadata>](../../models/operations/SubtitlesMetadata.md) | :heavy_minus_sign:                                                           | Searchable metadata tags for the video in key-value pairs.                   | {<br/>"key1": "value1"<br/>}                                                 |
| `languageCode`                                                               | [Optional\<LanguageCode>](../../models/operations/LanguageCode.md)           | :heavy_minus_sign:                                                           | Language codes (BCP 47 compliant) used for text files.<br/>                  | en                                                                           |
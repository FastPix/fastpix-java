# UpdateTrackRequest

Contains details about the track being updated. The track's file (`url`) cannot be changed — only its language and title.


## Fields

| Field                                                                              | Type                                                                               | Required                                                                           | Description                                                                        | Example                                                                            |
| ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| `languageCode`                                                                     | *Optional\<String>*                                                                | :heavy_minus_sign:                                                                 | The BCP 47 language code representing the track’s language.                        | fr                                                                                 |
| `languageName`                                                                     | *Optional\<String>*                                                                | :heavy_minus_sign:                                                                 | The full name of the language corresponding to the `languageCode`.                 | French                                                                             |
| `title`                                                                            | *Optional\<String>*                                                                | :heavy_minus_sign:                                                                 | Title of the track.                                                                | French subtitles                                                                   |

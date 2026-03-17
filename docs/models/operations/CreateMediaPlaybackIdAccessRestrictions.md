# CreateMediaPlaybackIdAccessRestrictions


## Fields

| Field                                                                                | Type                                                                                 | Required                                                                             | Description                                                                          |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `domains`                                                                            | [Optional\<DomainRestrictions>](../../models/components/DomainRestrictions.md)       | :heavy_minus_sign:                                                                   | Restrictions based on the originating domain of a request                            |
| `userAgents`                                                                         | [Optional\<UserAgentRestrictions>](../../models/components/UserAgentRestrictions.md) | :heavy_minus_sign:                                                                   | Restrictions based on the user agent                                                 |
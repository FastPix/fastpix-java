# UserAgentRestrictions

Restrictions based on the user agent


## Fields

| Field                                                              | Type                                                               | Required                                                           | Description                                                        |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| `defaultPolicy`                                                    | [Optional\<PolicyAction>](../../models/components/PolicyAction.md) | :heavy_minus_sign:                                                 | Policy action type                                                 |
| `allow`                                                            | List\<*String*>                                                    | :heavy_minus_sign:                                                 | A list of user agents that are explicitly allowed access           |
| `deny`                                                             | List\<*String*>                                                    | :heavy_minus_sign:                                                 | A list of user agents that are explicitly denied access            |
# DomainRestrictions

Restrictions based on the originating domain of a request


## Fields

| Field                                                                 | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `defaultPolicy`                                                       | [Optional\<PolicyAction>](../../models/components/PolicyAction.md)    | :heavy_minus_sign:                                                    | Policy action type                                                    |
| `allow`                                                               | List\<*String*>                                                       | :heavy_minus_sign:                                                    | A list of domain names or patterns that are explicitly allowed access |
| `deny`                                                                | List\<*String*>                                                       | :heavy_minus_sign:                                                    | A list of domain names or patterns that are explicitly denied access  |
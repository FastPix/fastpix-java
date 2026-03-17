# PlaybackIdDomains

Restrictions based on the originating domain of a request (for example, whether requests from certain websites must be allowed or blocked).


## Fields

| Field                                                                      | Type                                                                       | Required                                                                   | Description                                                                |
| -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| `defaultPolicy`                                                            | [Optional\<PolicyAction>](../../models/components/PolicyAction.md)         | :heavy_minus_sign:                                                         | Policy action type                                                         |
| `allow`                                                                    | List\<*String*>                                                            | :heavy_minus_sign:                                                         | A list of domains that are explicitly allowed access.                      |
| `deny`                                                                     | List\<*String*>                                                            | :heavy_minus_sign:                                                         | A list of domains that are explicitly blocked from accessing the resource. |
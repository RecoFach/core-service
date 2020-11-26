# Subject

## ToC

Supported methods:

- `put` - create new `Subject` with `SubjectR`

## `PUT` 

**Path**: `/subjects/`

To create new `Subject` perform a `put` request on `/subjects` path with
json-body. All fields are *required*.

Here is complete table of parameters:

| Name   | Type         |
| ------ | ------------ |
| `name` | `String`     |
| `link` | `String`     |
| `sws`  | `Int`        |
| `type` | `SubjectType`|
| `lang` | `SubjectLang`|

**Example**:

We want to send this object.

```json
{
    "name": "Test",
    "link": "google.com",
    "sws": 3,
    "type": "SECURITY",
    "lang": "DE"
}
```

We can do this wit following command: 

```bash
curl --location --request PUT 'localhost:8080/subjects' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Test",
    "link": "google.com",
    "sws": 3,
    "type": "SECURITYz",
    "lang": "DE"
}'
```
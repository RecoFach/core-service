# Subject

## ToC

Supported methods:

- `put` - create new `Subject` with `SubjectR`

## `PUT` 

**Path**: `/subjects/`

To create new `Subject` perform a `put` request on `/subjects` path with
json-body. All fields are *required*.

Here is complete table of parameters:

| Name        | Type                       |
| ----------- | -------------------------- |
| `name`      | `String`                   |
| `link`      | `String`                   |
| `sws`       | `Int`                      |
| `type`      | `SubjectType`              |
| `lang`      | `SubjectLang`              |
| `categories | List of `SubjectCategorie` | 

**Example**:

We want to send this object.

```json
{
    "name": "New Structure",
    "link": "google.com",
    "sws": 4,
    "type": "PRAXIS",
    "lang": "EN",
    "categories": ["AI", "LOWLEVEL"]
}
```

We can do this wit following command: 

```bash
curl --location --request PUT 'localhost:8080/subjects' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "New Structure",
    "link": "google.com",
    "sws": 4,
    "type": "PRAXIS",
    "lang": "EN",
    "categories": ["AI", "LOWLEVEL"]
}'
```

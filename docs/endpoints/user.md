# User

## ToC

Supported methods:

- `put` - create new `User` with `UserR`

## `PUT` 

**Path**: `/users/signup`

To create new `User` perform a `put` request on `/users` path with
json-body. All fields are *required*.

Here is complete table of parameters:

| Name        | Type                       |
| ----------- | -------------------------- |
| `name`      | `String?`                  |
| `surname`   | `String?`                  |
| `username`  | `String`                   |
| `email`     | `String?`                  |
| `password`  | `String`                   |

**Example**:

We want to send this object.

```json
{
    "name": "John",
    "surname": "Doe",
    "username": "john_doe",
    "email": "johndoe@gmail.com",
    "password": "password1234"
}
```

We can do this wit following command: 

```bash
curl --location --request PUT 'localhost:8080/users/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "John",
    "surname": "Doe",
    "username": "user",
    "email": "johndoe@gmail.com",
    "password": "password"
}'
```

If all data is correct we will receive following object of 
type `User`:

```json
{
    "name": "John",
    "surname": "Doe",
    "username": "user",
    "email": "johndoe@gmail.com",
    "password": "$2a$10$WMlHkHxPL2.YVNileLPbCODTiFbcCIRVXuf/.HtX94A8LRUC4eSLK",
    "id": "ae6e7d22-57ad-4c52-844b-9f1cb4f447ef"
}
```

The password will be type of `bCryptEncoder` and id will be `UUID`.

Now you can proceed to login.

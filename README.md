# Marvel Comics Project

To keep Marvel Comics information up to date

## Build the project

You can compile your application using:

```shell script
./assemble.sh
```

## Run the project

You can run your application using:

```shell script
./avengers.sh
```

## Use project services

You can do it through Postman or with the following commands:
> **_NOTE:_**  To access locally: [http://localhost](http://localhost).

### Sync

You must sync information from Marvel comics on demand

``
POST http://localhost/sync
``

For example:

```shell script
curl --location --request POST 'http://localhost/sync'
```

### Characters

You can get information from the characters

``
GET http://localhost/marvel/characters/{shortName}
``

For example:

```shell script
curl --location --request GET 'http://localhost/marvel/characters/ironman'
```

### Collaborators

You can get information from the collaborators

``
GET http://localhost/marvel/colaborators/{shortName}
``

For example:

```shell script
curl --location --request GET 'http://localhost/marvel/colaborators/ironman'
```

### Heroes

A list of heroes with a short name and a name that allows synchronization

#### Get

``
GET http://localhost/heroes
``

For example:

```shell script
curl --location --request GET 'http://localhost/heroes'
```

#### New

``
POST http://localhost/heroes
``

For example:

```shell script
curl --location --request POST 'http://localhost/heroes' \
--header 'Content-Type: application/json' \
--data-raw '{
    "shortName": "supergirl",
    "name": "Super Girl"
}'
```

#### Delete

``
DELETE http://localhost/heroes/{shortName}
``

For example:

```shell script
curl --location --request DELETE 'http://localhost/heroes/supergirl'
```

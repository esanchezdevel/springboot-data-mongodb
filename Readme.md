Insert new person in database:
- `curl -vv -XPOST http://localhost:8080/mongodb/person -d '{"name":"tom", "age": 18}' -H 'Content-Type: application/json'`

List all people
- `curl -vv http://localhost:8080/mongodb/people -H 'Accept: application/json'`

Update person adding a friend to the list
- `curl -vv -XPUT http://localhost:8080/mongodb/person/tom/add/friend -d '{"name":"Jerry", "age": 32}' -H 'Content-Type: application/json'`

Delete person
- `curl -vv -X DELETE http://localhost:8080/mongodb/person/tom -H 'Accept: application/json'` 
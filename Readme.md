Insert new person in database:
`curl -vv -XPOST http://localhost:8080/mongodb/person -d '{"name":"tom", "age": 18}' -H 'Content-Type: application/json'`

List all people
`curl -vv http://localhost:8080/mongodb/people -H 'Accept: application/json'`
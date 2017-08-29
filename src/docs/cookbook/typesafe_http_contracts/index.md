This contract example shows:

- 2 endpoints with typesafe contracts (marshalling of path parameters and bodies)
- Custom filters (reporting latency)
- API key security via a typesafe Query parameter (this can be a header or a body parameter as well)
- Swagger API documentation - Run this example and point a browser [here](http://petstore.swagger.io/?url=http://localhost:8000/context/swagger.json)

### Gradle setup
```
    compile group: "org.http4k", name: "http4k-core", version: "2.23.4"
    compile group: "org.http4k", name: "http4k-contract", version: "2.23.4"
```

### Code
<script src="https://gist-it.appspot.com/https://github.com/http4k/http4k/blob/master/src/docs/cookbook/typesafe_http_contracts/example.kt"></script>

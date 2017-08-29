### Installation (Gradle)
**Argo:**  ```compile group: "org.http4k", name: "http4k-format-argo", version: "2.23.4"```

**Gson:**  ```compile group: "org.http4k", name: "http4k-format-gson", version: "2.23.4"```

**Jackson:** ```compile group: "org.http4k", name: "http4k-format-jackson", version: "2.23.4"```

**Xml:** ```compile group: "org.http4k", name: "http4k-format-xml", version: "2.23.4"```

### About
These modules add the ability to use JSON/XML as a first-class citizen when reading from and to HTTP messages. Each implementation adds a set of 
standard methods and extension methods for converting common types into native JSON/XML objects, including custom Lens methods for each library so that 
JSON/XML node objects can be written and read directly from HTTP messages:

<script src="https://gist-it.appspot.com/https://github.com/http4k/http4k/blob/master/src/docs/guide/modules/message_formats/example.kt"></script>

### Auto-marshalling capabilities

Some of the message libraries (eg. GSON, Jackson, XML) provide the mechanism to automatically marshall data objects to/from JSON and XML using reflection.

We can use this facility in **http4k** to automatically marshall objects to/from HTTP message bodies using **Lenses**:

#### JSON

<script src="https://gist-it.appspot.com/https://github.com/http4k/http4k/blob/master/src/docs/guide/modules/message_formats/autoJson.kt"></script>

#### XML

<script src="https://gist-it.appspot.com/https://github.com/http4k/http4k/blob/master/src/docs/guide/modules/message_formats/autoXml.kt"></script>

There is a utility to generate Kotlin code for JSON and XML data class code [here](http://http4k-data-class-gen.herokuapp.com) . These data classes are compatible with using the `Body.auto<T>()` functionality. 

#### Important note regarding JSON arrays
When handling raw JSON array messages, such as: `[123, 456, 567]`, there is a slight gotcha when auto-marshalling messages from JSON.

This is demonstrated by the following, where you can see that the output of the auto-unmarshalling a naked JSON is NOT the same as a native Kotlin list of objects. This can make tests break as the unmarshalled list is NOT equal to the native list.

As shown, a workaround to this is to use `Body.auto<Array<MyIntWrapper>>().toLens()` instead, and then compare using `Arrays.equal()`

<script src="https://gist-it.appspot.com/https://github.com/http4k/http4k/blob/master/src/docs/guide/modules/message_formats/list_gotcha.kt"></script>


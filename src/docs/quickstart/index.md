# Quickstart

This simple example demonstates how to serve and consume HTTP services using **http4k**. 

To install, add these dependencies to your **Gradle** file:
```groovy
dependencies {
    compile group: "org.http4k", name: "http4k-core", version: "2.23.4"
    compile group: "org.http4k", name: "http4k-server-jetty", version: "2.23.4"
    compile group: "org.http4k", name: "http4k-client-apache", version: "2.23.4"
}
```

The following creates a simple endpoint, binds it to a Jetty server then starts, queries, and stops it.

<script src="https://gist-it.appspot.com/https://github.com/http4k/http4k/blob/master/src/docs/quickstart/example.kt"></script>


## Single-line CD Bootstrap
Run the single command in the readme of [this repo](https://github.com/http4k/http4k-bootstrap) to create a HelloWorld **http4k** app with a full CD pipeline using Github -> TravisCI -> Heroku.

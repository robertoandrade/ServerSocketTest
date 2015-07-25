ServerSocketTest
================

Sample Java app to attempt reusing the same address/port by using the `ServerSocketChannel` API with `setReuseAddress(true)` in various scenarios, namely:

- Listening to ALL interfaces then attempting to bind to ALL again on the same port
- Listening to ALL interfaces then attempting to bind to a single ONE again on the same port
- Listening to ONE interface then attempting to bind to the same ONE again on the same port

Running example
===============

You can compile and run the `ServerSocketTest.java` directly on your machine, or for isolation, you may leverage the `Dockerfile` included to run it in an isolated debian/java8 container:

```
docker build -t server-socket-test .
docker run -it server-socket-test
```
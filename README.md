# JAX-RS Performance

Compares performance of per-request and singleton JAX-RS resource classes.

See [JAX-RS Resource Lifecycle Performance Impact][1].

This project includes 4 resource classes: 2 per-request scoped and 2 singletons. Two are just returning a query param.
In the other two resources we will inject the UriInfo via @Context. The context is specific to a particular request.
So on a request-scoped resource it can be injected at creation time. For a singleton resource this needs to be handled different
by maybe creating proxy objects. 

## Build

    mvn clean install
    docker build -t jax-rs-performance .
    docker run -it --rm --name jax-rs-performance -p 8080:8080 -p 9990:9990 jax-rs-performance
    mvn clean verify
    
The host and number of test iterations can be configured in the jmeter-maven-plugin settings of the pom.xml.

## Results

The tests were performed with Java 1.8.0_45, Wildfly 8.2.0.Final including RESTeasy 3.0.10.Final.
Every test was run with 5 Threads and repeated 500000 times. JBoss was restarted after every test.

| Test                      | Avg | Min | Max | Requests/Second | 
| ------------------------- | --: | --: | --: | --------------: |
| Per-Request               |   2 |   0 | 170 |            1970 |  
| Per-Request with @Context |   2 |   0 | 174 |            1999 |
| Singleton                 |   2 |   0 | 195 |            2000 |  
| Singleton with @Context   |   2 |   0 | 397 |            2022 |

The JVisualVM Screenshots can be found in [results/visualvm](results/visualvm).
    
 [1]: http://stackoverflow.com/questions/30409895/jax-rs-resource-lifecycle-performance-impact
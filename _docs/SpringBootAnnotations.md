
# Key Annotations for Building a Simple REST API with Spring Boot

## Spring Framework Core Annotations

### `@SpringBootApplication`

Marks the main class of a Spring Boot application. It combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.

```java
@SpringBootApplication
public class ReelVaultApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReelVaultApplication.class, args);
    }
}
```

### `@Component`

Indicates that a class is a Spring-managed component. Classes annotated with `@Component` are automatically detected through classpath scanning.

```java
@Component
public class MyComponent {
}
```

### `@Service`

A specialized `@Component` annotation used to define service-layer classes.

```java
@Service
public class MovieService {
}
```

### `@Repository`

A specialized `@Component` annotation used to define data access objects (DAO). It also translates database exceptions into Spring DataAccessException.

```java
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
```

### `@Controller`

Indicates that a class serves as a Spring MVC controller.

```java
@Controller
public class MyController {
}
```

### `@RestController`

A specialized `@Controller` annotation used in RESTful web services. It combines `@Controller` and `@ResponseBody`.

```java
@RestController
@RequestMapping("/api/movies")
public class MovieController {
}
```

### `@RequestMapping`

Maps HTTP requests to handler methods of MVC and REST controllers.

```java
@RequestMapping("/api/movies")
public class MovieController {
}
```

## REST API Annotations

### `@GetMapping`

Handles HTTP GET requests.

```java
@GetMapping
public List<Movie> getAllMovies() {
    return movieService.getAllMovies();
}
```

### `@PostMapping`

Handles HTTP POST requests.

```java
@PostMapping
public Movie addMovie(@RequestBody Movie movie) {
    return movieService.addMovie(movie);
}
```

### `@PutMapping`

Handles HTTP PUT requests.

```java
@PutMapping("/{id}")
public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
    return movieService.updateMovie(id, movieDetails);
}
```

### `@DeleteMapping`

Handles HTTP DELETE requests.

```java
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
    movieService.deleteMovie(id);
    return ResponseEntity.noContent().build();
}
```

### `@PathVariable`

Binds a method parameter to a URI template variable.

```java
@GetMapping("/{id}")
public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
    return movieService.getMovieById(id)
            .map(movie -> ResponseEntity.ok().body(movie))
            .orElse(ResponseEntity.notFound().build());
}
```

### `@RequestBody`

Binds the HTTP request body to a method parameter.

```java
@PostMapping
public Movie addMovie(@RequestBody Movie movie) {
    return movieService.addMovie(movie);
}
```

### `@RequestParam`

Binds a method parameter to a query parameter.

```java
@GetMapping("/search")
public List<Movie> searchMovies(@RequestParam String title) {
    return movieService.searchMoviesByTitle(title);
}
```

## Data and Validation Annotations

### `@Entity`

Specifies that the class is an entity and is mapped to a database table.

```java
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    // Other fields, getters, and setters
}
```

### `@Id`

Specifies the primary key of an entity.

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

### `@GeneratedValue`

Provides for the specification of generation strategies for the values of primary keys.

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

### `@Column`

Specifies the mapped column for a persistent property or field.

```java
@Column(name = "title")
private String title;
```

### `@Table`

Specifies the primary table for the annotated entity.

```java
@Entity
@Table(name = "movies")
public class Movie {
}
```

### `@Valid`

Used to indicate that a method parameter should be validated.

```java
public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {
}
```

### `@NotNull`, `@Size`, `@Min`, `@Max`, etc.

Validation annotations used to specify validation rules for entity fields.

```java
@NotNull
@Size(min = 1, max = 255)
private String title;

@Min(0)
private double rating;
```

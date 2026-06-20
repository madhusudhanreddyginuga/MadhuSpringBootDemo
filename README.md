# Madhu Spring Boot Demo

A minimal REST API built with Spring Boot 3. If you know **Express.js** or **Nest.js**, most concepts will feel familiar — routes, controllers, services, and JSON over HTTP — just with Java syntax and Maven instead of npm.

## Quick start

**Prerequisites:** Java 17+ and Maven 3.8+

```bash
mvn spring-boot:run
```

Server starts at `http://localhost:8080`.

```bash
curl http://localhost:8080/health
curl http://localhost:8080/users/123
```

---

## What is what?

| Term | Plain English | Express / Nest analogy |
|------|---------------|------------------------|
| **Java** | The programming language. Compiled to bytecode, runs on the JVM. Strongly typed (like TypeScript, but enforced at compile time). | TypeScript's type system, but mandatory |
| **JVM** | Java Virtual Machine — runs compiled `.class` / `.jar` files. | Like Node.js runtime for JS |
| **Maven** | Build & dependency tool. Uses `pom.xml` (like `package.json`). | npm / yarn |
| **Spring Boot** | Framework that boots a web server, wires dependencies, and handles config. | Nest.js (opinionated, batteries included) or Express + a lot of middleware |
| **Spring** | The larger ecosystem (DI, MVC, data access, security, etc.). Spring Boot is a layer on top that auto-configures Spring. | Nest.js sits on Express; Spring Boot sits on Spring |
| **Controller** | Handles HTTP requests and returns responses. | `@Controller` / route handler |
| **Service** | Business logic, separate from HTTP layer. | Nest `@Injectable()` service |
| **Model / DTO** | Plain Java class representing data (JSON body or response). | Interface / class for request body |
| **Dependency Injection** | Spring creates and injects objects (`@Autowired`) — you don't `new` services yourself. | Nest constructor injection |
| **`application.properties`** | App config (port, DB URL, etc.). | `.env` + `config` module |
| **`target/`** | Maven build output (compiled classes, JAR). | `dist/` or `build/` — **do not commit** |

---

## Project layout

```
src/main/java/com/madhu/demo/
├── MadhuSpringBootDemoApplication.java   # entry point (like index.ts / main.ts)
├── controller/
│   ├── HealthController.java             # GET /health
│   └── UserController.java               # CRUD /users
├── model/
│   └── User.java                         # JSON shape
└── service/
    └── UserService.java                  # in-memory store

src/main/resources/
└── application.properties                # port, app name

pom.xml                                   # dependencies & build config
```

---

## API

### Health

| Method | Path | Response |
|--------|------|----------|
| `GET` | `/health` | `{ "status": "ok" }` |

### Users

`User` has three field **types** (for demo purposes):

| Field | Type | Example |
|-------|------|---------|
| `name` | `String` | `"Alice"` |
| `age` | `int` | `30` |
| `active` | `boolean` | `true` |

User `123` is seeded on startup.

| Method | Path | Body | Notes |
|--------|------|------|-------|
| `GET` | `/users` | — | List all users |
| `GET` | `/users/123` | — | Get one user |
| `POST` | `/users` | `{ "name": "Bob", "age": 25, "active": false }` | Creates user with auto-generated id |
| `PUT` | `/users/123` | `{ "name": "Alice", "age": 31, "active": true }` | Replace user |
| `DELETE` | `/users/123` | — | Returns `204 No Content` |

**Examples:**

```bash
# Read
curl http://localhost:8080/users/123

# Create
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Bob","age":25,"active":false}'

# Update
curl -X PUT http://localhost:8080/users/123 \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice","age":31,"active":true}'

# Delete
curl -X DELETE http://localhost:8080/users/123
```

---

## Commands cheat sheet

| Task | npm / Node habit | This project (Maven) |
|------|------------------|----------------------|
| Install deps | `npm install` | `mvn dependency:resolve` (Maven downloads on first build automatically) |
| Run dev server | `npm run dev` | `mvn spring-boot:run` |
| Build | `npm run build` | `mvn package` |
| Run production build | `node dist/index.js` | `java -jar target/MadhuSpringBootDemo-1.0.0.jar` |
| Test | `npm test` | `mvn test` |
| Typecheck | `tsc --noEmit` | `mvn compile` — Java types are checked at compile time |
| Clean build artifacts | `rm -rf dist` | `mvn clean` |
| Format | `npm run format` (Prettier) | Not configured by default — use your IDE formatter, or add [Spotless](https://github.com/diffplug/spotless) |
| Lint | `npm run lint` (ESLint) | Not configured by default — add [Checkstyle](https://checkstyle.sourceforge.io/) or [SpotBugs](https://spotbugs.github.io/) if needed |

### Common Maven commands

```bash
mvn spring-boot:run     # start the app (hot reload needs spring-boot-devtools — not included here)
mvn compile             # compile only — catches type errors
mvn test                # run tests
mvn package             # compile + test + build JAR in target/
mvn clean package       # fresh build from scratch
mvn clean               # delete target/
```

---

## Express / Nest → Spring mapping

| Express / Nest | Spring Boot |
|----------------|-------------|
| `app.get('/health', ...)` | `@GetMapping("/health")` on a `@RestController` |
| `req.params.id` | `@PathVariable Long id` |
| `req.body` | `@RequestBody User user` |
| `res.status(404).json(...)` | `ResponseEntity.notFound().build()` |
| `module` / `providers` | `@Service`, `@Component` + component scan |
| `PORT` env var | `server.port` in `application.properties` |
| `package.json` scripts | Maven goals in `pom.xml` or CLI |

---

## Should `target/` be committed?

**No.** `target/` is Maven's build output (compiled `.class` files, JARs, reports). It is regenerated on every build — same idea as committing `node_modules` or `dist/`. It is listed in `.gitignore`.

If `target/` was previously tracked in git, remove it from the index once:

```bash
git rm -r --cached target
```

---

## Learn more

- [Spring Boot docs](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Web MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Maven getting started](https://maven.apache.org/guides/getting-started/)

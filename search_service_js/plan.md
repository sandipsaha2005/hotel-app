# Search Service Plan

# Overview

The Search Service is a microservice responsible for:

- Searching hotels
- Filtering hotels by city
- Returning hotel information to clients

This service will be built using:

```text
Node.js
Express.js
PostgreSQL
Docker
```

The service will run independently inside its own Docker container.

---

# Responsibilities

The Search Service should:

- Fetch hotel data from PostgreSQL
- Search hotels by city
- Return hotel list as JSON
- Handle hotel-related read operations

---

# Architecture Flow

```text
Client
   ↓
Nginx API Gateway
   ↓
Search Service (Node.js)
   ↓
PostgreSQL
```

---

# API Endpoint

## Search Hotels

```http
GET /api/search/hotels?city=vizag
```

---

# Example Response

```json
[
  {
    "id": 1,
    "name": "Sea View Resort",
    "city": "vizag",
    "price": 4500
  },
  {
    "id": 2,
    "name": "Ocean Stay",
    "city": "vizag",
    "price": 3000
  }
]
```

---

# Project Structure

```text
search-service/
│
├── src/
│   ├── routes/
│   │     searchRoutes.js
│   │
│   ├── controllers/
│   │     searchController.js
│   │
│   ├── db/
│   │     db.js
│   │
│   ├── services/
│   │     searchService.js
│   │
│   └── app.js
│
├── Dockerfile
├── package.json
├── .env
└── docker-compose.yml
```

---

# Technologies Used

| Technology | Purpose |
|---|---|
| Node.js | Backend runtime |
| Express.js | HTTP server |
| PostgreSQL | Database |
| pg | PostgreSQL driver |
| Docker | Containerization |
| Nginx | API Gateway |

---

# Database Table

## hotels

| Column | Type |
|---|---|
| id | BIGSERIAL |
| name | VARCHAR |
| city | VARCHAR |
| price | DOUBLE PRECISION |
| owner | VARCHAR |
| owner_email | VARCHAR |

---

# PostgreSQL Query Example

```sql
SELECT * FROM hotels
WHERE city = 'vizag';
```

---

# Docker Responsibilities

The Search Service container should:

- Run Node.js application
- Connect to PostgreSQL
- Expose internal API port
- Communicate through Docker network

---

# Nginx Gateway Routing

Example nginx configuration:

```nginx
location /api/search/ {
    proxy_pass http://search-service:3001;
}
```

Meaning:

```text
All /api/search requests
        ↓
Forwarded to search-service container
```

---

# Docker Networking

All services communicate through:

```text
backend network
```

Example services:

```text
nginx
search-service
booking-service
user-service
postgres
```

Docker automatically provides internal DNS.

Example:

```text
search-service
```

can be accessed directly inside network.

---

# Environment Variables

Example:

```env
PORT=3001

DB_HOST=postgres
DB_PORT=5432
DB_USER=postgres
DB_PASSWORD=password
DB_NAME=hotel
```

---

# Suggested Packages

Install dependencies:

```bash
npm init -y

npm install express pg dotenv
```

Optional development dependency:

```bash
npm install --save-dev nodemon
```

---

# Basic Application Flow

```text
Request received
      ↓
Express Route
      ↓
Controller
      ↓
Service Layer
      ↓
PostgreSQL Query
      ↓
JSON Response
```

---

# Search Service Terminologies

| Term | Meaning |
|---|---|
| Microservice | Small independent backend service |
| API Gateway | Single entry point (Nginx) |
| Reverse Proxy | Nginx forwarding requests |
| Containerization | Running app inside Docker container |
| Service Isolation | Each service runs independently |
| Scalability | Increase replicas when load increases |
| Polyglot Architecture | Different services use different languages |

---

# Future Enhancements

Possible future features:

- Pagination
- Hotel filtering
- Sorting
- Hotel ratings
- Search caching
- Redis integration
- Elasticsearch integration

---

# Final Request Flow

```text
Client
   ↓
localhost:3000/api/search/hotels?city=vizag
   ↓
Nginx Gateway
   ↓
Search Service (Node.js)
   ↓
PostgreSQL
   ↓
Hotel Data
   ↓
JSON Response
```◊
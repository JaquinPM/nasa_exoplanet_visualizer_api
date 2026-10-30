# NASA Exoplanet Visualizer API

Backend application built with **Java and Spring Boot** for managing, processing, and querying data on exoplanets, stars, and exoplanetary systems integrated with NASA data.

## Technologies
* **Language:** Java
* **Framework:** Spring Boot
* **Persistence:** Spring Data JPA
* **Dependency Management:** Maven (`mvnw`)

## Data Source

The application fetches, processes, and integrates astronomical information directly from the **NASA Exoplanet Archive**, synchronizing official catalogs of stellar systems, host stars, and confirmed exoplanets through its integration service.

## 🛠️ Installation and Setup

1. **Clone the repository:**

   ```
   git clone <REPOSITORY_URL>
   cd nasa_exoplanet_visualizer_api
   
   ```

2. **Database Configuration:**
Make sure you have MariaDB installed and running. Create a database named exoplanets:


3. **Build and run the application:**

   ```
   ./mvnw spring-boot:run
   
   ```

   *On Windows (CMD):*

   ```
   mvnw.cmd spring-boot:run
   
   ```

The API will be available by default at `http://localhost:8080`.

## Main Endpoints

### **1. Exoplanets (`/api/exoplanets`)**

* **`GET /api/exoplanets`** — Fetches the list of registered exoplanets. Supports searching by name and pagination via query parameters:

  * `name` *(optional)*: Filters results by the planet's name.

  * `page` *(optional)*: Page number for pagination.

  * `limit` *(optional)*: Number of results per page.

  * *Example:* `/api/exoplanets?name=Kepler&page=0&limit=10`

* **`GET /api/exoplanets/{id}`** — Fetches details for a specific exoplanet by its ID.

### **2. Exoplanetary Systems (`/api/systems`)**

* **`GET /api/systems`** — Lists all exoplanetary systems and their associated stars.

* **`GET /api/systems/{id}`** — Fetches detailed information for a specific exoplanetary system, including its full structure (stars and orbiting planets).

## Features
* **Exoplanetary Systems:** Query complete stellar systems along with their respective host stars and orbits.
* **Exoplanets:** Search, filter by name, and paginate confirmed exoplanets.
* **NASA Integration:** Automated service responsible for processing and structuring data from NASA catalogs.

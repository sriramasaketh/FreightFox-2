# Weather Information API

This project provides a REST API for fetching weather information for a specific pincode and date. The API integrates with the Google Maps Geocoding API and the OpenWeather API to fetch latitude/longitude and weather data, respectively. It also caches results in a relational database (RDBMS) to optimize API calls.

## Features

- Get weather information for a specific date and pincode.
- Cache weather data to minimize external API calls.
- Store pincode, latitude, and longitude in the database.
- Use Google Maps Geocoding API to convert pincode to latitude/longitude.
- Use OpenWeather API to fetch weather details based on latitude/longitude.
- REST-compliant API design.
- Follows TDD principles with test cases written in JUnit.

## Prerequisites

- Java 11+
- Maven 3.x
- An active internet connection (for API calls).
- API keys for:
  - [Google Maps Geocoding API](https://developers.google.com/maps/documentation/geocoding/start)
  - [OpenWeather API](https://openweathermap.org/current)

## Getting Started

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/weather-info-api.git
    cd weather-info-api
    ```

2. **Configure API keys:**

    Open the `application.properties` file located in `src/main/resources/` and add your API keys for Google Maps and OpenWeather.

    ```properties
    google.maps.api.key=YOUR_GOOGLE_MAPS_API_KEY
    openweather.api.key=YOUR_OPENWEATHER_API_KEY
    ```

3. **Build the project:**

    Run the following command to build the project using Maven:

    ```bash
    mvn clean install
    ```

4. **Run the project:**

    After building the project, you can run it using:

    ```bash
    mvn spring-boot:run
    ```

5. **Access the API:**

    The API will be running on `http://localhost:8080`.

## API Endpoints

### Get Weather Information

- **Endpoint:** `/api/weather`
- **Method:** `GET`
- **Description:** Returns weather information for a specific pincode and date.
  
#### Request Parameters:

| Parameter | Type   | Description                 |
|-----------|--------|-----------------------------|
| `pincode` | String | The pincode for the location |
| `forDate` | String | The date in `YYYY-MM-DD` format |

#### Example Request:

```bash
GET /api/weather?pincode=411014&forDate=2020-10-15










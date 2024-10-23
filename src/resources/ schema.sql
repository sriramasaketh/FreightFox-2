CREATE TABLE weather_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pincode VARCHAR(6) NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    for_date DATE NOT NULL,
    weather_description VARCHAR(255),
    temperature DOUBLE,
    UNIQUE (pincode, for_date)
);

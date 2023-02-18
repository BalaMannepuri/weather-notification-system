# Weather-notification-system

# Technologies

    Spring  :  5.2.3.RELEASE
    Java    :  11
    lombok  :  1.18.24
    junit   :  5.9.2
    log4j   :  1.2.17
    mockito :  2.24.0
    ehcache :  2.10.2.2.21


These are Weather api providers for getting temperature by city

# 1. temperature-info-service

Method      : GET

URI         : http://localhost:8080/temperature-info-service/v1/temperature/pune

Response    : Integer Value

# 2. weather-detail-service

Method      : GET

URI         : http://localhost:8080/weather-details-service/v1/weather/pune

Response    : Integer Value

# 3. weather-info-service

Method      : GET

URI         : http://localhost:8080/weather-info-service/v1/api/weather/pune

Response    : Integer Value

*Note

These are configured in application.properties with the key is weather.api.uri. if you want add new weather api(get) append the url here

weather.api.uri=http://localhost:8080/temperature-info-service/v1/temperature/,http://localhost:8080/weather-details-service/v1/weather/,http://localhost:8080/weather-info-service/v1/api/weather/

# 4. weather-scheduler-service

It fetches the all the users with their configurations and send notifications through Email/SMS/Application
as per their threshold values.

All the notifications sends as an asynchronous way to improve the performance of the application

API calls are based on CITY based rather USER based to reduce the API calls hits and performance/cost



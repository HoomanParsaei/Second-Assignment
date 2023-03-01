# Weather App Assignment Report

## Introduction
- In this project , I have bulit program that shows the weather data of any city in world

## Git
1. I download Git Bash
2. I create github account with email and name and password
3. I fork "Second Assignment" to your repository
4. I initialize  a branch named "Develop"
5. I get SSH key from github to clone a GitHub my code
6. I open Git Bash and use this instruction "git@github.com:cameronmcnz/spock-lizard-docker.git"
7. Now my work with git was finish and I should push when my assingment was finish

## Server and API
1. I sign up in "WatherApi" and get my API key
2. Then the users can use it to send a city name and GET weather data of city
3. The program first wait to user send one city that found in world (if the city does not exsit wait to user send another city)
4. If the city exsits program,parse the JSON data that has been sent from server

## Explain Code
1. In "getWeatherData" function first we received data from server with Api Key with connecting to server and request "GET"
2. Then we use BufferedReader to read data from server
3. Then we use StringBuilder to get input from use and if the name of city is not valid return null
4. In "getTemperature" function we use result from "getWeatherData" function and create JSON Object that received data from server with "current" and get temperature in celcius with key "temp_c" and return degree
5. In "getHumidity" function we use result from "getWeatherData" function and create JSON Object that received data from server with "current" and get humidity with key "humidity" and return hum
6. In "getwindSpeed" function we use result from "getWeatherData" function and create JSON Object that received data from server with "current" and get windSpeed in kilometer per hour with key "wind_kph" and return speed
7. In "getWindDirection" function we use result from "getWeatherData" function and create JSON Object that received data from server with "current" and get WindDirection with key "wind_dir" and return direction
8. In all of upper function if the enterance data is not ok return null
9. In main function first we declare and initialize string weather and city
10. After we check if the city is valid we show (1-Humidity 2-Temperature 3-Wind Speed 4-Wind Direction) and if the city is not valid first we clear terminal and again take input from user

## Testing and Evaluation
- I first tryed to give some name of city to see program can handle the expected input or no;After that I send random string to check unexpected input from use
- I also checked API service is case-sensitive or no and I see it was not case-sensitive

## Add In Future
- The GUI added in future very soon



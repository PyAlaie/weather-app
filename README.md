
# The God We Trust

![mamamia](logo.png)

# Second Assignment Report

# Arshia Alaei 401222004

## Introduction

- In this project, I have built a simple terminal-based program, that shows the weather data of a given city, using a free weather API.

## Design and Implementation

- The Project is written in JAVA programming language and uses Apache Maven as its build automation. The implementation is simple: I used a service called "WatherAPI" that provides a free restful API for public use. All you have to do is to sign up there and get your very own API Key; Then you can use it to send a GET request and the server will send back weather data of the given city name in the headers, in JSON format.

- JSON (which stands for JavaScript Object Notation) is a well-known data transfer format that stores data in a human-readable key-value manner, such that you can easily access the value by calling the related key.

- The program first promotes the city name from the user and then checks that if the city exsits: it first trys to send a GET request to the API service and see if the response code is 200 (which means the city exists) or it's 400 (which means there is no such city in the API service). Then, if the city exsits, program will parse the JSON data that has been sent from the server and show the weather data to the user; and if the response code was 400, an error message will be printed in the terminal.

## Testing and Evaluation

- I first tryed to give random strings as the name of the city to see if the program can handle the unexpected input. As it was explaned in the section above, I first check that if the given city name exsits (using a try-catch statment) and then, if it did, then the program would parse the JSON data and print it in the terminal.
- I also checked if the API service is case-sensitive, and it was not, so I did'nt have to do aything about that.

## Conclusion

- This is just a simple terminal-based weather program and it could be improved a lot. Some of the improvments and features that could be added to the program is a GUI, a daily report of weather for the user, and presenting more data (such as Air Quality Index and Min and Max Temperatures of the day).

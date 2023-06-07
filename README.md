# Bookish
> The Kotlin Android app to read books in Cloud(in theory) or locally
> 
> View the code [_here_](https://github.com/AKushch1337/Bookish/tree/master/app/src).
> 
> View the design doc [_here_](https://docs.google.com/document/d/1qnaJQZAas_YInUklZ8cCjC-hOtiTIzA8HYjtcKa0vN8/edit#)
-------------------------------
## General Information
- The application is a book reader. 
- Supported doc formats will be: PDF, EPUB(maybe).
- Ambition to add cloud syncing and Google auth using Firebase 
- Minimum supported Android Version is **7.0**



## Technologies Used
- IDE: Android Studio
- Language: Kotlin
- Other instruments:
   - Jetpack Compose
   - Navigation Compose
   - Coil
   - Firebase
      - Google authorization
      - Cloud
   - [Bouquet](https://github.com/GRizzi91/bouquet) framework
   - Tests(UI Tests)
      - jUnit4
      - Compose UI testing tools
      - Espresso

## Build the project yourself

- Clone the project

- Move into the project directory

- Build the project using Gradle Wrapper
 ```gradle
./gradlew build
``` 
- Or build it using Android Studio(that way you will run the app also!)

## Run the project(easier way)

- Download the APK from release page(can't right now)

- Or run it using Android Studio


<!-- ## Screenshots
![Game screenshot](app/src/main/res/drawable/example1.png)
![Game screenshot](app/src/main/res/drawable/example2.png)

![Game screenshot](app/src/main/res/drawable/example3.png)
![Game screenshot](app/src/main/res/drawable/example4.png)
-->

## Project Status
Project is: _in early development_

## To Do

To do:
- Add more supported formats of documents
- Implement ROOM database to save the docs and be able to put them in different lists
- Add support for dark theme
- Add Google sign in
- Make the settings and lists tab actually useful!
- Not in near future, but: add cloud syncing between different devices

## Contact
Created by Artem Kushch - [My Telegram](https://telegram.me/omegalulist) - feel free to contact me!

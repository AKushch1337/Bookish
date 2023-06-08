# Bookish
> The Kotlin Android app to read books in Cloud(in theory) or locally
> 
> View the code [_here_](https://github.com/AKushch1337/Bookish/tree/master/app/src).
> 
> View the design doc [_here_](https://docs.google.com/document/d/1qnaJQZAas_YInUklZ8cCjC-hOtiTIzA8HYjtcKa0vN8/edit#)
> 
> View the UI test file [_here_](https://github.com/AKushch1337/Bookish/blob/master/app/src/androidTest/java/com/example/bookish/UITest.kt)
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

## Build & Run the project yourself

- Clone the project
```
git clone https://github.com/AKushch1337/Bookish
```

- Move into the project directory
```
cd /path/to/project
```

- Build the project using Gradle Wrapper
 ```gradle
./gradlew build
``` 
- Or build it using Android Studio(that way you will run the app also!)

- Easiest way: just [download](https://github.com/AKushch1337/Bookish/releases/download/v0.1.0-alpha/Bookish.apk) the APK from the release page

## Run instrumented tests(UI tests):

- Run an AVD(Android Virtual Device) or connect your own device to the computer

- In project folder run the following command
```gradle
./gradlew connectedAndroidTest 
```
- See the magic happen


## Screenshots of the app(for now)
<img src="https://github.com/AKushch1337/Bookish/assets/89732075/54c4bca6-e7bf-47e7-b684-126195c0d46f" alt= “” width="40%" height="40%">
<img src="https://github.com/AKushch1337/Bookish/assets/89732075/ddded284-6042-403c-be9a-862348abc5fa" alt= “” width="40%" height="40%">
<img src="https://github.com/AKushch1337/Bookish/assets/89732075/79377131-293e-467b-b384-c082bf5b96bd" alt= “” width="40%" height="40%">
<img src="https://github.com/AKushch1337/Bookish/assets/89732075/bd7e5aac-7f98-46cc-a82e-a6a4770d8e8f" alt= “” width="40%" height="40%">

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

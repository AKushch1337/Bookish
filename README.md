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

- Easiest way: just download the APK from the release page(will be available later)

## Run instrumented tests(UI tests):

- Run an AVD(Android Virtual Device) or connect your own device to the computer

- In project folder run the following command
```gradle
./gradlew connectedAndroidTest 
```
- See the magic happen


## Screenshots of the app(for now)
![image](https://github.com/AKushch1337/Bookish/assets/89732075/0d80fdbc-a4dd-460c-b17e-aa582a91ef56)
![image](https://github.com/AKushch1337/Bookish/assets/89732075/3e5a4bd4-d6d3-4dd0-9da7-8b617eaa363a)
![image](https://github.com/AKushch1337/Bookish/assets/89732075/ab775124-94e8-484c-a887-7b1baf75f5a6)

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

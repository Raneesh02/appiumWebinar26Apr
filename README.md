
Appium Android Automation Setup (Java 17 + Maven + TestNG)

This guide walks you through setting up Appium with Android Emulator, using Java 17, Maven, and TestNG for local Android automation testing on Windows and macOS.

---

1. Install Java 17

- Download Java 17 (JDK) from:  
  https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

For macOS:  
- Set JAVA_HOME in your shell configuration file (.zshrc or .bash_profile):
  export JAVA_HOME=$(/usr/libexec/java_home -v 17)
  export PATH=$JAVA_HOME/bin:$PATH

For Windows:
- Go to System Properties → Environment Variables.
- Add a new system variable:  
  JAVA_HOME → Path to your JDK folder (e.g., C:\Program Files\Java\jdk-17).
- Edit the Path variable and add:  
  %JAVA_HOME%\bin.

---

2. Install Apache Maven

- Download Maven from:  
  https://maven.apache.org/download.cgi

For macOS/Linux:  
- Set the environment variables in your shell profile (.zshrc or .bash_profile):
  export MAVEN_HOME=/path/to/apache-maven
  export PATH=$MAVEN_HOME/bin:$PATH

For Windows:
- Set a system environment variable:  
  MAVEN_HOME → Path to the Maven folder (e.g., C:\apache-maven-3.9.0).
- Edit the Path variable and add:  
  %MAVEN_HOME%\bin.

Verify Maven Installation:
- Open a terminal or command prompt and run:
  mvn -version

---

3. Install Node.js

- Download Node.js (LTS) from:  
  https://nodejs.org/en/download

Verify Installation:
- Run the following commands:
  node -v
  npm -v

---

4. Install Appium Server

- Install Appium globally using npm:
  npm install -g appium

Start the Appium Server:
- In your terminal or command prompt, run:
  appium

---

5. Install Appium Inspector (Optional)

- Download Appium Inspector from:  
  https://github.com/appium/appium-inspector/releases

---

6. Install Android Studio

- Download Android Studio from:  
  https://developer.android.com/studio

After Installing Android Studio:
1. Open Android Studio and go to SDK Manager.
2. Install SDK Tools for API level 30 or higher.
3. Open AVD Manager and create an Android Virtual Device (AVD).

---

7. Create Android Emulator

1. Open Android Studio → Tools → AVD Manager.
2. Create a new virtual device (e.g., Pixel 5).
3. Select the system image (e.g., API 30).
4. Start the Emulator.

Verify Emulator is Running:
- Open a terminal and run:
  adb devices

---

8. Run Test
   Just Right click test and run it (would require TestNG Plugin for it)
   Other way is to do a configuration for surefire-test, make testNGxml and then run mvn-test


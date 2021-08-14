#!/usr/bin/env bash

FILENAME="rPiMS.jar"
BUILDPATH="build/libs"

stopApp(){
  echo "Killing app"
  ssh pi@192.168.0.101 "cd public; sh ./starter.sh stop"
  echo "RiP - $FILENAME"
}

build_project(){
  echo "Building"
  sh ./gradlew clean build
  echo "Build completed"
}

rename_file(){
  echo "Renaming to $FILENAME"
  cp $BUILDPATH/main-0.0.1-SNAPSHOT.jar $BUILDPATH/$FILENAME
}

copy_file(){
  echo "Moving file to RaspberryPi"
  mv $BUILDPATH/$FILENAME z:/
  echo "Operation completed"
}

startApp(){
  echo "Starting App"
  ssh pi@192.168.0.101 "cd public; sh ./starter.sh start"
  echo "App started"
}

moveToPi(){
  echo "Starting script"
  stopApp
  build_project
  rename_file
  copy_file
  startApp
}

moveToPi
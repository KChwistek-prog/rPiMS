#!/usr/bin/env bash
BUILDFILE="rPiMS-Driver-0.0.1-SNAPSHOT.jar"
FILENAME="rPiMS.jar"
BUILDPATH="build/libs"
SSHADDRESS="pi@192.168.0.105"

stopApp(){
  echo "Killing app"
  ssh $SSHADDRESS "cd public; sh ./starter.sh stop"
  echo "RiP - $FILENAME"
}

build_project(){
  echo "Building"
  sh ./gradlew clean build
  echo "Build completed"
}

rename_file(){
  echo "Renaming to $FILENAME"
  cp $BUILDPATH/$BUILDFILE $BUILDPATH/$FILENAME
}

copy_file(){
  echo "Moving file to RaspberryPi"
  scp.exe build/libs/rPiMS.jar pi@192.168.0.105://home/pi/public
  echo "Operation completed"
}

startApp(){
  echo "Starting App"
  ssh $SSHADDRESS "cd public; sh ./starter.sh start"
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

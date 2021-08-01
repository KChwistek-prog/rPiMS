#!/usr/bin/env bash

FILENAME="rPiMS.jar"

rename_file(){
  echo "Renaming to $FILENAME"
  cp build/libs/main-0.0.1-SNAPSHOT.jar build/libs/$FILENAME
}
copy_file(){
  echo "Moving file to RaspberryPi"
  mv build/libs/$FILENAME z:/
}

echo "Starting"
rename_file
copy_file
echo "Operation completed"
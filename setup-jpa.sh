#!/bin/bash

if [ "$1" == "" ]; then
  exit 0
fi

cd $HOME

if [ -d "formacao-jpa" ]; then
  echo "removendo formacao-jpa"
  rm -rf formacao-jpa
fi

git clone https://github.com/wapmesquita/formacao-jpa.git

cd formacao-jpa

for f in *; do
  if [ ! "$f" == "$1" ]; then 
    echo $f
    rm $f -rf
  fi
done

mv $1/* .

rm $1 -rf

mvn clean install eclipse:eclipse

#!/bin/sh

dir=$(cd -P -- "$(dirname -- "$0")" && pwd -P)
cd ${dir}

echo ----------Pulling latest versions-----------------
docker pull selenium/hub
docker pull selenium/node-chrome
#docker pull selenium/standalone-firefox
docker pull selenium/node-firefox
#docker pull selenium/standalone-chrome

#echo ----------Removing all unused objects-------------
#docker system prune

echo  ----------Starting Dockers-----------------------
docker-compose up -d
#for scaling a number of dockers
docker-compose scale FF=2
docker-compose scale CH=2

echo -----------Create configuration------------------
appip=`ip addr show |grep "inet " |grep -v 127.0.0. |head -1|cut -d" " -f6|cut -d/ -f1`
echo "Application available at: " $appip

hubip=`docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' hub`
echo "Selenium Grid Hub available at: " $hubip

cd ..
cd ..
#for bugstore app deployed on the localhost
#echo "baseURL = http://"$appip":8080" > cfg.properties

#for google tests
echo "baseURL = http://www.google.at" > cfg.properties
echo "hubURL = http://"$hubip":4444/wd/hub" >> cfg.properties



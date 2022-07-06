@echo off
set dir=%cd%
cd %dir%

echo ----------Pulling latest versions-----------------
docker pull selenium/hub
REM docker pull selenium/standalone-firefox
docker pull selenium/node-chrome
REM docker pull selenium/standalone-chrome
docker pull selenium/node-firefox

REM echo ----------Removing all unused objects-------------
REM docker system prune

echo  ----------Starting Dockers-----------------------
docker-compose up -d
REM for scaling a number of dockers
docker-compose scale FF=2
docker-compose scale CH=2

echo -----------Create configuration------------------

for /F "tokens=2 delims=:" %%i in ('"ipconfig | findstr IP | findstr : "') do SET LOCAL_IP=%%i
set appip=%LOCAL_IP: =%
echo Application available at: %appip%  

for /f %%i in ('docker inspect -f "{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}" hub') do set hubip=%%i
echo Selenium Grid Hub available at: %hubip%  

cd ..
cd ..

echo baseURL = http://%appip%:8080 > cfg.properties
echo hubURL = http://%hubip%:4444/wd/hub >> cfg.properties
pause
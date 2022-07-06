@echo off

echo ------------------Starting Cleanup-------------------
REM remove seleniumFF nodes
docker ps -qf name=FF* > test
for /F %%a IN (test) do ( 
 docker stop %%a
 docker rm %%a
echo Removing Selenium Firefox Node container : %%a
)

REM remove seleniumCH nodes
docker ps -qf name=CH* > test
for /F %%a IN (test) do ( 
 docker stop %%a
 docker rm %%a
echo Removing Selenium Chrome Node container : %%a
)

REM removes selenium Grid hub
docker ps -qf name=hub > test
for /F %%a IN (test) do ( 
 docker stop %%a
 docker rm %%a
echo Removing Selenium Hub Node container : %%a
)

del test

REM remove stopped containers, just in case
 docker system prune

REM list active dockers
echo ------------------List of active Containers-------------------
 docker ps -a

pause
#!/bin/sh

echo ------------------Starting Cleanup-------------------
# remove seleniumFF nodes
a=0
while [ "${a}" != "" ]
do
a=$(docker ps | grep "FF" | awk '{print $1}')  
if [ "${a}" != "" ]
then
b=$(docker stop ${a})
b=$(docker rm ${a})
echo Removing Selenium Firefox Node container : $a
fi
done

# remove seleniumCH nodes
a=0
while [ "${a}" != "" ]
do
a=$(docker ps | grep "CH" | awk '{print $1}')
if [ "${a}" != "" ]
then
b=$(docker stop ${a})
b=$(docker rm ${a})
echo Removing Selenium Chrome Node container : $a
fi
done

# removes selenium Grid hub
a=$(docker ps | grep "hub" | awk '{print $1}')
if [ "${a}" != "" ]
then
b=$(docker stop ${a})
b=$(docker rm ${a})
echo Removing SeleniumGrid Hub container : ${a}
fi

#removes own network
#echo Removing virtual network: $(docker network rm sgNet)
#a=$(docker network ls | grep "sgNet" | awk '{print $1}')
#if [ "${a}" != "" ]
#then
#echo Removing Docker Network : $(docker network rm sgNet)
#fi

#remove stopped containers, just in case
docker system prune

#list active dockers
echo ------------------List of active Containers-------------------
docker ps -a

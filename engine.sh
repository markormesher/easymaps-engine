#!/bin/bash

# check JAR file
if [ ! -f "build/libs/easymaps-engine-1.0.0.jar" ]; then
	echo "No EasyMaps engine file found!"
	exit 1
fi

# check option file
option=""
if [ "$#" == 1 ]; then
	dataset=$1
	if [ -f "datasets/$dataset/options.txt" ];then
		option="datasets/$dataset/options.txt"
	else
		echo "No option file found at datasets/$dataset/options.txt"
		exit 1
	fi
fi

# go!
java -jar "build/libs/easymaps-engine-1.0.0.jar" "$option"

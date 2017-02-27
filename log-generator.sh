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
	if [ -f "datasets/$dataset/log-generator-options.txt" ];then
		option="datasets/$dataset/log-generator-options.txt"
	elif [ -f "datasets-real/$1/log-generator-options.txt" ]; then
		option="datasets-real/$1/options.txt"
	else
		echo "No log generator option file found at datasets/$dataset/log-generator-options.txt"
		exit 1
	fi
fi

# go!
java -jar "build/libs/easymaps-engine-1.0.0.jar" "--log-generator" "$option" $@

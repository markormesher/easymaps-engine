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
	if [ -f "datasets/$dataset/walker-options.txt" ];then
		option="datasets/$dataset/walker-options.txt"
	else
		echo "No walker option file found at datasets/$dataset/walker-options.txt"
		exit 1
	fi
fi

# go!
java -jar "build/libs/easymaps-engine-1.0.0.jar" --walker "$option"

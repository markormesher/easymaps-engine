#!/bin/bash

# check JAR file
if [ ! -f "build/libs/easymaps-engine-1.0.0.jar" ]; then
	echo "No EasyMaps engine file found!"
	exit 1
fi

# check option file
option=""
if [ -f "datasets/$1/options.txt" ]; then
	option="datasets/$1/options.txt"
elif [ -f "datasets-real/$1/options.txt" ]; then
	option="datasets-real/$1/options.txt"
fi

# go!
java -jar "build/libs/easymaps-engine-1.0.0.jar" "--engine" "$option" $@

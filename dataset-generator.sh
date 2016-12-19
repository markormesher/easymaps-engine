#!/bin/bash

# check JAR file
if [ ! -f "build/libs/easymaps-engine-1.0.0.jar" ]; then
	echo "No EasyMaps engine file found!"
	exit 1
fi

# go!
java -jar "build/libs/easymaps-engine-1.0.0.jar" "--dataset-generator"

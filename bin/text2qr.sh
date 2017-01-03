#! /bin/sh
# $1: text
# $2: output filename

java -jar build/libs/text2qr-all.jar "$1" "$2"

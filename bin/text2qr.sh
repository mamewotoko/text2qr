#! /bin/sh
# $1: text
# $2: output filename

MYDIR=$(realpath $(dirname "$0"))

java -jar $MYDIR/../build/libs/text2qr-all.jar "$1" "$2"

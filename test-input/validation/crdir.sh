#!/bin/bash
declare -i dir
dir=0118
for number in {134..149}
do
echo $number
echo $dir
exec `cp -r nv0$dir nv0$number`
dir=dir+1
done
exit 0

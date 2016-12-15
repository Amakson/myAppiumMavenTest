#!/bin/sh
APPIUMLOG=$1
COMPLETEDFILEPATH=$2
previouscount=0
while [ 	! -f $COMPLETEDFILEPATH ]
do
echo “Listening..”
currentcount=$(($(cat $APPIUMLOG | wc -l) + 1))
echo $currentcount

if [ $currentcount = $previouscount ];
then
pkill ios_webkit_debug_proxy
killall node
break
else
echo $previouscount
previouscount=$currentcount
echo $previouscount
fi
sleep 15
if [ -r $APPIUMLOG ]; then
if grep -m1  "ReportCrash" $APPIUMLOG ; then
pkill ios_webkit_debug_proxy
killall node
break
else
echo Continue
fi
else
echo file doesnot exist
fi
done
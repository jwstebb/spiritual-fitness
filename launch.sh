#!/bin/bash

sudo ln -s -i -f -v /etc/emulator64-x86 /etc/emulator

export LD_LIBRARY_PATH=/Users/jwstebb/projects/android/adtBundleMac/sdk/tools/lib
~/projects/android/adtBundleMac/sdk/tools/emulator -avd JesseNexus50 -netspeed full -netdelay none
#~/projects/android/adtBundleMac/sdk/tools/emulator -avd Jesse_Tablet -netspeed full -netdelay none
#!/bin/sh
GITHUB=SeAnd2016
WS_DIR=Workspace
REPO=Java_HW_38_Test_Automation_Plan
VERSION=1.0
# =======================================
if ! which java >/dev/null 2>&1; then echo Java not installed; return fi
if ! which mvn >/dev/null 2>&1; then echo Maven not installed; return fi
if ! which git >/dev/null 2>&1; then echo Git not installed; return fi
if [ -d "$HOME/$WS_DIR" ]; then cd ~/$WS_DIR; else echo $WS_DIR is not exist; return; fi
if [ -d "$HOME/$WS_DIR/$REPO ]; then mv $HOME/$WS_DIR/$REPO $HOME/$WS_DIR; fi
git clone https://github.com/$GITHUB/$REPO.git
cd./$REPO
mvn clean site -Dtest_suite=$1 -Dpassword=$2

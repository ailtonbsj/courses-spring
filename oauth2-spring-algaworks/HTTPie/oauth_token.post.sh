#!/bin/bash

ID="demoapp"
SECRET="secretapp"
USER="demo"
PASS="123"

http -f POST :8080/oauth/token \
username="$USER" \
password="$PASS" \
grant_type="password" \
-a $ID:$SECRET
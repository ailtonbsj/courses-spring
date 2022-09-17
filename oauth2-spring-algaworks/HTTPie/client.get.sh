#!/bin/bash

TOKEN=$(./oauth_token.post.sh | grep { | cut -d\" -f4)
http -A bearer -a $TOKEN :8080/client
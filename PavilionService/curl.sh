#!/usr/bin/env bash

curl -F 'client_id=a60a41e5bc3d440e9ddb6f50160df41b' \
    -F 'client_secret=4ee366e72df84bd4be5765691ab53f04' \
    -F 'grant_type=authorization_code' \
    -F 'redirect_uri=http://localhost:3000/redirect' \
    -F 'code=de4327b9507d409aad6ec3000d20efb0' \
    https://api.instagram.com/oauth/access_token
    echo "\n"

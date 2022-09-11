# HISTORY OF COMMANDS

```bash
# Do login and get tokens
http --form POST :8080/api/login username='admin' password='pass'

# Using token
TOKEN="YOUR_TOKEN_HERE"
http :8080/api/users "Authorization:Bearer $TOKEN"

echo '{"name":"Demo","username":"demo","password":"demo"}' | \
http POST :8080/api/user/save "Authorization:Bearer $TOKEN"
```
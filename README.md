# App Resource
This project is resource app IFTO.



## Generate Public Key
It's necessary send GET request to OAuth-api endpoint `/oauth/token_key` 
information client id and secret id by header request. 
So, your get the value of the response body field `value` and create a new
file (with name public-key.pem) at directory in resource project `store/key` 
with value response body `value`  

**Note: Replace all `\n` to break line of content file.**

# BankAccount

# Overview

[Login page](img/Screenshot_1614982902.png)

The main activity is login page.
You can log with :
	Username : Jean
	Password : superPASSWORD1234

[Main page](img/Screenshot_1614982929.png)

Once you are logged you can see the balance of the selected account.

[Select account](img/Screenshot_1614982931.png)
[Select account](img/Screenshot_1614982936.png)

You can select another account using the spinner.

# Security aspect

The user's login data (username/password) are sha256 hashed. Since this can't be reverted the only way to retrieve the login/password pair is by brute forcing it. So the guarantee that the user is the right one only depends on the strongness of the password.

The API url is Base64 encoded. If you find the encoded url the base64 encoding is pretty obvious and the reversing process is easy.

All the communications with the API are HTTPS based.
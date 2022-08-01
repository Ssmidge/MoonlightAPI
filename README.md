# MoonlightAPI
APIs for Moonlight

Endpoints:

Endpoint types:
```
Admin
User
```
Admin Endpoints:
```
All admin endpoints start with /admin/ so it wont be added

/create - POST - Creates a license key with body param of licensekey, discordid and licensetype (not required, it will default to "Release")
/delete - POST - Deletes a license key with a body param of licensekey (COMING SOON)
```
User Endpoints:
 ```
All user endpoints start with /user/ so it wont be added

/check - POST - Checks if a license key is valid, body params are licensekey and discord id (RETURNS JSON)
/resethwid - POST - Resets HWID if the timer cooldown has expired (cooldown is in config with amount of days by default), has body param of licensekey, discordid and new HWID
/resetip - POST - Resets IP to one specified in body or just the one in the request if the timer cooldown has expired (cooldown is in config with amount of days by default), has body param of licensekey, discordid and new IP (if specified)
```

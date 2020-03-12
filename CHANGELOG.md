# Changelog

## 1.4.0
- Breaking: Removed init() Method and init over Variables
- Uninstall Plugin: `cordova plugin remove cordova-plugin-secure-preferences`
- Reinstall with Variables: `cordova plugin add cordova-plugin-secure-preferences --variable FILE_NAME=filename --variable PASSWORD=password`

## 1.3.0
- putString() added
- remove() fixed
- breaking: init() Method must be called first, to not recreate the SP-Object every Time 

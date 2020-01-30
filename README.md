# cordova-plugin-secure-preferences

This Plugin is a Wrapper for [Secure Preferences](https://github.com/scottyab/secure-preferences).

## Supports

This Plugin only works for Android

## Requirements

- cordova >= 7.1.0
- cordova-android >= 6.3.0

## Usage

### GetString
```
SecurePreferences.getString('password', 'sharedPrefFilename', 'key',
    function(succes) {
        // success
    }, funtion(error) {
        // error
    });
```

### Remove
```
SecurePreferences.remove('password', 'sharedPrefFilename', 'key',
    function() {
        // success
    }, funtion(error) {
        // error
    });
```


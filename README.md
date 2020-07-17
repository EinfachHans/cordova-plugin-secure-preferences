# cordova-plugin-secure-preferences [![npm version](https://badge.fury.io/js/cordova-plugin-secure-preferences.svg)](https://badge.fury.io/js/cordova-plugin-secure-preferences)

This Plugin is a Wrapper for [Secure Preferences](https://github.com/scottyab/secure-preferences).

## Supports

This Plugin only works for Android

## Requirements

- cordova >= 7.1.0
- cordova-android >= 6.3.0

## Installation

### Variables

- FILE_NAME (The SharedPref File Name)
- Password (The Password of the File)

`cordova plugin add cordova-plugin-secure-preferences --variable FILE_NAME=filename --variable PASSWORD=password`

## Usage

### GetString
```
SecurePreferences.getString('key',
    function(succes) {
        // success
    }, funtion(error) {
        // error
    });
```

### PutString
```
SecurePreferences.putString('key', 'value',
    function(succes) {
        // success
    }, funtion(error) {
        // error
    });
```

### Remove
```
SecurePreferences.remove('key',
    function() {
        // success
    }, funtion(error) {
        // error
    });
```


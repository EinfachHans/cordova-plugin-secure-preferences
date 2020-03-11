var exec = cordova.require('cordova/exec');

exports.init = function (password, sharedPrefFilename, resultCallback) {

  exec(resultCallback, null,
    "SecurePreferencesServices",
    "init",
    [password, sharedPrefFilename]);
};

exports.getString = function (key, resultCallback, errorCallback) {

  exec(resultCallback, errorCallback,
    "SecurePreferencesServices",
    "getString",
    [key]);
};

exports.putString = function (key, value, resultCallback, errorCallback) {

  exec(resultCallback, errorCallback,
    "SecurePreferencesServices",
    "putString",
    [key, value]);
};

exports.remove = function (key, resultCallback, errorCallback) {

  exec(resultCallback, errorCallback,
    "SecurePreferencesServices",
    "remove",
    [key]);
};





var exec = cordova.require('cordova/exec');

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





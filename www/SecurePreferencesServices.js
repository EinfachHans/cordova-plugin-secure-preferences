var exec = cordova.require('cordova/exec');

exports.getString = function (password, sharedPrefFilename, key, resultCallback, errorCallback) {

  exec(resultCallback, errorCallback,
    "SecurePreferencesServices",
    "getString",
    [password, sharedPrefFilename, key]);
};

exports.remove = function (password, sharedPrefFilename, key, resultCallback, errorCallback) {

  exec(resultCallback, errorCallback,
    "SecurePreferencesServices",
    "remove",
    [password, sharedPrefFilename, key]);
};





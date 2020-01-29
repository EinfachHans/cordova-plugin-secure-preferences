var plugin = function () {
  return window.SecurePreferencesServices;
};
var SecurePreferencesServices = /** @class */ (function () {
  function SecurePreferencesServices() {
  }

  SecurePreferencesServices.getString = function (password, sharedPrefFilename, key, success, failure) {
    var plu = plugin();
    return plu.getString.apply(plu, arguments);
  };
  return SecurePreferencesServices;
}());
export default SecurePreferencesServices;

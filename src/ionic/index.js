var plugin = function () {
  return window.SecurePreferencesServices;
};
var SecurePreferencesServices = /** @class */ (function () {
  function SecurePreferencesServices() {
  }

  SecurePreferencesServices.getString = function (key, success, failure) {
    var plu = plugin();
    return plu.getString.apply(plu, arguments);
  };

  SecurePreferencesServices.putString = function (key, value, success, failure) {
    var plu = plugin();
    return plu.putString.apply(plu, arguments);
  };

  SecurePreferencesServices.remove = function (key, success, failure) {
    var plu = plugin();
    return plu.remove.apply(plu, arguments);
  };

  return SecurePreferencesServices;
}());
export default SecurePreferencesServices;

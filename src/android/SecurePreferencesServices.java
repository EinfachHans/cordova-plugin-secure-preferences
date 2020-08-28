package de.einfachhans.SecurePreferences;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.securepreferences.SecurePreferences;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class SecurePreferencesServices extends CordovaPlugin {

    private static final String TAG = "SecurePreferencesServices";

    private static final String ACTION_GET_STRING = "getString";
    private static final String ACTION_PUT_STRING = "putString";
    private static final String ACTION_REMOVE = "remove";
    private SecurePreferences sp;
    private Context context;

    public SecurePreferencesServices() {
    }

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.context = this.cordova.getActivity().getApplicationContext();
        Resources res = this.context.getResources();

        int sharedPrefFilenameId = res.getIdentifier("sp_file_name", "string", this.context.getPackageName());
        int passwordId = res.getIdentifier("sp_password", "string", this.context.getPackageName());

        String sharedPrefFilename = res.getString(sharedPrefFilenameId);
        String password = res.getString(passwordId);

        if (this.init(sharedPrefFilename, password)) {
            Log.d(TAG, "Initialized");
        } else {
            Log.d(TAG, "Failed to initialized");
        }
    }

    private boolean init(String sharedPrefFilename, String password) {
        if (password == null || password.equals("null")) {
            Log.d(TAG, "Please provide a Password in the Plugins Variable");
            return false;
        }

        if (sharedPrefFilename == null || sharedPrefFilename.equals("null")) {
            Log.d(TAG, "Please provide the sharedPrefFilename in the Plugins Variable");
            return false;
        }

        this.sp = new SecurePreferences(this.cordova.getActivity().getApplicationContext(), password, sharedPrefFilename);
        return true;
    }

    /**
     * Executes the request.
     * <p>
     * This method is called from the WebView thread. To do a non-trivial amount of work, use:
     * cordova.getThreadPool().execute(runnable);
     * <p>
     * To run on the UI thread, use:
     * cordova.getActivity().runOnUiThread(runnable);
     *
     * @param action          The action to execute.
     * @param args            The exec() arguments.
     * @param callbackContext The callback context used when calling back into JavaScript.
     * @return Whether the action was valid.
     */
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d(TAG, "ACTION: " + action);

        if (this.sp == null) {
            callbackContext.error("The Secured Preferences was not initialized!");
            return false;
        }

        if (action.equalsIgnoreCase(ACTION_GET_STRING)) {
            String key = args.getString(0);

            if (key == null || key.equals("null")) {
                callbackContext.error("The Key is required");
                return true;
            }

            try {
                if (sp.contains(key)) {
                    callbackContext.success(sp.getString(key, null));
                } else {
                    callbackContext.error("The Key doesn't exists");
                }
            } catch (Exception ex) {
                callbackContext.error(ex.getMessage());
            }
            return true;
        } else if (action.equalsIgnoreCase(ACTION_PUT_STRING)) {
            String key = args.getString(0);
            String value = args.getString(1);

            if (key == null || key.equals("null")) {
                callbackContext.error("The Key is required");
                return true;
            }

            try {
                sp.edit().putString(key, value).commit();
                callbackContext.success();
            } catch (Exception ex) {
                callbackContext.error(ex.getMessage());
            }
            return true;
        } else if (action.equalsIgnoreCase(ACTION_REMOVE)) {
            String key = args.getString(0);

            if (key == null || key.equals("null")) {
                callbackContext.error("The Key is required");
                return true;
            }

            try {
                sp.edit().remove(key).commit();
                callbackContext.success();
            } catch (Exception ex) {
                callbackContext.error(ex.getMessage());
            }
            return true;
        }
        return false;
    }
}

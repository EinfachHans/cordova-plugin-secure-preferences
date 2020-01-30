declare module 'cordova-plugin-secure-preferences' {

    export default class SecurePreferencesServices {
        static getString(password: string, sharedPrefFilename: string, key: string, success: (state: string) => void, error: (error: any) => void): void;

        static remove(password: string, sharedPrefFilename: string, key: string, success: () => void, error: (error: any) => void): void;
    }
}

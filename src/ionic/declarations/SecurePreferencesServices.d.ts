declare module 'cordova-plugin-secure-preferences' {

    export default class SecurePreferencesServices {
        static getString(key: string, success: (state: string) => void, error: (error: any) => void): void;

        static putString(key: string, value: string, success: (state: string) => void, error: (error: any) => void): void;

        static remove(key: string, success: () => void, error: (error: any) => void): void;
    }
}

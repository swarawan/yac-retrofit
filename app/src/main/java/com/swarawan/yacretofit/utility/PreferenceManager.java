package com.swarawan.yacretofit.utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Rio Swarawan on 10/6/2015.
 */
public class PreferenceManager {

    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    public static void putString(Context context, String preferenceName, String object) {
        preferences = context.getSharedPreferences(Constant.PREFERENCE, 0);
        editor = preferences.edit();

        editor.putString(preferenceName, object).apply();
    }

    public static void putInt(Context context, String preferenceName, int object) {
        preferences = context.getSharedPreferences(Constant.PREFERENCE, 0);
        editor = preferences.edit();

        editor.putInt(preferenceName, object).apply();
    }

    public static void putBool(Context context, String preferenceName, boolean object) {
        preferences = context.getSharedPreferences(Constant.PREFERENCE, 0);
        editor = preferences.edit();

        editor.putBoolean(preferenceName, object).apply();
    }

    public static String getString(Context context, String preferenceName, String defaultValue) {
        preferences = context.getSharedPreferences(Constant.PREFERENCE, 0);
        editor = preferences.edit();

        return preferences.getString(preferenceName, defaultValue);
    }

    public static int getInt(Context context, String preferenceName, int defaultValue) {
        preferences = context.getSharedPreferences(Constant.PREFERENCE, 0);
        editor = preferences.edit();

        return preferences.getInt(preferenceName, defaultValue);
    }

    public static boolean getBool(Context context, String preferenceName, boolean defaultValue) {
        preferences = context.getSharedPreferences(Constant.PREFERENCE, 0);
        editor = preferences.edit();

        return preferences.getBoolean(preferenceName, defaultValue);
    }

    public static void remove(Context context, String preferenceName) {
        preferences = context.getSharedPreferences(Constant.PREFERENCE, 0);
        editor = preferences.edit();
        editor.remove(preferenceName).apply();
    }

    public static void clearPreference(Context context) {
        preferences = context.getSharedPreferences(Constant.PREFERENCE, 0);
        editor = preferences.edit();
        editor.clear().apply();
    }
}

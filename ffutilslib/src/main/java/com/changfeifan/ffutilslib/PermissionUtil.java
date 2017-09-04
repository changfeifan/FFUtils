package com.changfeifan.ffutilslib;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by cff on 2016/6/11 0011.
 */
public class PermissionUtil {

    public static boolean isAfterSDK23() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    public static boolean check(Activity activity, @NonNull String permission) {
        if (isAfterSDK23()) {
            return activity.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    public static void request(Activity activity, @NonNull String permission, int requestCode) {
        request(activity, new String[]{permission}, requestCode, null);
    }

    public static void request(Activity activity, @NonNull String[] permissions, int requestCode) {
        request(activity, permissions, requestCode, null);
    }

    public static void request(Activity activity, @NonNull String permission, int requestCode, String rationale) {
        request(activity, new String[]{permission}, requestCode, rationale);
    }

    @TargetApi(23)
    public static void request(Activity activity, @NonNull String[] permissions, int requestCode, String rationale) {
        if (!isAfterSDK23())
            return;

        if (!TextUtils.isEmpty(rationale)) {
            if (activity.shouldShowRequestPermissionRationale(permissions[0])) {
                Toast.makeText(activity, rationale, Toast.LENGTH_SHORT).show();
            }
        }
        activity.requestPermissions(permissions, requestCode);
    }
}

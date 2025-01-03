package com.roger.test.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.util.Log;

import androidx.core.content.FileProvider;

import com.blankj.utilcode.util.ToastUtils;

import java.io.File;
import java.io.IOException;

public class ApkUtil {


    //  val target = File(externalCacheDir, "apks/app-release.apk")
    public static void installApk(Context context, File apkFile) {
        if (apkFile.exists()) {
            Intent apkInStallIntent = getApkInStallIntent(context, apkFile);
            context.startActivity(apkInStallIntent);
        } else {
            ToastUtils.showShort("文件不存在");
        }
    }

    public static Intent getApkInStallIntent(Context context, File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        try {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".update.provider", apkFile);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
        } catch (Exception e) {
            ToastUtils.showShort("安装失败，请重新安装");
        }
        return intent;
    }



    private static Uri getApkUri(File apkFile) {
        Log.d("apk install", apkFile.toString());
        //如果没有设置 SDCard 写权限，或者没有 SDCard,apk 文件保存在内存中，需要授予权限才能安装
        try {
            String[] command = {"chmod", "777", apkFile.toString()};
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
        } catch (IOException ignored) {
        }
        Uri uri = Uri.fromFile(apkFile);
        Log.d("apk install", uri.toString());
        return uri;
    }
}

package com.android.benben.retrofitrxjava.widget;

import android.content.Context;
import android.content.DialogInterface;

/**
 * Time      2017/4/10 14:32 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class ProgressDialog {
    private static android.app.ProgressDialog progressDialog;

    public static void show(Context cxt, boolean cancelable, String str) {
        show(cxt,cancelable,str,"");

//
    }
    public static void show(Context cxt, boolean cancelable, String str,String title) {

        try {
//            if (progressDialog!=null)
//            {
//                if (progressDialog.isShowing())
//                    progressDialog.cancel();
//            }
            progressDialog = new android.app.ProgressDialog(cxt);
            progressDialog.setCancelable(cancelable);
            progressDialog.setMessage(str);
            progressDialog.setTitle(title);
            progressDialog.show();
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    progressDialog.cancel();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cancle() {
        if (progressDialog == null)
            return;
        if (progressDialog.isShowing())
            progressDialog.cancel();
    }

}

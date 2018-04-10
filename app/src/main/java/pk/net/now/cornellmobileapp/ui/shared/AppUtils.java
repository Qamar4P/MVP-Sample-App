package pk.net.now.cornellmobileapp.ui.shared;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatDialog;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import pk.net.now.cornellmobileapp.R;

/**
 * Created by Qamar on 9/7/2017.
 */

public class AppUtils {
    public static Dialog getProgressDialog(Context context){
        Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_progress);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED);
        return dialog;
    }

    public static void changeKeyboardVisibility(View view, boolean show){
        if (view == null) return;
        InputMethodManager keyboard = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (show) {
            keyboard.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }else {
            keyboard.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static String getLocalIpAddress(){
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                 en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (Exception ex) {
            Log.e("IP Address", ex.toString());
        }
        return "0.0.0.0";
    }
}

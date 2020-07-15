package com.kit.cordova.ubibot.camera.stream;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// import java.util.concurrent.BlockingDeque;
// import java.util.concurrent.LinkedBlockingDeque;
// import java.util.concurrent.TimeUnit;
// import java.util.Map;
import java.util.*;

import com.camera.api.AVAPIsClient;
import com.decode.MediaCodecDecoder;
import com.decode.tools.BufferInfo;

/**
 * This class echoes a string called from JavaScript.
 */
public class ubibot extends CordovaPlugin {
    private String UID;
    private String account;
    private String pwd;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getVersion")) {
            String message = "1.0.3";
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, message);
            callbackContext.sendPluginResult(pluginResult);
            return true;
        }
        if (action.equals("stopCameraStream")) {
            UbibotClient.stop();
            String message = args.getString(0);
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, message);
            callbackContext.sendPluginResult(pluginResult);
            return true;
        }
        if (action.equals("getCameraStream")){
            String str = args.getString(0);
            str = str.replace("[\\\"","").replace("\\\"]","");
//             String[] strArr = str.split("\\|");
            String[] strArr = str.split("\\\",\\\"");
            UID = strArr[0].replace("[","").replace("\"","");
            account = strArr[1];
            pwd = strArr[2].replace("]","").replace("\"","");
//             PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, str);
//             pluginResult.setKeepCallback(true); // keep callback
//             callbackContext.sendPluginResult(pluginResult);
//             pluginResult = new PluginResult(PluginResult.Status.OK, UID);
//             pluginResult.setKeepCallback(true); // keep callback
//             callbackContext.sendPluginResult(pluginResult);
//             pluginResult = new PluginResult(PluginResult.Status.OK, account);
//             pluginResult.setKeepCallback(true); // keep callback
//             callbackContext.sendPluginResult(pluginResult);
//             pluginResult = new PluginResult(PluginResult.Status.OK, pwd);
//             pluginResult.setKeepCallback(true); // keep callback
//             callbackContext.sendPluginResult(pluginResult);
            cordova.getThreadPool().execute(new Runnable(){
                public void run(){
                    UbibotClient.start(UID,account,pwd,callbackContext);
                }
            });
            return true;
        }
        return false;
    }
}

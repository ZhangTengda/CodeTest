package com.roger.test.util.websocket;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.roger.test.util.CommonData;
import com.roger.test.util.websocket.listener.WsStatusListener;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okio.ByteString;

public class WebSocketHelper {

    private static final WebSocketHelper webSocketHelper = new WebSocketHelper();
    private WsManager wsManager;

    private Context mContext;

    private WebSocketHelper() {
    }


    public static WebSocketHelper getInstance() {
        return webSocketHelper;
    }


    public void init(Context context, String userID) {
        mContext = context;

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .pingInterval(15, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        wsManager = new WsManager.Builder(context)
                .wsUrl("wss://customer.domain.com/prod-api/websocket/message/" + userID)
                .needReconnect(true)
                .client(okHttpClient)
                .build();

        setListener();

        wsManager.startConnect();
    }

    private void setListener() {
        if (wsManager != null) {
            wsManager.setWsStatusListener(new WsStatusListener() {
                @Override
                public void onOpen(Response response) {
                    super.onOpen(response);

                    LogUtils.d("WebSockets Manager  onOpen ");
                }

                @Override
                public void onMessage(String message) {
                    super.onMessage(message);
                    if (message != null && message.contains("连接成功")) {
                        String[] splitArray = message.split(",");
//                        if (splitArray.length > 1) {
//                            SPUtils.getInstance().put(CommonData.WEBSOCKET_ID, splitArray[0]);
//                        }
                    }
//                    Log.e("wsManager  onMessage", "收到的消息：" + message);
                    Intent intent = new Intent();
                    intent.setAction(CommonData.WEBSOCKET_BROADCAST_ACTION);
                    intent.putExtra("message", message);
                    mContext.sendBroadcast(intent);
                    LogUtils.d("WebSockets Manager  onMessage    === " + message);
                }

                @Override
                public void onMessage(ByteString bytes) {
                    super.onMessage(bytes);
                }

                @Override
                public void onReconnect() {
                    super.onReconnect();

                    LogUtils.d("WebSockets Manager  onOpen ");
                }

                @Override
                public void onClosing(int code, String reason) {
                    super.onClosing(code, reason);

                    LogUtils.d("WebSockets Manager  onClosing ");
                }

                @Override
                public void onClosed(int code, String reason) {
                    super.onClosed(code, reason);
                    LogUtils.d("WebSockets Manager  onClosed ");
                }

                @Override
                public void onFailure(Throwable t, Response response) {
                    super.onFailure(t, response);

                    LogUtils.d("WebSockets Manager  onFailure ");
                }
            });
        }
    }


    public void setWsMessage(String str) {
        if (wsManager != null) {
            wsManager.sendMessage(str);
        } else {

        }
    }


    public void stopWebSocket() {
        if (wsManager != null) {
            wsManager.stopConnect();
        } else {

        }
    }

}

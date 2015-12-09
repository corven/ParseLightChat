package cos.lightchat;

import android.app.Application;

import com.parse.Parse;

public class ChatApp extends Application {

    private final String appId = "Ваш appId",
        clientId = "Ваш clientId";
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, appId, clientId);
    }
}

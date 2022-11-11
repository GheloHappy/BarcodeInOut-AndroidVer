package MssqlCon;

import android.app.Application;

public class PublicVars extends Application {
    private static String user;

    public static void SetUser(String User) {
        user = User;
    }

    public static String GetUser(){
        return user;
    }
}

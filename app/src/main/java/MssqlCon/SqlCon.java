package MssqlCon;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlCon {
    Connection con;

    @SuppressLint("NewApi")
    public Connection SQLConnection()
    {
        String ip="192.168.1.249", port="1433", dbName="BarcodeInOut", un="sa", pass = "Passw0rd";
        StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
        String ConURL = null;

        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConURL="jdbc:jtds:sqlserver://"+ip+":"+port+";"+"databasename="+dbName+";user="+un+";password="+pass+";";
            con= DriverManager.getConnection(ConURL);

        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage());
        }

        return con;
    }
}

package MssqlCon;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import java.sql.ResultSet;
import java.sql.Statement;

import MssqlCon.PublicVars;

public class Login extends SqlCon {
    PublicVars pubVar = new PublicVars();

    public boolean CheckUser(String usr, String pass) {
        con = SQLConnection();
        try {
            if (con != null) {
                String query = "SELECT * FROM Users WHERE username ='" + usr + "' AND password = '" + pass + "'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);

                if (rs.next()) {
                    pubVar.SetUser(rs.getString(4));
                    return true;
                }

                System.out.println(query);
            }
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        return false;
    }
}

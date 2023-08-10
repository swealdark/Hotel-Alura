package com.alura.hotelalura;

import com.alura.hotelalura.factory.ConnectionFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ConnectController {
    Connection conn = new ConnectionFactory().getConnection();


    public boolean loginAuthentication(String user, String password){
        // Se conecta a la db, busca el usuario ingresado y compara las contraseñas
        // ??? falta implementar try with resources ojo
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM usuarios WHERE username = ?");
            statement.setString(1,user);
            statement.execute();
            ResultSet result = statement.getResultSet();
            System.out.println(result);
            Map<String,String> usersAutorizados = new HashMap<>();
            if(result.next()){

                boolean resp = password.equals(result.getString("password"));
                conn.close();
                return resp;

            }else{
                conn.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

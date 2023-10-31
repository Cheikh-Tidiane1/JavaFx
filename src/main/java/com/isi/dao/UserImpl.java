package com.isi.dao;

import com.isi.entities.User;

import java.sql.ResultSet;

public class UserImpl implements IUser {
    private DB db = new DB();

    @Override
    public User getConnection(String email, String password) {
        User user = null;
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
          try{
              db.initPrepar(sql);
              db.getPstm().setString(1,email);
              db.getPstm().setString(2,password);

              ResultSet rs = db.executeSelect();
              if (rs.next()){
                  user  = new User();
                  user.setId(rs.getInt(1));
                  user.setEmail(rs.getString(2));
                  user.setPassword(rs.getString(3));
                  Object medecin  = rs.getObject(4);
                  user.setMedecin(null);
                  user.setSecretaire(null);
                  if (medecin != null){
                    user.setMedecin(new MedecinImpl().get((Integer)medecin));
                  }
                  Object secretaire = rs.getObject(5);
                  if ( secretaire != null){
                      user.setSecretaire(new SecretaireImpl().get((Integer)secretaire));
                  }

              }

          }catch (Exception ex){
              ex.printStackTrace();
          }
        return user;
    }
}

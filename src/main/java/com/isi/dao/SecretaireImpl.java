package com.isi.dao;


import com.isi.entities.Secretaire;

import java.sql.ResultSet;

public class SecretaireImpl implements ISecretaire {

    private DB db =  new DB();
    @Override
    public int add(Secretaire secretaire) {
        return 0;
    }

    @Override
    public Secretaire get(int id) {
        String sql ="SELECT * FROM secretaire WHERE id = ?";
        Secretaire secretaire =  null;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);

            ResultSet rs = db.executeSelect();
            if (rs.next()){
                secretaire = new Secretaire();
                secretaire.setId(rs.getInt(1));
                secretaire.setNom(rs.getString(2));
                secretaire.setPrenom(rs.getString(3));

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return secretaire;
    }
}

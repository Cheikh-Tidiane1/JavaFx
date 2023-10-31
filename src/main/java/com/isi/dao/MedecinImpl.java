package com.isi.dao;

import com.isi.entities.Medecin;
import com.isi.entities.Rendezvous;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedecinImpl implements IMedecin {
    private DB db = new DB();
    @Override
    public List<Rendezvous> getRvByMedecin(int id) {

        return null;
    }

    @Override
    public Medecin get(int id) {
        String sql ="SELECT * FROM medecin WHERE id = ?";
        Medecin medecin =  null;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);

            ResultSet rs = db.executeSelect();
            if (rs.next()){
                medecin = new Medecin();
                medecin.setId(rs.getInt(1));
                medecin.setNom(rs.getString(2));
                medecin.setPrenom(rs.getString(3));
                medecin.setTel(rs.getString(4));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return medecin;
    }

    @Override
    public int add(Medecin medecin) {
        String sql ="INSERT INTO medecin VALUES(NULL, ?, ?, ?)";
        int ok = 0;
        try{
            db.initPrepar(sql);
            db.getPstm().setString(1, medecin.getNom());
            db.getPstm().setString(2, medecin.getPrenom());
            db.getPstm().setString(3, medecin.getTel());
            ok = db.executeMaj();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Medecin> getAll() {
        String sql ="SELECT * FROM medecin";
       List<Medecin> medecins = new ArrayList<Medecin>();
        try {
            db.initPrepar(sql);
            ResultSet rs = db.executeSelect();
            while(rs.next()){
                Medecin medecin = new Medecin();
                medecin.setId(rs.getInt(1));
                medecin.setNom(rs.getString(2));
                medecin.setPrenom(rs.getString(3));
                medecin.setTel(rs.getString(4));

                medecins.add(medecin);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return medecins;
    }
}

package com.isi.dao;


import java.sql.*;

public class DB {
    // Pour la connexion
    private Connection cnx;
    // Pour les resultats des requetes de type SELECT
    private ResultSet rs;
    // Pour les requetes preparees ;
    private PreparedStatement pstm;
    // Pour les requetes de mise a jour MAJ( INSERT,UPDATE,DELETE )
    private int ok;

    // ouverture de la connexion a la base
    private void getConnection (){
        String url = "jdbc:mysql://localhost:3306/fxgestionrv";
        String user = "root";
        String password = "";
        try{
            // definition de l'api pour l'ouverture de la connexion
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, user , password);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    // preparation des requetes
    public void initPrepar(String sql){
        try{
            getConnection();
            pstm = cnx.prepareStatement(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    // execution des requetes de type de select
    public ResultSet executeSelect(){
        rs = null;
        try{
            rs = pstm.executeQuery();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    // execution des requetes de type de mise a jour
    public int executeMaj (){
        try{
            ok = pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    public void closeConnection (){
        try{
            if (cnx != null){
                cnx.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public PreparedStatement getPstm() throws SQLException {
        return pstm;
    }

    public void setPstm(PreparedStatement pstm) {
        this.pstm = pstm;
    }
}

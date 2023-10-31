package com.isi.dao;

import com.isi.entities.Medecin;
import com.isi.entities.Rendezvous;

import java.util.List;

public interface IMedecin {
    public List<Rendezvous> getRvByMedecin(int id);
    public Medecin get(int id);
    public int add(Medecin medecin);
    public List<Medecin> getAll();
}

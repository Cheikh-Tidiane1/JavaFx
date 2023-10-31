package com.isi.dao;

import com.isi.entities.Medecin;
import com.isi.entities.Secretaire;

public interface ISecretaire {
    public int add(Secretaire secretaire);
    public Secretaire  get(int id);
}

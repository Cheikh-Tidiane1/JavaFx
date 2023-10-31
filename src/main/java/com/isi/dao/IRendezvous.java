package com.isi.dao;

import com.isi.entities.Rendezvous;

import java.util.List;

public interface IRendezvous {
    public int add(Rendezvous rv);
    public int update(Rendezvous rv);
    public int delete(int id);
    public List<Rendezvous> getAll();
}

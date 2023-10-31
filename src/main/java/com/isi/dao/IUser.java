package com.isi.dao;

import com.isi.entities.User;

public interface IUser {
    public User  getConnection(String email, String password);
}

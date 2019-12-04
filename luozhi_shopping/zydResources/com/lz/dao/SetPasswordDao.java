package com.lz.dao;

import java.sql.Connection;

import com.lz.pojo.User;

public interface SetPasswordDao {
  public boolean SetPassword(Connection conn,User user);
}

package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.pojo.User;


import com.lz.dto.GoodsCarDTO;
public interface GoodsCarDao {
 public List<GoodsCarDTO> getGoodsCarDTO(Connection conn,User user);
}

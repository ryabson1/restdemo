package com.rest.example.one.restdemo.service;

import com.rest.example.one.restdemo.model.Player;
import java.util.List;

public interface PlayerService {

    void Create(Player player);

    List<Player> readAll();

    Player read(int id);


}

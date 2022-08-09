package com.rest.example.one.restdemo.service;

import com.rest.example.one.restdemo.model.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    // хранилище клиентов
    private static final Map<Integer, Player> PLAYER_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID клиента
    private static final AtomicInteger PLAYER_ID_HOLDER = new AtomicInteger();

    @Override
    public void Create(Player player) {
        final int playerId = PLAYER_ID_HOLDER.decrementAndGet();
        player.setId(playerId);
        PLAYER_REPOSITORY_MAP.put(playerId, player);
    }

    @Override
    public List<Player> readAll() {
        return new ArrayList<>(PLAYER_REPOSITORY_MAP.values());
    }

    @Override
    public Player read(int id) {
        return PLAYER_REPOSITORY_MAP.get(id);
    }
}

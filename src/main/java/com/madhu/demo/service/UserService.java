package com.madhu.demo.service;

import com.madhu.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final Map<Long, User> users = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(124);

    public UserService() {
        users.put(123L, new User(123L, "Alice", 30, true));
    }

    public Collection<User> findAll() {
        return users.values();
    }

    public User findById(Long id) {
        return users.get(id);
    }

    public User create(User user) {
        long id = nextId.getAndIncrement();
        user.setId(id);
        users.put(id, user);
        return user;
    }

    public User update(Long id, User user) {
        if (!users.containsKey(id)) {
            return null;
        }
        user.setId(id);
        users.put(id, user);
        return user;
    }

    public boolean delete(Long id) {
        return users.remove(id) != null;
    }
}

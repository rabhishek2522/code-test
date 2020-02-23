package com.ge.exercise1.impl;

import com.ge.exercise1.Group;
import com.ge.exercise1.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * GroupImpl is implementation of Group class
 */
public class GroupImpl extends Group {
    private List<UserImpl> users;

    public GroupImpl() {
        super();
    }

    public GroupImpl(String id, String name) {
        super(id, name);
    }

    public List<UserImpl> getUsers() {
        return this.users;
    }

    public void setUsers(List<UserImpl> users) {
        this.users = users;
    }

    public User getUser(String userId) {
        List<UserImpl> userList = this.users.stream().filter(user -> user.getId() == userId).collect(Collectors.toList());
        if (!userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }
}
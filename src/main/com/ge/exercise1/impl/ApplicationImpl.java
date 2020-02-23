package com.ge.exercise1.impl;

import com.ge.exercise1.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ApplicationImpl is the implementation of Application class
 */
public class ApplicationImpl extends Application {

    private List<UserImpl> users = new ArrayList<>();
    private List<GroupImpl> groups = new ArrayList<>();

    public ApplicationImpl(String id, String name) {
        super(id, name);
    }

    public void setUsers(List<UserImpl> users) {
        this.users = users;
    }

    public void setGroups(List<GroupImpl> groups) {
        this.groups = groups;
    }

    @Override
    public List<UserImpl> getUsers() {
        return users;
    }

    @Override
    public User getUser(String userId) {
        List<User> userList = this.users.stream().filter(user -> user.getId().equals(userId)).collect(Collectors.toList());
        if(!userList.isEmpty()){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public List<GroupImpl> getGroups() {
        return groups;
    }

    @Override
    public Group getGroup(String groupId) {
        //List<Group> groupList = this.groups.stream().filter(group -> group.getId() == groupId).collect(Collectors.toList());
        List<Group> groupList = this.groups.stream().filter(group -> group.getId().equals(groupId)).collect(Collectors.toList());
        if(!groupList.isEmpty()){
            return groupList.get(0);
        }
        return null;
    }
}

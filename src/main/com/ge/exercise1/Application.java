package com.ge.exercise1;

import com.ge.exercise1.impl.GroupImpl;
import com.ge.exercise1.impl.UserImpl;

import java.util.List;

public abstract class Application {
    private String id;
    private String name;

    public Application(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract List<UserImpl> getUsers();

    public abstract User getUser(String userId);

    public abstract List<GroupImpl> getGroups();

    public abstract Group getGroup(String groupId);

}

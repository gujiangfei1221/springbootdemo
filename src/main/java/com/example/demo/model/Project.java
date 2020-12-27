package com.example.demo.model;

public class Project {
    private String name;
    private String ouguid;
    private int type;
    private long id;

    private Project(long id,String name,String ouguid,int type){
        this.id = id;
        this.name = name;
        this.ouguid = ouguid;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOuguid() {
        return ouguid;
    }

    public void setOuguid(String ouguid) {
        this.ouguid = ouguid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

package com.example.administrator.kaoshia;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/7/6.
 */
@Entity
public class Students {
    @Id
    Long id;
    @Property
    String name;
    String dianhua;
    String dizhi;
    public String getDizhi() {
        return this.dizhi;
    }
    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }
    public String getDianhua() {
        return this.dianhua;
    }
    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 127359719)
    public Students(Long id, String name, String dianhua, String dizhi) {
        this.id = id;
        this.name = name;
        this.dianhua = dianhua;
        this.dizhi = dizhi;
    }
    @Generated(hash = 174834727)
    public Students() {
    }
    
}

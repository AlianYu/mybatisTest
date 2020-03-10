package com.book;

import java.util.ArrayList;
import java.util.List;

public class BeanConfig {
    
    public String id;
    public String clazz;
    public String scope;
    
    private List<BeanProperty> properties = new ArrayList<BeanProperty>();
    
    public void addProperty(BeanProperty property) {
        properties.add(property);
    }
            
    public BeanConfig() {
        super();
    }
    
    public List<BeanProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<BeanProperty> properties) {
        this.properties = properties;
    }

    public BeanConfig(String id, String clazz, String scope, List<BeanProperty> properties) {
        super();
        this.id = id;
        this.clazz = clazz;
        this.scope = scope;
        this.properties = properties;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getClazz() {
        return clazz;
    }
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
    public String getScope() {
        return scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "BeanConfig [id=" + id + ", clazz=" + clazz + ", scope=" + scope + ", properties=" + properties + "]";
    }


    
    

}

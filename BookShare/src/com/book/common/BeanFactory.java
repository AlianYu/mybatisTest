package com.book.common;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.book.BeanConfig;
import com.book.BeanProperty;

/**
 * 用于解析bean.xml文件
 * 封装成BeanConfig.java实体
 * @author ylq
 *
 */
public class BeanFactory {
    
    
    private static Map<String, BeanConfig> beans = new HashMap<String, BeanConfig>();
    
    private static Map<String,Object> objects = new HashMap<String, Object>();
    
    
    //类加载时生成beanFactory
    private static BeanFactory beanFactory;
    //构造私有化
    private BeanFactory() {};
    
    public static BeanFactory getInstance() {
        if(beanFactory==null) {
            beanFactory=new BeanFactory();
            beanFactory.init();
        }
        return beanFactory;
    }
    
    private void init() {
        // TODO Auto-generated method stub
        System.out.println("------进入beanFactory的init方法------开始解析bean.xml");
        InputStream in = null;
        in = BeanFactory.class.getClassLoader().getResourceAsStream("com/book/bean.xml");
        DocumentBuilderFactory Dofactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder =  Dofactory.newDocumentBuilder();
            Document document = builder.parse(in);
            Element element =  document.getDocumentElement();
            NodeList beanNode = element.getElementsByTagName("bean");
            if(beanNode==null) {
                return ;
            }
            int beanLength = beanNode.getLength();
            for(int i=0;i<beanLength;i++) {
                Element beanEle = (Element) beanNode.item(i);
                BeanConfig bean = new BeanConfig();
                String id = beanEle.getAttribute("id");
                bean.setId(id);
                
                String classname = beanEle.getAttribute("class");
                bean.setClazz(classname);

                String scope = beanEle.getAttribute("scope");
                bean.setScope(scope);
                
                beans.put(id, bean);
                
                
                
                NodeList beanPropertyNodes = beanEle.getElementsByTagName("property");
                if(beanPropertyNodes!=null) {
                    int beanPropertyLength = beanPropertyNodes.getLength();
                    
                    for(int j=0;j<beanPropertyLength;j++) {
                        Element ele = (Element) beanPropertyNodes.item(j);
                        BeanProperty beanProperty = new BeanProperty();
                        String name = ele.getAttribute("name");
                        
                        beanProperty.setName(name);
                        beanProperty.setValue(ele.getAttribute("value"));
                        beanProperty.setRef(ele.getAttribute("rel"));
                        
                        bean.addProperty(beanProperty);
                    }
                }
                
            }
            
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if(in !=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
        
        
    }

    public Object getBean(String id) {
        Object obj=null;
        
        if(beans.containsKey(id)) {
            BeanConfig bean = beans.get(id);
            String scope = bean.getScope();
            if(scope==null || scope.equals("")) {
                scope="singleton";
            }
            if(scope.equals("singleton")) {
                if(objects.containsKey(id)) {
                    return objects.get(id);
                }
            }
            String clssName = bean.getClazz();
            Class<?> claz = null;
            
            try {
                claz = Class.forName(clssName);
                obj = claz.newInstance();
                System.out.println("创建的对象="+obj);
                
                if(scope.equalsIgnoreCase("singleton")) {
                    objects.put(id, obj);
                }
                
                
                //依赖注入
                /*List<BeanProperty> beanProperties = bean.getProperties();
                
                if(beanProperties!=null && !beanProperties.isEmpty()) {
                    for(BeanProperty beanProperty:beanProperties) {
                        String propertyName = beanProperty.getName();
                        
                        String firstChar =propertyName.substring(0,1);//取第一个字符
                        String leaveChar = propertyName.substring(1);//取除了第一个字符的剩下的
                        String methodName = firstChar.toUpperCase()+leaveChar;
                        
                        System.out.println("方法名="+methodName);//Logindao
                        Method method = null;
                        Method[] methods = claz.getMethods();
                        
                        for(Method c :methods) {
                            
                            String methodNameInClass = c.getName();
                            System.out.println("methodNameInClass="+methodNameInClass);
                            if(methodNameInClass.equals("set"+methodName)) {
                                method = c;
                                break;
                            }
                            
                        }
                        //找到setBookdao方法
                        String ref = beanProperty.getRef();
                        String value =beanProperty.getValue();
                        
                        if(ref !=null && !ref.trim().equals("")) {
                            Object refObject = this.getBean(ref);//递归
                            method.invoke(obj, refObject);
                            
                        }else if(value!=null && !value.trim().equals("")) {
                            Class<?>[] parmts = method.getParameterTypes();
                            String propertyVlaue = beanProperty.getValue();
                            if(parmts[0] == String.class) {
                                method.invoke(obj,propertyVlaue);
                            }
                            if(parmts[0] ==int.class) {
                                method.invoke(obj,  Integer.parseInt(propertyVlaue));
                            }
                            if(parmts[0] ==boolean.class) {
                                method.invoke(obj,  Boolean.parseBoolean(propertyVlaue));
                            }
                        }
                        
                    }
                    
                }*/
                
                
                
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException  e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return obj;
    }
    
}

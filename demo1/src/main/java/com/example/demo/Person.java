package com.example.demo;

//这个代码是传递对象的代码
//简单说就是把需要参数封装到一个对象里面，方便调用
//需要的时候直接调用
public class Person
{
    private int id;
    private String  name;
    private String  password;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "id="+id+
                ",name='"+name +'\'' +
                ",password='" + password + '\''+
                '}';
    }
}

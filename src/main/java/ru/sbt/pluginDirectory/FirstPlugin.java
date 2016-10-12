package ru.sbt.pluginDirectory;

/**
 * Created by Yrwing on 12.10.2016.
 */
public class FirstPlugin implements ru.sbt.pluginDirectory.Plugin{

    public void doUsefull() {
        A a = new A();
        a.out();
    }
}

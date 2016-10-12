package ru.sbt.pluginloader;


import ru.sbt.pluginDirectory.Plugin;

public class Main {
    public static void main(String[] args)  {
        PluginManager pluginManager =
                new PluginManager("file:/C:/Users/Yrwing/repositories/unittesting-master/Lesson8/target/classes/ru/sbt/");
        try {
            Plugin first = pluginManager.load("FirstPlugin", "C:/Users/Yrwing/repositories/unittesting-master/Lesson8/out/production/plugindirectory/FirstPlugin/FirstPlugin.class");
            first.doUsefull();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

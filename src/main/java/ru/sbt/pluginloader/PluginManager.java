package ru.sbt.pluginloader;



import ru.sbt.pluginDirectory.Plugin;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager {

    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {

        this.pluginRootDirectory = pluginRootDirectory;

    }

    public Plugin load(String pluginName, String pluginClassName) throws Exception{
        URL pluginDirectory = new URL(pluginRootDirectory);
        URLClassLoader pluginURLloader = new URLClassLoader(new URL[]{pluginDirectory}, ClassLoader.getSystemClassLoader());

        //this.isEmpty(pluginDirectory);
        Class<Plugin> plugin = (Class<Plugin>) pluginURLloader.loadClass("ru.sbt.pluginDirectory.FirstPlugin");
        return plugin.newInstance();
    }
    //Выводит первый файл директории, если такой есть.
    void isEmpty(URL directory){
        File f = new File(directory.getFile());
        String fNameList[] = f.list();
        for (String fileName : fNameList ) {
            System.out.println(fileName);
        }
    }
}
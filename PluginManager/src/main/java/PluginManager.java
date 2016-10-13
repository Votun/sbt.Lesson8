
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager {

    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {

        this.pluginRootDirectory = pluginRootDirectory;

    }

    public Plugin load(String pluginName) throws Exception{
        URL pluginDirectory = new URL(pluginRootDirectory);
        URLClassLoader pluginURLloader = new URLClassLoader(new URL[]{pluginDirectory}, ClassLoader.getSystemClassLoader()){
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                Class<?> clazz = findLoadedClass(name);
                try{
                if(clazz == null){
                    clazz = findClass(name);
                }
                }catch(ClassNotFoundException e){
                    clazz = getParent().loadClass(name);
                }
                return clazz;
            }
        };

        //this.isEmpty(pluginDirectory);
        Class<Plugin> plugin = (Class<Plugin>) pluginURLloader.loadClass(pluginName);
        System.out.println(plugin.getClassLoader().getClass().getName());
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
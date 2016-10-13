public class Main {
    public static void main(String[] args)  {
        Plugin first = new FirstPlugin();
        PluginManager pluginManager =
                new PluginManager("file:/C:/Users/");
        try {
            Plugin second = pluginManager.load("FirstPlugin");
            System.out.println(Main.class.getClassLoader().getClass().getName());
            first.doUsefull();
            second.doUsefull();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

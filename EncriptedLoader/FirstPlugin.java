import ru.sbt.pluginloader.Plugin;


public class FirstPlugin implements Plugin {

    public void doUsefull() {
        A a = new A();
        a.out();
    }
}

package coreJava;

/**
 * Created by Ajeet on 3/24/2015.
 */
public interface BeanFactorySimple {
    public int count=0;
    public int getLife();
    default int getSomething(){
        return 0;
    };
}

package multithreading;

/**
 * Created by Ajeet on 3/19/2015.
 */

public class Foo{
    public static void main(String[] args){
        //Loo<String> newObj = new Loo<String>();
    }
}
class Loo<T> {
    final Class<T> typeParameterClass;

    public Loo(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public void bar() {
        // you can access the typeParameterClass here and do whatever you like
    }
}

package datastructure;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by agupta2 on 3/3/16.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String stringValue() default "illumina";
    int intValue() default 101;

}

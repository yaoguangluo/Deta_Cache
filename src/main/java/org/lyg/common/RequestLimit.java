package org.lyg.common;
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RequestLimit {
	int count() default Integer.MAX_VALUE;
	long time() default 60000;
}
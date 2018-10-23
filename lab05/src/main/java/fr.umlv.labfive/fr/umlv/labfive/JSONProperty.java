/**
 * 
 */
package fr.umlv.labfive;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * @author bdinh
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONProperty {
	String rename() default "";;
}

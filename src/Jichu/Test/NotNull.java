package Jichu.Test;





import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME) // 必须设置为 RUNTIME
public @interface NotNull {

	String mustRole () default "user";


}

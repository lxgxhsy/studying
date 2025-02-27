package Jichu.Test;





import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME) // 必须设置为 RUNTIME
public @interface NotNull {

	// --注释掉检查 (2025/2/25 20:27):String mustRole () default "user";


}

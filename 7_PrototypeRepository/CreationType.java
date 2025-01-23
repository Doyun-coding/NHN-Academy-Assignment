import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CreationType {
    ObjectType type() default ObjectType.PROTOTYPE;
}

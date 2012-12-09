import java.lang.annotation.*;
//Runtime, damit man die Authoren mittels Reflektion bestimmen können (siehe letzter Punkt beim Testen)
//ElementType.Type - annotation für Klassen
@AuthorClass(author="Jakub Zarzycki")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface AuthorClass{
  String author() default "none";
}
package fox;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassAnalyzer {

    public String analyze(Class<?> obj) {
        StringBuilder sb = new StringBuilder();

        sb.append("\nКласс рассматривается: ").append(obj.getName()).append("\n\tМодификатор:\n");
        int mods = obj.getModifiers();

        if (Modifier.isPublic(mods)) {
            sb.append("public");
        }
        if (Modifier.isAbstract(mods)) {
            sb.append("abstract");
        }
        if (Modifier.isFinal(mods)) {
            sb.append("final");
        }
        sb.append("\n\n\tСуперкласс: ").append(obj.getSuperclass());
        sb.append("\n\n\tИнтерфейсы:\n");

        Class<?>[] interfaces = obj.getInterfaces();
        for (Class<?> cInterface : interfaces) {
            sb.append(cInterface.getName()).append(";\n");
        }

        sb.append("\n");

        Field[] publicFields = obj.getFields();
        for (Field field : publicFields) {
            Class<?> fieldType = field.getType();
            sb.append("\tИмя: ").append(field.getName()).append("\tТип: ").append(fieldType.getName()).append("\n");
        }

        sb.append("\n\nПовтор в declared-mode:\n");

        publicFields = obj.getDeclaredFields();
        for (Field field : publicFields) {
            Class<?> fieldType = field.getType();
            sb.append("\tИмя: ").append(field.getName()).append("\n");
            sb.append("\tТип: ").append(fieldType.getName()).append("\n");
        }
        // Field nameField = c.getField("name");

        sb.append("\n\nКонструкторы:\n\n").append(Arrays.toString(obj.getConstructors()));
        sb.append("\n\nКонструкторы declared-mode :\n\n").append(Arrays.toString(obj.getDeclaredConstructors()));
        sb.append("\n\n\tМетоды: ");

        Method[] methods = obj.getMethods();
        Class<?>[] paramTypes;
        for (Method method : methods) {
            sb.append("\n\tИмя метода: ").append(method.getName());
            sb.append("\n\tВозвращаемый тип: ").append(method.getReturnType().getName());
            sb.append("\n\n\tТипы параметров: ");
            paramTypes = method.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                sb.append("\n\t").append(paramType.getName());
            }
        }

        sb.append("\n\n\tМетоды declared-mode\n: ");
        methods = obj.getDeclaredMethods();
        for (Method method : methods) {
            sb.append("\n\tИмя метода: ").append(method.getName());
            sb.append("\tВозвращаемый тип: ").append(method.getReturnType().getName());
            sb.append("\n\tТипы параметров: ");
            paramTypes = method.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                sb.append("\n\t").append(paramType.getName());
            }
        }

        sb.append("\n");

        return sb.toString();
    }
}

package br.com.alura.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Transformator {

    public <I, O> O transform(I input) throws ClassNotFoundException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, IllegalAccessException {
        Class<?> source = input.getClass();
        Class<?> target = Class.forName(source.getName() + "DTO");

        O instance = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        // Percorre os campos da classe de origem e da classe de destino'
        for (Field sourceField : sourceFields) {

            // Percorre os campos da classe de destino
            for (Field targetField : targetFields) {

                try {
                    // Valida se os campos são iguais
                    validate(sourceField, targetField);

                    // Seta o valor do campo da classe de origem no campo da classe de destino
                    targetField.set(instance, sourceField.get(input));

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return instance;
    }

    private void validate(Field sourceField, Field targetField)
            throws IllegalAccessException {
        // Se os campos tiverem o mesmo nome modificamos a visibilidade para acessar o
        // campo
        if (sourceField.getName().equals(targetField.getName())
                && sourceField.getType().equals(targetField.getType())) {
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
        }
    }

}

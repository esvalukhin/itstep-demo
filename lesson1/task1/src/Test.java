
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test {
    @org.junit.Test
    public void shouldContainsIntVariable() throws Exception {

        Field[] declaredFields = Task.class.getDeclaredFields();

        Task task = new Task();

        boolean intDeclared = false;
        boolean maxIntAssigned= false;
        boolean minIntDeclared = false;
        boolean minByteDeclared = false;
        boolean maxByteDeclared = false;
        boolean doubleIntDeclared = false;
        boolean minusHellFromMaxDeclared = false;
        boolean piDeclared = false;
        boolean earthIsCubeDeclared = false;
        boolean sunAroundEarthDeclared = false;

        Field maxIntField = null;
        Field doubleIntField = null;
        Field minusHellFromMaxField = null;
        Field earthIsCubeField = null;
        Field sunAroundEarthField = null;
        Field intValueField = null;
        Field byteValueLessThan255Field = null;

        for (Field declaredField : declaredFields) {
            if (declaredField.getName().equals("intValue")) {
                intDeclared = true;
                intValueField = declaredField;
                assertEquals("Переменной intValue присвоено неверное значение", 10, declaredField.getInt(task));
            }
            if (declaredField.getName().equals("maxIntValue")) {
                maxIntField = declaredField;
                maxIntAssigned = true;
                assertEquals("Переменной maxIntValue присвоенное не максимальное целое значение", Integer.MAX_VALUE, declaredField.getInt(task));
            }
            if (declaredField.getName().equals("MIN_INT_VALUE")) {
                minIntDeclared = true;
                int modifiers = declaredField.getModifiers();
                assertTrue("MIN_INT_VALUE не является константой", Modifier.isFinal(modifiers));
                assertEquals("Переменной MIN_INT_VALUE присвоенное не минимальное целое значение", Integer.MIN_VALUE, declaredField.getInt(task));
            }
            if (declaredField.getName().equals("byteValueLessThan255")) {
                Object o = declaredField.get(task);
                minByteDeclared = true;
                byteValueLessThan255Field = declaredField;
                assertTrue("Переменная byteValueLessThan255 имеет неверный тип", o instanceof Byte);
                assertEquals("Переменной byteValueLessThan255 присвоено неверное значение", 126, ((Byte) o).byteValue());
            }
            if (declaredField.getName().equals("byteValueMoreThan255")) {
                Object o = declaredField.get(task);
                maxByteDeclared = true;
                if (o instanceof Short) {
                    assertEquals("Переменной byteValueMoreThan255 присвоено неверное значение", 256, ((Short) o).shortValue());
                } else if (o instanceof Integer) {
                    assertEquals("Переменной byteValueMoreThan255 присвоено неверное значение", 256, ((Integer) o).intValue());
                }
                assertTrue("Переменная byteValueMoreThan255 имеет неверный тип", o instanceof Short || o instanceof Integer);
            }
            if (declaredField.getName().equals("doubleInt")) {
                Object o = declaredField.get(task);
                doubleIntDeclared = true;
                doubleIntField = declaredField;
                assertTrue("Переменная doubleInt имеет неверный тип", o instanceof Long);
                assertEquals("Переменной doubleInt присвоено неверное значение", 2 * Integer.MAX_VALUE, ((Long) o).longValue());
            }
            if (declaredField.getName().equals("minusHellFromMax")) {
                Object o = declaredField.get(task);
                minusHellFromMaxDeclared = true;
                minusHellFromMaxField = declaredField;
                assertTrue("Переменная minusHellFromMax имеет неверный тип", o instanceof Long);
                long doubled = 2 * Integer.MAX_VALUE;
                long value = Integer.MAX_VALUE - doubled;
                assertEquals("Переменной minusHellFromMax присвоено неверное значение", value, ((Long) o).longValue());
            }
            if (declaredField.getName().equals("PI")) {
                piDeclared = true;
                Object o = declaredField.get(task);
                int modifiers = declaredField.getModifiers();
                assertTrue("PI не является константой", Modifier.isFinal(modifiers));
                assertTrue("Константа PI не является вещественным числом", o instanceof Double);
                assertEquals("PI присвоенно неверное значение", 3.14, ((Double) o).doubleValue(), 0.001);
            }
            if (declaredField.getName().equals("earthIsCube")) {
                earthIsCubeDeclared = true;
                earthIsCubeField = declaredField;
                Object o = declaredField.get(task);
                assertTrue("Переменная earthIsCube не является логической переменной", o instanceof Boolean);
                assertEquals("Переменной earthIsCube присвоенно неверное значение", false, ((Boolean) o).booleanValue());
            }
            if (declaredField.getName().equals("солнцеКрутитсяВокругЗемли")) {
                sunAroundEarthDeclared = true;
                sunAroundEarthField = declaredField;
                Object o = declaredField.get(task);
                assertTrue("Переменная солнцеКрутитсяВокругЗемли не является логической переменной", o instanceof Boolean);
                assertEquals("Переменной солнцеКрутитсяВокругЗемли присвоенно неверное значение", true, ((Boolean) o).booleanValue());
            }
        }

        assertTrue("Переменная intValue не объявлена", intDeclared);
        assertTrue("Переменная maxIntValue не объявлена", maxIntAssigned);
        assertTrue("Константа MIN_INT_VALUE не объявлена", minIntDeclared);
        assertTrue("Переменная byteValueLessThan255 не объявлена", minByteDeclared);
        assertTrue("Переменная byteValueLessThan255 не объявлена", maxByteDeclared);
        assertTrue("Переменная doubleInt не объявлена", doubleIntDeclared);
        assertTrue("Переменная minusHellFromMax не объявлена", minusHellFromMaxDeclared);
        assertTrue("Константа PI не объявлена", piDeclared);
        assertTrue("Переменная earthIsCube не объявлена", earthIsCubeDeclared);
        assertTrue("Переменная солнцеКрутитсяВокругЗемли не объявлена", sunAroundEarthDeclared);

//        validateDoubleInt(task, doubleIntField, maxIntField);
//        validateMinusHellFromMax(task, minusHellFromMaxField, doubleIntField);
//
        validateIsItTrue(task, earthIsCubeField, sunAroundEarthField);
        validateCalculateAverage(task);
        validateVolumeOfSphere(task);
        validateAddIntValueSum(task, intValueField, byteValueLessThan255Field);
    }

    private void validateAddIntValueSum(Task task, Field intValueField, Field byteValueLessThan255Field) throws IllegalAccessException {
        int intValue = intValueField.getInt(task);
        int byteValue = byteValueLessThan255Field.getInt(task);

        assertEquals("Результат сложения в методе addIntValueToByteValueMoreThan255UsingIncrement не верен", 137, task.addIntValueToByteValueMoreThan255UsingIncrement());
        int intValueAfter = intValueField.getInt(task);
        int byteValueAfter = byteValueLessThan255Field.getInt(task);
        assertEquals("Переменная intValue не увеличилась", intValue + 1, intValueAfter);
        assertEquals("Переменная byteValueLessThan255 не увеличилась", byteValue + 1, byteValueAfter);
    }

    private void validateVolumeOfSphere(Task task) {
        double pi = 3.14;

        assertEquals("Метод calculateVolumeOfSphere не использует переменную radius", pi * 0, task.calculateVolumeOfSphere(0.0), 0.001);
        assertEquals("Метод calculateVolumeOfSphere не использует константу PI", pi, task.calculateVolumeOfSphere(1.0), 0.001);
        assertEquals("Метод calculateVolumeOfSphere не использует переменную radius", pi * 2 * 2 * 2, task.calculateVolumeOfSphere(2.0), 0.001);
    }

    private void validateCalculateAverage(Task task) {
        boolean useParam = task.calculateAverage(0) == 8 && task.calculateAverage(12) == 10;
        assertTrue("Метод calculateAverage не учитывает значение переменной j", useParam);

        useParam = task.calculateAverage(12) == 10 && task.calculateAverage(62) == 15;
        assertTrue("Метод calculateAverage использует не все переменные объявленные в методе", useParam);

        useParam = task.calculateAverageMod(0) == 8 && task.calculateAverageMod(12) == 0;
        assertTrue("Метод calculateAverageMod не учитывает значение переменной j", useParam);

        useParam = task.calculateAverageMod(0) == 8 && task.calculateAverageMod(-4) == 4;
        assertTrue("Метод calculateAverageMod использует не все переменны объявленные в методе", useParam);
    }

    private void validateIsItTrue(Task task, Field earthIsCubeField, Field sunAroundEarthField) throws IllegalAccessException {
        assertFalse("Метод isItTrue возвращает неверное значение", task.isItTrue());

        boolean earth = earthIsCubeField.getBoolean(task);
        boolean sun = sunAroundEarthField.getBoolean(task);

        earthIsCubeField.setBoolean(task, true);
        assertFalse("Метод isItTrue не использует переменную earthIsCube", task.isItTrue());

        earthIsCubeField.setBoolean(task, earth);
        sunAroundEarthField.setBoolean(task, false);
        assertFalse("Метод isItTrue не использует переменную солнцеКрутитсяВокругЗемли", task.isItTrue());
    }

    private void validateMinusHellFromMax(Task task, Field minusHellFromMaxField, Field doubleIntField) throws IllegalAccessException {
        long existDoubleInt = doubleIntField.getLong(task);
        long newDoubleInt = 45;
        doubleIntField.setLong(task, newDoubleInt);

        assertEquals("Переменная minusHellFromMax высчитывается не путем вычитания переменной doubleInt", Integer.MAX_VALUE - newDoubleInt, minusHellFromMaxField.getLong(task));
    }

    private void validateDoubleInt(Task task, Field doubleIntField, Field maxIntField) throws IllegalAccessException {
        int existMaxInt = maxIntField.getInt(task);
        int newMaxInt = 45;
        maxIntField.set(task, newMaxInt);

        assertEquals("Переменная doubleInt получена не умножена на 2", 2 * newMaxInt, doubleIntField.getInt(task));

        maxIntField.set(task, existMaxInt);

    }


}
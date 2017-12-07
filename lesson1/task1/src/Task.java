class Task {

    // переменная intValue типа int со значением 10
    public int intValue = 10;

    // переменная maxIntValue типа int с максимальным целым числом
    public int maxIntValue = Integer.MAX_VALUE;

    // константа MIN_INT_VALUE типа int c минимальным целым числом
    public final int MIN_INT_VALUE = Integer.MIN_VALUE;

    // переменная byteValueLessThan255 со значением 126
    public byte byteValueLessThan255 = (byte) 126;

    // переменная byteValueMoreThan255 со значением 256
    public short byteValueMoreThan255 = 256;

    // переменная doubleInt со значением maxIntValue умноженное на 2
    public long doubleInt = 2 * maxIntValue;

    // переменная minusHellFromMax со значением, которое вычисляется вычитанием из
    // максимального целого числа значением удвоенного максимального целого числа
    public long minusHellFromMax = Integer.MAX_VALUE - doubleInt;

    // константу PI со значением 3.14
    public final double PI = 3.14;

    // логическую переменную earthIsCube со значением false
    public boolean earthIsCube = false;

    // логическую переменную солнцеКрутитсяВокругЗемли со значением true
    public boolean солнцеКрутитсяВокругЗемли = true;


    public boolean isItTrue() {
        // на основе переменных earthIsCube и солнцеКрутитсяВокругЗемли верните ложь
        //return true;
        return earthIsCube & !солнцеКрутитсяВокругЗемли;
    }

    public int calculateAverage(int j) {
        int a = 1, b = 1, c = 2, d = 3, e = 5, f = 8, g = 13, h = 21, i = 34;

        // расчитайте и верните среднее арифметическое, включая переменную метода

        return (a + b + c + d + e + f + g + h + i + j) / 10;
        //return 0;
    }

    public int calculateAverageMod(int j) {
        int a = 1, b = 1, c = 2, d = 3, e = 5, f = 8, g = 13, h = 21, i = 34;

        // расчитайте и верните остаток от среднего арифметического, включая переменную метода в сумму

        return (a + b + c + d + e + f + g + h + i + j) % 10;
        //return 0;
    }

    public double calculateVolumeOfSphere(double radius) {
        // расчитайте объем шара используя константу PI и параметр метода radius
        // формула объема шара pi * r ^ 3;
        //return 0.0;
        return PI * radius  * radius * radius;
    }

    public int addIntValueToByteValueMoreThan255UsingIncrement() {
        // верните результат сложения переменных byteValueMoreThan255 и intValue
        // при этом к переменной intValue примените операцию поcтфиксного икремента, а
        // к переменной byteValueMoreThan255 префиксного инкремента

        return intValue++ + ++byteValueLessThan255;
        //return 0;
    }

}
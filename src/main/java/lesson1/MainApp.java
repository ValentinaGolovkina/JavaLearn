package lesson1;

public class MainApp {
    //1.Создать пустой проект в IntelliJ IDEA и прописать метод main().
    public static void main(String[] args) {
        //2.Создать переменные всех пройденных типов данных и инициализировать их значения.
        byte b = -120;
        short s = 12442;
        int a = 1000;
        long l = 200000L;
        float f = 12.23f;
        double d = -123.123;
        char st = '*';
        char st2 = '\u2242';
        boolean flag = false;

        System.out.println("1*(2+(4/2)) = "+calculate(1f,2f,4f,2f));
        System.out.println("Сумма 11 и 3 в пределах от 10 до 20(включительно) : "+checkSum10to20(11,3));
        System.out.println("Сумма 11 и 12 в пределах от 10 до 20(включительно) : "+checkSum10to20(11,12));
        printCheckNumber(5);
        printCheckNumber(-5);
        System.out.println("Число 5 отрицательное : "+checkNumber(5));
        System.out.println("Число -5 отрицательное : "+checkNumber(-5));
        printHello("Илья");
        checkYear(2020);
        checkYear(2021);


    }

    //3.Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – аргументы этого метода, имеющие тип float
    static float calculate(float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    //4.Написать метод, принимающий на вход два целых числа и проверяющий,
    // что их сумма лежит в пределах от 10 до 20 (включительно),
    // если да – вернуть true, в противном случае – false.
    static boolean checkSum10to20(int a, int b){
        int sum = a+b;
        if(sum>9&&sum<21) return true;
        else return false;
    }

    //5. Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.
    static void printCheckNumber(int a)
    {
        if(a>-1) System.out.println("Число "+a+" положительное");
        else System.out.println("Число "+a+" отрицательное");
    }

    //6.Написать метод, которому в качестве параметра передается целое число.
    // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    static boolean checkNumber(int a)
    {
        if(a<0) return true;
        else return false;
    }

    //7.Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    // Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    static void printHello(String name)
    {
        System.out.println("Привет, "+name+"!");
    }

    //8.Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    static void checkYear(int year){
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
            System.out.println(year+ ": високосный");
        else System.out.println(year+ ": не високосный");
    }
}

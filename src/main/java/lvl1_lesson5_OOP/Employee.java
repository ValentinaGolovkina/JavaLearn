package lvl1_lesson5_OOP;

public class Employee {
    String fio;
    String post;
    String email;
    String tel;
    int salary;
    int age;

    public Employee(String fio, String post, String email, String tel, int salary, int age){
        this.fio = fio;
        this.post=post;
        this.email=email;
        this.tel=tel;
        this.salary=salary;
        this.age=age;
    }

    void printInfo()
    {
        System.out.println("ФИО: "+fio+" Должность: "+post+" Email: "+email+" Телефон: "+tel+" Зарплата: "+salary+" Возраст:"+age);
    }
}

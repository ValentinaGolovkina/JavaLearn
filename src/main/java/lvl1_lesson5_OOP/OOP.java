package lvl1_lesson5_OOP;

public class OOP {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0]=new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1]=new Employee("Ivanova Kate", "Teacher", "ivikat@mailbox.com", "892364783", 25000, 26);
        employees[2]=new Employee("Petrov Petya", "Manager", "petpet@mailbox.com", "893424356", 30000, 41);
        employees[3]=new Employee("Petrova Ira", "Engineer", "petira@mailbox.com", "893466664", 40000, 27);
        employees[4]=new Employee("Melova Marina", "Bux", "melmar@mailbox.com", "892344534", 50000, 50);

        for(int i=0;i<employees.length;i++){
            if(employees[i].age>40) employees[i].printInfo();
        }

    }
}

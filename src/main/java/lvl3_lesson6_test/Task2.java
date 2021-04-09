package lvl3_lesson6_test;

public class Task2 {
    //Написать метод, который проверяет состав массива из чисел 1 и 4.
    // Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    // Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    public boolean checkArr(int[] arr){
        boolean one = false;
        boolean four = false;

        for(int i=0;i<arr.length;i++){
            switch (arr[i]){
                case 1: one = true;
                    break;
                case 4: four = true;
                    break;
                default: new RuntimeException("В масиве содержится элемент не равный 1 или 4 : "+arr[i]);
            }
        }
        return one&&four;
    }
}

package lvl3_lesson6_test;

public class Main {
    //Написать метод, которому в качестве аргумента передается не пустой одномерный
    // целочисленный массив. Метод должен вернуть новый массив, который получен путем
    // вытаскивания из исходного массива элементов, идущих после последней четверки.
    // Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо
    // выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    // Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    public  int[] getItemsAfter4(int[] arr){
        int[] newArr;
        int index=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==4)
                index = i;
        }
        if(index==-1){
            throw new RuntimeException("Массив не содержит 4");
        }
        else{
            index++;
            newArr = new int[arr.length-index];
            for(int i=0;i< newArr.length;i++){
                newArr[i]=arr[index+i];
            }
        }
        return newArr;
    }

}
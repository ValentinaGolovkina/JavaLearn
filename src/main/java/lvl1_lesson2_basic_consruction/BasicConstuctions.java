package lvl1_lesson2_basic_consruction;

import java.util.Arrays;

public class BasicConstuctions {

    public static void main(String[] args) {
        //1.Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for(int i=0;i<arr.length;i++)
            if(arr[i]==0) arr[i]=1;
            else arr[i]=0;
        System.out.println(Arrays.toString(arr));

        //2.Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
        int[] arrInt = new int[8];
        for(int i=0;i<arrInt.length;i++)
            arrInt[i]=i*3;
        System.out.println(Arrays.toString(arrInt));

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i=0;i<arr2.length;i++)
            if(arr2[i]<6) arr2[i]*=2;
        System.out.println(Arrays.toString(arr2));

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int [][]arrSquare = new int[5][5];
        for(int i=0;i<arrSquare.length;i++)
            arrSquare[i][i]=1;
        for(int i=0;i<arrSquare.length;i++)
            System.out.println(Arrays.toString(arrSquare[i]));

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] arrMM = {1,2,3,4,5};
        int min=arrMM[0];
        int max = arrMM[0];
        for (int i=1;i<arrMM.length;i++)
            if(arrMM[i]<min) min=arrMM[i];
            else if(arrMM[i]>max) max=arrMM[i];
        System.out.println("min: "+min+" max: "+max);
        int[] balance = {1, 1, 1, 2, 1};
        System.out.println("В массиве [1, 1, 1, 2, 1] есть место, в котором сумма левой и правой части массива равны -> "+cheakBalance(balance));
        int[] arrLeft = {0, 1, 2, 3, 4};
        leftShift(arrLeft,2);
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    static boolean cheakBalance(int[] arr){
        int sum1=arr[0];
        int sum2=0;
        for(int i=1;i<arr.length;i++)
            sum2+=arr[i];
        for(int i=1;i<arr.length;i++){
            if(sum1==sum2) return true;
            sum1+=arr[i];
            sum2-=arr[i];
        }
        return false;
    }

    //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.

    static void leftShift(int[] arr, int n){
        //сделать n-смещений по 1ячейки
        for(int j=0;j<n;j++) {
            //сместить на 1 ячейку весь массив
            int temp = arr[0];
            for (int i = 0; i < (arr.length - 1); i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

}

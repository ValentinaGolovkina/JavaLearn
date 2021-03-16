package lvl2_lesson2_exeption;

public class Main {
    public static void main(String[] args) {

        String[][] str = {
                {"1","1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"}
        };

        try{
            int sum = summ(str);
            System.out.println("Sum = "+sum);
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }

    }

    public static int summ (String[][] str) throws MyArraySizeException, MyArrayDataException {
        if(!checkLength4(str)) throw new MyArraySizeException("Размер массива не 4х4");
        int sum =0;
        int x;
        for(int i=0; i<4;i++){
            for(int j=0;j<4;j++){
                try {
                     x = Integer.parseInt(str[i][j]);
                }
                catch(NumberFormatException e){
                    throw new MyArrayDataException("Преобразование не удалось. В ячейке ["+i+"]["+j+"] лежат неверные данные");
                }
                sum+=x;
            }
        }
        return sum;
    }

    private static boolean checkLength4(String[][] str){
        if(str.length!=4) return false;
        for(int i=0;i<4;i++)
            if(str[i].length!=4) return false;
        return true;
    }
}

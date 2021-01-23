package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static Scanner sc = new Scanner(System.in);
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static Random rand = new Random();
    public static void aiTurn() {
        boolean block=false;
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++)
            {
                if(map[i][j] == DOT_EMPTY)
                {
                    map[i][j]= DOT_X;
                    if (checkWin(DOT_X)) {
                        block=true;
                        System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                        map[i][j] = DOT_O;
                        break;
                    }
                    else map[i][j]= DOT_EMPTY;
                }
            }
            if(block) break;
        }
        if (!block)
        {
            int x, y;
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        }
    }
    public static boolean checkWin(char symb) {
        //по горизонтали
        for(int i =0; i<SIZE;i++) {
            int countSymb=0;
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == symb) countSymb++;
                else if(countSymb!=0) break;
            if (countSymb==DOTS_TO_WIN) return true;
        }
        //по вертикали
        for(int i =0; i<SIZE;i++) {
            int countSymb=0;
            for (int j = 0; j < SIZE; j++)
                if (map[j][i] == symb) countSymb++;
                else if(countSymb!=0) break;
            if (countSymb==DOTS_TO_WIN) return true;
        }
        //главная диагональ
        int countSymb=0;
        for (int i=0;i<SIZE;i++)
                if(map[i][i]==symb) countSymb++;
                else break;
        if (countSymb==DOTS_TO_WIN) return true;

        //побочная диагональ
        countSymb=0;
        for (int i=0;i<SIZE;i++)
            if(map[i][SIZE-1-i]==symb) countSymb++;
            else break;
        if (countSymb==DOTS_TO_WIN) return true;
        return false;
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }


}

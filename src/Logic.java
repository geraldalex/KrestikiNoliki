import java.util.Random;
import java.util.Scanner;

public class Logic {
    final int SIZE_X = 3;
    final int SIZE_Y = 3;
    final char[][] field = new char[SIZE_Y][SIZE_X];
    final char PLAYER_CH = 'X';
    final char AI_CH = 'O';
    final char PUSTAYA_YACHEYKA = '*';
    final int WIN = 3;
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = PUSTAYA_YACHEYKA;
            }
        }
    }

    void printField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "\t");
            }
            System.out.println();
        }
    }

    void movePerson() {
        int x, y;
        do {
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        field[y][x] = PLAYER_CH;
    }

    void moveAI() {
        int x;
        int y;
        do {
            x = random.nextInt(SIZE_X);
            y = random.nextInt(SIZE_Y);
        } while (!isCellValid(x, y));
        field[y][x] = AI_CH;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE_X || y < 0 || y >= SIZE_Y)
            return false;
        if (field[y][x] == PUSTAYA_YACHEYKA)
            return true;
        return false;
    }

    boolean isFreeYacheyka() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == PUSTAYA_YACHEYKA)
                    return false;
            }
        }
        return true;
    }

    boolean chekWin(char sym) {
        for (int i = 0; i < SIZE_Y; i++) {
            int result = 0;
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == sym)
                    result++;
            }
            if (result == WIN)
                return true;
        }

        for (int i = 0; i < SIZE_Y; i++) {
            int result = 0;
            for (int j = 0; j < SIZE_X; j++) {
                if (field[j][i] == sym)
                    result++;
            }
            if (result == WIN)
                return true;
        }
        int firstDiagonal = 0;
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (j == i && field[i][j] == sym)
                    firstDiagonal++;
            }
        }
        if (firstDiagonal == WIN)
            return true;
        int secondDiagonal = 0;
        for (int i = 0, j = SIZE_Y -1; i < SIZE_X && j > 0; i++, j--) {
            if (field[i][j] == sym)
                secondDiagonal++;
        }
        if (secondDiagonal == WIN)
            return true;
        return false;
    }
}

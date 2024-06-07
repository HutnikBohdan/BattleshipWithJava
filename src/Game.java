import java.io.OptionalDataException;
import java.util.Scanner;

public class Game {

    String[][] gameField = new String[11][11];
    PlayerShips playerships = PlayerShips.AIRCRAFTCARRIER;


    public void startGame() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (i == 0 && j > 0) {
                    gameField[i][j] = "" + j;
                } else if (i > 0 && j == 0) {
                    gameField[i][j] = "" + ((char) (64 + i));
                } else {
                    gameField[i][j] = "~";
                }

            }
        }
        gameField[0][0] = " ";
    }

    public void printField() {
        for(int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }

    }

    public boolean ControlField() {
        boolean control = true;
        for(int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if ("O".equals(gameField[i][j])) {
                    control = false;
                }
            }
        }
        return control;

    }


    public int AJNum(String value) {
        int num1;
        try {
            num1 = Integer.parseInt("" + value.charAt(1) + value.charAt(2));
        } catch (Exception e) {
            num1 = Integer.parseInt("" + value.charAt(1));
        }
        return num1;
    }



    public void gameGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the coordinates of the ship:");
        boolean control_AJ_NUM = false;

        while (control_AJ_NUM == false) {
            String[] value = input.nextLine().split(" ");
            int num1 = AJNum(value[0]);
            int num2 = AJNum(value[1]);
            int AJ1 = (value[0].charAt(0) - 64);
            int AJ2 = (value[1].charAt(0) - 64);

            if ((num1 <= 10 && num1 >= 1) && (num2 <= 10 && num2 >= 1) && (AJ1 <= 10 && AJ1 >= 1) && (AJ2 <= 10 && AJ2 >= 1)){
                if ((num1 != num2 && AJ1 == AJ2) || ((num1 == num2 && AJ1 != AJ2))) {
                    control_AJ_NUM = true;
                }
            }
            if (control_AJ_NUM == false) {
                System.out.println("Error!");
                break;
            } else {
                if (ControlField()) {
                    playerField(AJ1, num1, AJ2, num2);
                } else {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                }

            }
        }
    }

    public enum PlayerShips {

        AIRCRAFTCARRIER(5),
        BATTLESHIPS(4),
        SUBMARINE(3),
        CRUISERISALSO(3),
        DESTROYER(2);

        int size;
        PlayerShips (int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }

    public void playerField(int AJ1, int NUM1, int AJ2, int NUM2) {
        int count = 0;
        String parts = "";
        if (NUM1 < NUM2 && AJ1 == AJ2) {
            for (int i = NUM1; i <= NUM2; i++) {
                this.gameField[AJ1][i] = "O";
                parts += "" + ((char)(AJ1 + 64)) + i + " ";
                count++;
            }
        } else if (NUM1 > NUM2 && AJ1 == AJ2) {
            for (int i = NUM1; i >= NUM2; i--) {
                this.gameField[AJ1][i] = "O";
                parts += "" + ((char)(AJ1 + 64)) + i + " ";
                count++;
            }
        } else if (AJ1 < AJ2 && NUM1 == NUM2) {
            for (int i = AJ1; i <= AJ2; i++) {
                this.gameField[i][NUM1] = "O";
                parts += "" + ((char)(AJ1 + 63 + i)) + NUM1 + " ";
                count++;
            }

        } else if (AJ1 > AJ2 && NUM1 == NUM2) {
            for (int i = AJ1; i >= AJ2; i--) {
                this.gameField[i][NUM1] = "O";
                parts += "" + ((char) (AJ1 + 58 + i)) + NUM1 + " ";
                count++;
            }
        }
        printField();
        //System.out.println(String.format("Length: %d", count));
        //System.out.println(String.format("Parts: %s", parts));
    }

    public void playerships() {

        switch (playerships) {
            case AIRCRAFTCARRIER:
                System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");

        }
    }

    public boolean playerControlField(int AJ1, int AJ2, int num1, int num2) {
        boolean control = false;
        switch (playerships) {
            case AIRCRAFTCARRIER:
                if ((Math.abs(AJ1 - AJ2) + 2 == 5) || (Math.abs(num1 - num2) + 2 == 5) ) {
                    control = true;
                }

        }
    }


}

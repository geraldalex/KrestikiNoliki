
public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        Logic logic  = new Logic();
        System.out.println(ANSI_BLUE+"Крестики нолики  "+ANSI_RESET);
        logic.initField();
        logic.printField();
        while (true){
            System.out.println(ANSI_BLUE+"Введите коордиты ячейки 1-3 по Х и 1-3 по У через Enter"+ANSI_RESET);
            logic.movePerson();
            logic.printField();
            if(logic.chekWin(logic.PLAYER_CH)){
                System.out.println(ANSI_YELOW+"Победа игрока"+ANSI_RESET);
                break;
            }
            if(logic.isFreeYacheyka()){
                System.out.println(ANSI_YELOW+"Ничья"+ANSI_RESET);
                break;
            }
            System.out.println();
            System.out.println(ANSI_RED+"Ход компютера  "+ANSI_RESET);
            logic.moveAI();
            System.out.println();
            logic.printField();
            if(logic.chekWin(logic.AI_CH)){
                System.out.println(ANSI_RED+"Победа компютера"+ANSI_RESET);
                break;
            }
            if(logic.isFreeYacheyka()){
                System.out.println(ANSI_YELOW+"Ничья"+ANSI_RESET);
                break;
            }
        }
    }
}
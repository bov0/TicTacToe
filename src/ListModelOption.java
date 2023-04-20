
public class ListModelOption extends ModelOption {
    public ListModelOption(Model model) {
        super("Jugar", model);
    }

    public void interact() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("¿Cuantos jugadores vais a jugar?[1-2]");
        int jugadores = gestorIO.inInt();
        switch (jugadores) {
            case 1:
                new TicTacToeVSIA().jugar();
                break;
            case 2:
                new TicTacToe2Jugadores().jugar();
                break;
            default:
                new TicTacToeVSIA().jugar();
                break;
        }
    }

}
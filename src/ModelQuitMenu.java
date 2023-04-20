
public class ModelQuitMenu extends QuitMenu {

    private Model model;

    public ModelQuitMenu(Model model) {
        super("TicTacToe");
        this.model = model;
    }

    protected void addOptions() {
        this.add(new ListModelOption(this.model));
        this.add(new FindModelOption(this.model));
    }

}
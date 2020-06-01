package cli.states;

public interface State {
    public void onEnterState();
    public void observe();

}

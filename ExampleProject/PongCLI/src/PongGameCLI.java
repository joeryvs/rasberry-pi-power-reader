import java.time.Duration;

public class PongGameCLI extends CliGame {
    
    public PongGameCLI(){}

    @Override
    protected void Update(Duration duration) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    protected void Draw(Duration duration) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'Draw'");
        System.err.println(duration.toString());
    }
}

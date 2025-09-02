
public class PongGameCLI extends CliGame {

    PongBall pongBall;
    float widthVirtual = 300;
    float heightVirtual = 200;
    
    public PongGameCLI(){
        pongBall = new PongBall();
        pongBall.setPostion((new Position(150f, 100f)));
        pongBall.setVelocity(new Velocity(30f, -12f));
    }

    @Override
    protected void Update(float duration) {
        // step 1, update the pongball position.
        Position oldPosition = pongBall.getPostion(); 
        Velocity velocity = pongBall.getVelocity(); 
        float newPosx = oldPosition.X + duration * velocity.X; 
        float newPosy = oldPosition.Y + duration * velocity.Y; 
        // step 2 check if it remains in bounds
        // step 3 adjucst if needed.
    }

    @Override
    protected void Draw(float duration) {
        // step 1 get width and height
        int terminalWidth = 14;
        int terminalHeight = 15;

        char[][] screen = new char[terminalWidth][terminalHeight];
        for (int i = 0; i < terminalWidth; i++) {
            for (int j = 0; j < terminalHeight; j++) {
                screen[i][j] = ' ';
            }
        }
        // place borders
        // step 2 draw jail-cell virtually
        for (int i = 0; i < terminalHeight;i++){
            screen[0][i] = '|';
            screen[terminalWidth-1][i] = '|';
        }
        for (int i = 0; i < terminalWidth; i++) {
            screen[i][0] = '-';
            screen[terminalHeight-1][0] = '-';
        }

        
        // step 3 place ball
        var pos = pongBall.getPostion();
        int x = (int)((pos.X / widthVirtual) * (terminalWidth -2)) + 1;
        int y = (int)((pos.Y / heightVirtual) * (terminalHeight -2)) + 1;
        
        screen[x][y] = 'O';

        // step 4, result
        for (int i = 0; i < terminalHeight; i++) {
            for (int j = 0; j < terminalWidth; j++) {
                System.out.print(screen[j][i]);
            }
            System.out.println();
        }
    }
}

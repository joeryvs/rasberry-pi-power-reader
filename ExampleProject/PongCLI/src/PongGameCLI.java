
import java.util.ArrayList;
import java.util.List;


public class PongGameCLI extends CliGame {

    List<PongBall> pongBalls;
    float widthVirtual = 300;
    float heightVirtual = 200;
    
    public PongGameCLI(){
        pongBalls = new ArrayList<>();
        var pongBall = new PongBall();
        pongBall.setPostion((new Position(150f, 100f)));
        pongBall.setVelocity(new Velocity(30f, -12f));
        pongBalls.add(pongBall);
        var pongBall2 = new PongBall();
        pongBall2.setPostion((new Position(230f, 78f)));
        pongBall2.setVelocity(new Velocity(-50f, 9f));
        pongBalls.add(pongBall2);
    }

    @Override
    protected void Update(float duration) {
        // step 1, update the pongball position.
        for (PongBall pongBall: pongBalls){
            pongBall.UpdatePosition(duration, widthVirtual, heightVirtual);
        }
        // step 2 check if it remains in bounds
        // step 3 adjucst if needed.
    }

    @Override
    protected void Draw(float duration) {
        // step 1 get width and height
        int terminalWidth = 60;
        int terminalHeight = 15;

        char[][] screen = new char[terminalHeight][terminalWidth];
        for (int i = 0; i < terminalWidth; i++) {
            for (int j = 0; j < terminalHeight; j++) {
                screen[j][i] = ' ';
            }
        }
        // place borders
        // step 2 draw jail-cell virtually
        for (int i = 0; i < terminalHeight;i++){
            screen[i][0] = '|';
            screen[i][terminalWidth-1] = '|';
        }
        for (int i = 0; i < terminalWidth; i++) {
            // first and last row
            screen[0][i] = '-';
            screen[terminalHeight-1][i] = '-';
        }

        
        // step 3 place ball
        for (PongBall pongBall : pongBalls) {
            
            var pos = pongBall.getPostion();
            int x = (int)((pos.X / widthVirtual) * (terminalWidth -2)) + 1;
            int y = (int)((pos.Y / heightVirtual) * (terminalHeight -2)) + 1;
            
            screen[y][x] = 'O';
        }

        // step 4, result
        System.out.print("\033[H\033[2J");
        for (int i = 0; i < terminalHeight; i++) {
            System.out.print(screen[i]);
            System.out.println();
        }
        System.out.flush();
    }
}

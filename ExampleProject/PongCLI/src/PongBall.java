
import java.time.Duration;

public class PongBall {

    private Position postion;
    private Velocity velocity;

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public Position getPostion() {
        return postion;
    }

    public void setPostion(Position postion) {
        this.postion = postion;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void UpdatePosition(Duration duration){
        // TODO
    }
    
}

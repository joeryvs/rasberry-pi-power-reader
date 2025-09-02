

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

    public void UpdatePosition(float duration, float width,float height){
        float newPosx = this.postion.X + duration * velocity.X; 
        float newPosy = this.postion.Y + duration * velocity.Y; 

        if (newPosx >= width){
            newPosx = 2 * width - newPosx;
            velocity.X *= -1;
        }
        if (newPosy >= height){
            newPosy = 2 * height - newPosy;
            velocity.Y *= -1;
        }
        if (newPosx < 0 ){
            newPosx = -newPosx;
            velocity.X *= -1;
        }
        if (newPosy < 0){
            newPosy = -newPosy;
            velocity.Y *= -1;
        }

        Position newPostion = new Position(newPosx, newPosy);
        this.setPostion(newPostion);
    }
    
}

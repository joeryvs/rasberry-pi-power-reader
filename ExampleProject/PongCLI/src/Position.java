public class Position {
    public float X;
    public float Y;

    public  Position(float  x,float  y){
        this.X = x;
        this.Y = y;
    }
    public  Position(float number){
        this.X = number;
        this.Y = number;
    }
    public  Position(){
        this.X = 0.0f;
        this.Y = 0.0f;
    }
}

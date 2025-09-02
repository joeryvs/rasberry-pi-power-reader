import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
public abstract class CliGame {

    protected boolean running = false;
    protected float frameRate = 20;
    public CliGame(){}

    public void Run() throws InterruptedException{
        if (running) return;
        Clock clock = Clock.systemDefaultZone();
        Instant before = clock.instant();
        this.running = true;
        while (running){
            // get time 
            Instant endGoal = before.plusMillis((long)(1000 / this.frameRate));

            // time passed = 
            // int longPassed = clock.instant().minus();
            Duration x = Duration.between(before, clock.instant());
            // update
            this.Update(x);
            // draw
            this.Draw(x);
            // wait until next update should happen
            while (before.isBefore(endGoal)) { 
                before.wait(1,100);
            }
            before = clock.instant();

        }
    }
    protected abstract void Update(Duration duration);
    protected abstract void Draw(Duration duration);
}

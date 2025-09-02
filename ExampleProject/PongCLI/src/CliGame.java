import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
public abstract class CliGame {

    protected boolean running = false;
    protected float frameRate = 3;
    public CliGame(){}

    public void Run() throws InterruptedException{
        if (running) return;
        Clock clock = Clock.systemDefaultZone();
        Instant before1 = clock.instant();
        Instant before2 = clock.instant();
        this.running = true;
        while (running){
            // get time 
            Instant endGoal = before1.plusMillis((long)(1000 / this.frameRate));
            before2 = clock.instant();
            // time passed = 
            // int longPassed = clock.instant().minus();
            Duration x = Duration.between(before1, before2);
            float seconds = ((float)x.toNanos() / 1_000_000) / 500;
            // update
            this.Update(seconds);
            // draw
            this.Draw(seconds);
            // wait until next update should happen
            var timeToSleep = Duration.between(endGoal, clock.instant());
            Thread.sleep(timeToSleep.toMillis());
            while (clock.instant().isBefore(endGoal)) { 
                // before.wait(1,100);
            }
            // clock.wait();
            before1 = before2;
            // before2 = clock.instant();

        }
    }
    protected abstract void Update(float duration);
    protected abstract void Draw(float duration);
}

package parts;

abstract public class Part {
   int durationInSeconds;
   public Part(int durationInSeconds) {
      this.durationInSeconds = durationInSeconds;
   }
   public int getDurationInSeconds() {
      return durationInSeconds;
   }
   public abstract double getPricePerSecond();
}

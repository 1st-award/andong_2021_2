public class Car {
    protected String color;
    protected int speed = 0;

    // return speed
    public int getSpeed() {
        return speed;
    }
    // speed increase
    public void upSpeed(int value) {
        // maximum speed 200
        if(speed + value >= 200)
            speed = 200;
        // down to 200
        else
            speed = speed + value;
    }
    // speed decrease
    public void downSpeed(int value) {
        // minimum speed 0
        if(speed - value <= 0)
                speed = 0;
        // up to 0
        else
            speed = speed - value;
    }
    // return color
    public String getColor() {
        return color;
    }
}

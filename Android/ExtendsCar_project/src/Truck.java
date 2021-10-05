public class Truck extends Car{
    // 배기량 변수 cc를 추가한다. (정수형)
    private int cc;
    // 트럭의 생산 연도 상수 필드 YEAR를 선언하고, 값을 2013으로 한다.
    protected final int YEAR = 2013;
    // 배기량 값을 파라미터로 받는 생성자를 추가한다.
    public Truck(int cc) {
        this.cc = cc;
    }
    // 배기량을 반환하는 getCC() 메소드를 추가한다.
    public int getCC() {
        return cc;
    }
    // upSpeed(int) 메소드를 최대 속도 150으로 오버라이딩한다.
    @Override
    public void upSpeed(int value) {
        // maximum speed 150
        if(speed + value >= 150)
            speed = 150;
            // down to 200
        else
            speed = speed + value;
    }
}

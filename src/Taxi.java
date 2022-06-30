public class Taxi {
    private static int count; // 고유 번호 count 증가시키면서 생성
    private int taxiNo; // 택시 고유 번호
    private int remainFuel; // 주유량
    private int currentSpeed; // 택시 현재 속도
    private String destination = ""; // 목적지
    private final int distance = 2000; // 택시 기본거리
    private int toDestDistance; // 목적지까지 거리
    private final int fare = 3300; // 택시 기본요금
    private final int extraFare = 100;
    private String status;
    private int totalFare;

    public Taxi() {
        this.setTaxiNo(count);
        this.setDestination("미정");
        this.setRemainFuel(20);
        this.setCurrentSpeed(30);
        this.setToDestDistance(0);
        this.setStatus("일반");
        System.out.println(taxiNo + "번 택시가 생성되었습니다.");
    }

    public int getTaxiNo() {
        return taxiNo;
    }

    public void setTaxiNo(int taxiNo) {
        this.taxiNo = taxiNo;
        count++;
    }

    public int getRemainFuel() {
        return remainFuel;
    }

    public void setRemainFuel(int remainFuel) {
        if (remainFuel < 0) {
            System.out.println("주유량은 양수만 입력 가능합니다.");
            return;
        }
        this.remainFuel = remainFuel;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        if(currentSpeed < 0) {
            System.out.println("현재 속도는 양수만 입력 가능합니다.");
            return;
        }
        this.currentSpeed = currentSpeed;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public int getToDestDistance() {
        return toDestDistance;
    }

    public void setToDestDistance(int toDestDistance) {
        this.toDestDistance = toDestDistance;
    }

    public int getFare() {
        return fare;
    }

    public int getExtraFare() {
        return extraFare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(int totalFare) {
        this.totalFare = totalFare;
    }

    public void run() { //운행 시작
        if(this.getRemainFuel() < 10) {
            System.out.println("주유량을 확인해 주세요.");
            return;
        }
        this.setStatus("운행 중");
    }

    public void board() { //탑승
        if(this.getRemainFuel() >= 10){
            if (this.getStatus() != "일반") {
                System.out.println("탑승 불가.");
                return;
            } else {
                run();
            }

        } else {
            System.out.println("탑승 불가.");
            return;
        }
    }
    public void changeSpeed(int speed) { //속도 변경
        if (this.getRemainFuel() < 0) {
            System.out.println("주유가 필요합니다");
            return;
        }
        this.setCurrentSpeed(this.getCurrentSpeed() + speed);
    }

    public void addExtraFare() { // 거리당 요금 추가
        this.setTotalFare(fare + (this.getExtraFare() * ((this.getToDestDistance() - distance)/100)));
    }

    public void pay() {
        if(this.getToDestDistance() > distance){
            addExtraFare();
            System.out.println("최종 요금은 " + this.getTotalFare() + "원 입니다.");
            return;
        }
        System.out.println("최종 요금은 " + fare + "원 입니다.");
    }

    public void show() {
        System.out.print(this.getTaxiNo() + "번 택시의 "); //택시 번호
        System.out.print("목적지는 " + this.getDestination() + ", "); //택시의 목적지
        System.out.print("목적지 까지 거리는 " + this.getToDestDistance() + ", "); //목적지까지 거리
        System.out.print("기본 거리는 " + this.getDistance() + ", "); //택시 기본 거리
        System.out.print("기본 요금은 " + this.fare + "원, "); //요금
        System.out.print("기본 거리 초과시 추가 요금은 " + "100m당 " + this.getExtraFare() + "원, "); //추가 요금
        System.out.print("남은 기름은 " + this.getRemainFuel() + "L, "); //주유량
        System.out.print("현재 속도는 " + this.getCurrentSpeed() + "km/h, "); //현재속도
        System.out.print("현재 상태는 " + this.getStatus() + "입니다"); //상태
        if(this.toDestDistance > distance){
            System.out.println("예상 요금은" + (fare + (this.getExtraFare() * ((this.getToDestDistance() - distance)/100))) + "원입니다."); //최종 요금
        } else{
            System.out.println("예상 요금은" + fare + "원입니다."); //최종 요금
        }
    }
}

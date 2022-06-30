public class Bus {
    private static int count; //
    private int busNo; // 버스 고유 번호
    private final int maxPassenger = 30; // 버스 최대 승객 수
    private int currentPassenger; // 버스 현재 승객 수
    private final int fare = 1250; // 버스 요금
    private int remainFuel; // 주유량
    private int currentSpeed; // 버스 현재 속도
    private String status; //버스 상태 (운행, 차고지행)
    private int totalFare; //버스 총 요금


    public Bus() {
        this.setBusNo(count);
        this.setRemainFuel(20); //기본 주유량
        this.setStatus("운행");
        this.setCurrentSpeed(30); //기본 속도
        this.setCurrentPassenger(0); //기본 승객수
        System.out.println(this.getBusNo() + "번 버스가 생성되었습니다.");
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
        count++;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public int getCurrentPassenger() {
        return currentPassenger;
    }

    public void setCurrentPassenger(int currentPassenger) {
        if (currentPassenger < 0) {
            System.out.println("현재 승객 수는 양수만 입력 가능합니다.");
            return;
        }
        if (this.status != "운행" || currentPassenger > maxPassenger) {
            System.out.println("버스가 운행 중이 아니거나 입력 승객 수가 최대 승객 수를 초과했습니다.");
            return;
        }
        this.currentPassenger = currentPassenger;
    }

    public int getFare() {
        return fare;
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
        if (this.status != "운행") {
            System.out.println("현재 버스 운행 중이 아닙니다.");
            return;
        }
        if (currentSpeed < 0) {
            System.out.println("현재 속도는 양수만 입력 가능합니다.");
            return;
        }
        this.currentSpeed = currentSpeed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (this.remainFuel < 10) {
//            if(status == "운행") {
//                System.out.println("주유가 필요합니다");
//                return;
//            }
            System.out.println("주유가 필요합니다.");
        }
        this.status = status;
    }

    public void run() { //운행
        System.out.println("하이");
    }

    public void stop() { //운행 종료
        this.setStatus("차고지행");
        this.setCurrentSpeed(0);
        this.setCurrentPassenger(0);
    }

    public void board(int passenger) { //탑승
        if(this.getRemainFuel() >= 10){
            if (this.getStatus() != "운행" || this.getCurrentPassenger() == this.maxPassenger) {
                System.out.println("버스가 운행중이 아니거나 자리가 없습니다.");
                return;
            }
            else {
                if(this.getRemainFuel()-passenger < 10) {
                    System.out.println("기름이 부족해서 탈 수 없습니다.");
                    return;
                }
                System.out.println(this.getBusNo() + "번 버스" + passenger + "명 탑승");
                this.setCurrentPassenger(this.getCurrentPassenger() + passenger);
                this.setRemainFuel(this.getRemainFuel()-passenger);
                return;
            }
        } else {
            System.out.println("주유량을 확인해 주세요.");
            stop();
            return;
        }
    }

    public void changeSpeed(int speed) {
        if (this.getStatus() != "운행") {
            System.out.println("버스가 운행중이 아닙니다.");
        }
        if (this.getRemainFuel() < 0) {
            System.out.println("주유가 필요합니다");
            return;
        }
        this.setCurrentSpeed(this.getCurrentSpeed() + speed);
    }

    public void show() {
        System.out.print(this.getBusNo() + "번 버스의 "); //버스 번호
        System.out.print("최대 승객수는 " + maxPassenger + "명, "); //최대 승객수
        System.out.print("현재 승객수는 " + this.getCurrentPassenger() + "명, "); //현재 승객수
        System.out.print("요금은 " + fare + "원, "); //요금
        System.out.print("남은 기름은 " + this.getRemainFuel() + "L, "); //주유량
        System.out.print("현재 속도는 " + this.getCurrentSpeed() + "km/h, "); //현재속도
        System.out.println("현재 상태는 " + this.getStatus() + "입니다"); //상태
    }
}

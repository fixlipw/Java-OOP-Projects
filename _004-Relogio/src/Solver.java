

import java.util.Scanner;

class Time {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public Time(int hour, int minute, int second){
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public void setHour(int hour){
        if(this.hour >= 0 && hour<=23){
            this.hour = hour;
        }
        else
            System.out.println("fail: hora invalida");
    }

    public void setMinute(int minute){
        if(this.minute >= 0 && minute <=59){
            this.minute = minute;
        }
        else
            System.out.println("fail: minuto invalido");
    }


    public void setSecond(int second){
        if(this.second >= 0 && second <=59){
            this.second = second;
        }
        else
            System.out.println("fail: segundo invalido");
    }

    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }

    public int getSecond(){
        return second;
    }

    //avança o tempo em um segundo
    public void nextSecond(){
        if(second < 59){
            second++;
        }
        else{
            second = 0;
        }
        if(minute < 59){
            minute++;
        }
        else{
            minute = 0;
        }
        if(hour < 23){
            hour++;
        }
        else{
            hour = 0;
        }

    }; // todo

    public String toString() {
        return String.format("%02d", hour) + ":" +
                String.format("%02d", minute) + ":" +
                String.format("%02d", second);
    }
}

class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time time = new Time(0, 0, 0);
        label:
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);

            String[] ui = line.split(" ");
            String cmd = ui[0];

            switch (cmd) {
                case "end":
                    break label;
                case "set":
                    time.setHour(Integer.parseInt(ui[1]));
                    time.setMinute(Integer.parseInt(ui[2]));
                    time.setSecond(Integer.parseInt(ui[3]));
                    break;
                case "show":
                    System.out.println(time);
                    break;
                case "next":
                    time.nextSecond();
                    break;
                default:
                    System.out.println("fail: comando inválido");
                    break;
            }
        }
        scanner.close();
    }
}
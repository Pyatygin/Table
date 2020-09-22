//Создание объектов с параметрами
public class Kindergarten {


    // объявление переменных в классе
    private String name;
    private int manNow;
    private int max;
    private int money;

    // присовение значений переменным
    public Kindergarten(String name, int manNow, int max, int money) {
        this.name = name;
        this.manNow = manNow;
        this.max = max;
        this.money= money;
    }

    // возврат имени переменной класса киндергарден
    public String getName() {
        return name;
    }

    // возврат кол-ва детей класса киндергарден
    public int getmanNow() {
        return manNow;
    }

    // возврат максимального количества детей  класса киндергарден
    public int getMax() {
        return max;
    }

    //возврат ежемесячной стоимости  класса киндергарден
    public int getMoney() {
        return money;
    }

    // установка имени переменной класса киндергарден
    public void setName(String name){
        this.name= name;
    }

    // установка кол-ва детей класса киндергарден
    public void setManNow(int manNow) {
        this.manNow = manNow;
    }

    // установка максимального количества детей класса киндергарден
    public void setMax(int max) {
        this.max = max;
    }

    // установка ежемесячной стоимости класса киндергарден
    public void setMoney(int money) {
        this.money = money;
    }
}
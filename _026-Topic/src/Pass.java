public class Pass {
    private int age;
    private String name;

    public Pass(String name, int age){
        setAge(age);
        setName(name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPriority(){
        return getAge() > 64;
    }

    @Override
    public String toString() {
        return getName() + ":" + getAge();
    }
}

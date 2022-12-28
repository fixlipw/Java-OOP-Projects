import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Topic {
    protected ArrayList<Pass> normalSeats;
    protected ArrayList<Pass> prioritySeats;

    private static int findFree(List<Pass> list){
        return IntStream.range(0, list.size())
                .filter(i-> null == list.get(i))
                .findFirst()
                .orElse(-1);
    }

    private static int findName(List<Pass> list, String name){
        return IntStream.range(0, list.size())
                .filter(i-> list.get(i) != null && Objects.equals(list.get(i).getName(), name))
                .findFirst()
                .orElse(-1);
    }

    private static boolean insert(List<Pass> list, Pass pass){
        int index = findFree(list);
        if(index != -1){
            list.set(index, pass);
            return true;
        }
        return false;
    }

    private static boolean remove(List<Pass> list, String name){
        int index = findName(list, name);
        if(index != -1){
            list.set(index, null);
            return true;
        }
        return false;
    }

    public Topic(int capacity, int priorityCapacity){
        normalSeats = new ArrayList<>(capacity - priorityCapacity);
        for(int i = 0; i < capacity-priorityCapacity; i++) normalSeats.add(null);
        prioritySeats = new ArrayList<>(priorityCapacity);
        for(int i = 0; i < priorityCapacity;i++) prioritySeats.add(null);
    }
    
    public boolean insert(Pass pass){
        if((findName(prioritySeats, pass.getName())!= -1) || (findName(normalSeats, pass.getName())) != -1){
            System.out.println("fail: "+pass.getName()+" ja esta na topic");
            return false;
        }
        if(pass.isPriority()){
            if (!insert(prioritySeats, pass) && !insert(normalSeats, pass)) {
                System.out.println("fail: topic lotada");
                return false;
            }
            return true;
        }
        if (insert(normalSeats, pass) || insert(prioritySeats, pass)) {
            return true;
        }
        System.out.println("fail: topic lotada");
        return false;
    }
    
    public boolean remove(String name){
        if(!remove(prioritySeats, name) && !remove(normalSeats, name)){
            System.out.println("fail: "+name+" nao esta na topic");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + Stream.concat(
                        this.prioritySeats.stream().map(p -> ("@" + ((p == null)?(""):("" + p)))),
                        this.normalSeats.stream().map(p -> ("=" + ((p == null)?(""):("" + p)))))
                        .collect(Collectors.joining(" ")) + "]";
    }
}

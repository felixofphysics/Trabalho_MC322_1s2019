import java.util.LinkedList;

public class vetor {

    public LinkedList createList(String[][] instances){
        LinkedList diagnosis = new LinkedList();
        for (int i = 0; i < instances.length; i++) {
            diagnosis.add(i);
        }
        return diagnosis;
    }
}

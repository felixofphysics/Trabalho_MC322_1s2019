import java.util.LinkedList;

public class Doctor implements IDoctor {
    private ITableProducer producer;
    private IResponder responder;

    public void connect(ITableProducer producer) {
        this.producer = producer;
    }

    public void connect(IResponder responder) {
        this.responder = responder;
    }

    public void startInterview() {
        String attributes[] = producer.requestAttributes();
        String instances[][] = producer.requestInstances();
        vetor eficiencia = new vetor();

        LinkedList vetor = eficiencia.createList(instances);
        int length = vetor.size();

        for (int a = 0; a < attributes.length - 1; a++){
            String resposta = responder.ask(attributes[a]);
            for (int i = (int) vetor.get(0); i < length; i++) {
                if(!vetor.contains((Object) i))
                    continue;
                if (((instances[i][a]).equalsIgnoreCase("t") && resposta.equalsIgnoreCase("no"))
                || ((instances[i][a]).equalsIgnoreCase("f") && resposta.equalsIgnoreCase("yes"))) {
                    vetor.remove((Object) i);
                }
            }
            System.out.println("Question " + attributes[a] + ": " + responder.ask(attributes[a]));
        }

        System.out.println("Disease guess: " + instances[(int)vetor.get(0)][instances[0].length -1]);
        if(vetor.size() > 1)
            System.out.println("Disease guess: " + instances[(int)vetor.get(1)][instances[0].length -1]);
        boolean result = responder.finalAnswer(instances[(int)vetor.get(0)][instances[0].length -1]);
        System.out.println("Result: " + ((result) ? "I am right =)" : "I am wrong =("));
    }
}
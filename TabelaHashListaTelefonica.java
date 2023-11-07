import java.util.ArrayList;
import java.util.List;

public class TabelaHashListaTelefonica implements TabelaHash_IF{
    private int size;
    private List<List<Contato>> gride;

    public TabelaHashListaTelefonica(int size){
        this.size = size;
        this.gride = new ArrayList<>(size);

        for(int i=0; i<size; i++){
            gride.add(new ArrayList<>());
        }
    }
    private int hash(String name){
        int somaAscii = 0;

        for(char c : name.toCharArray()){
            somaAscii += (int) c;
        }
        return somaAscii % size;
    }

    @Override
    public void insert(int element) {
        String name = element.getName();
        int index = hash(name);
        gride.get(index).get(element);
    }

    @Override
    public void remove(int element) throws Exception {
        String name = element.getName();
        int index = hash(name);
        List<Contato> list = gride.get(index);

        for(Contato contato : list){
            if(contato.getName().equals(name)){
                list.remove(contato);
                return;
            }
        }
        throw new Exception("O contato informado não foi encontrado na lista telefônica.");
    }

    @Override
    public int search(int element) throws Exception {
        String name = element.getName();
        int index = hash(name);
        List<Contato> list = gride.get(index);

        for(Contato contato : list){
            if(contato.getName().equals(name)){
                return contato;
            }
        }
        throw new Exception("O contato informado não foi encontrado na lista telefônica.");
    }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();

        for(int i=0; i<size; i++){
            result.append(i).append(": ");

            if(!gride.get(i).isEmpty()){
                for(int j=0; j<gride.get(i).size(); j++){
                    result.append(gride.get(i).get(j).getName());
                    if(j < gride.get(i).size() - 1){
                        result.append(", ");
                    }
                }
            }
            result.append("\n ");
        }
        return result.toString();
    }
    
}
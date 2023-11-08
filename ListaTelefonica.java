import java.util.LinkedList;

public class ListaTelefonica implements TabelaHash_IF {
    private LinkedList<Entry>[] table;
    private int capacity;

    private class Entry {
        String name;
        int phoneNumber;

        Entry(String name, int phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
    @SuppressWarnings("unchecked")
    public ListaTelefonica(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int element) {
        return element % capacity;
    }

    @Override
    public void insert(int phoneNumber) {
        insert(null, phoneNumber); 
    }

    public void insert(String name, int phoneNumber) {
        int index = hash(phoneNumber);
        LinkedList<Entry> bucket = table[index];

        for (Entry entry : bucket) {
            if (entry.phoneNumber == phoneNumber) {
                entry.name = name;
                return;
            }
        }

        bucket.add(new Entry(name, phoneNumber));
    }

    @Override
    public void remove(int phoneNumber) throws Exception {
        int index = hash(phoneNumber);
        LinkedList<Entry> bucket = table[index];

        for (Entry entry : bucket) {
            if (entry.phoneNumber == phoneNumber) {
                bucket.remove(entry);
                return;
            }
        }
        throw new Exception("Número de telefone não encontrado na agenda.");
    }

    @Override
    public int search(int phoneNumber) throws Exception {
        int index = hash(phoneNumber);
        LinkedList<Entry> bucket = table[index];

        for (Entry entry : bucket) {
            if (entry.phoneNumber == phoneNumber) {
                return entry.phoneNumber;
            }
        }
        throw new Exception("Número de telefone não encontrado na agenda.");
    }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < capacity; i++) {
            LinkedList<Entry> bucket = table[i];
            for (Entry entry : bucket) {
                if (entry.name != null) {
                    result.append("Nome: ").append(entry.name).append(", Telefone: ").append(entry.phoneNumber).append("\n");
                }
            }
        }
        if(result.isEmpty()) result.append("A Agenda está vazia.");
        return result.toString();
    }
}

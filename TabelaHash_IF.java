public interface TabelaHash_IF {
    public void insert(int element);
    
    public void remove(int element) throws Exception;
    
    public int search(int element) throws Exception;
    
    public String print();
}

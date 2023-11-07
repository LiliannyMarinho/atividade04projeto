public class ListaTelefonica {
    private TabelaHashListaTelefonica gride_Contatos;

    public ListaTelefonica(int sizeGride){
        gride_Contatos = new TabelaHashListaTelefonica(sizeGride);
    }

    public void addContato(Contato contato){
        gride_Contatos.insert(contato);
    }

    public void removContato(String name) throws Exception {
        Contato contato = gride_Contatos.search(name);
        gride_Contatos.remove(contato);
    }

    public Contato buscContato(String name) throws Exception {
        return gride_Contatos.search(name);
    }

    public String printList(){
        return gride_Contatos.print();
    }
}

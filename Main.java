public class Main {
    public static void main(String[] args){
        ListaTelefonica phoneBook = new ListaTelefonica(25);

        Contato contato1 = new Contato("Everaldo", "9999-9999");
        Contato contato2 = new Contato("Tatiane","8888-8888");
        Contato contato3 = new Contato("Lilianny", "7777-7777");

        phoneBook.addContato(contato1);
        phoneBook.addContato(contato2);
        phoneBook.addContato(contato3);

        System.out.println("-------------------\nLista Telefônica\n-------------------");
        System.out.println(phoneBook.printList());

        try {
            Contato x = phoneBook.buscContato("Everaldo");
            System.out.println("Contato encontrado: "+x.getName());
        } catch (Exception e) {
            System.out.println("Contato não encontrado na lista telefônica.");
        }
        try {
            phoneBook.removContato("Lilianny");
            System.out.println("Contato removido com sucesso.");
        } catch (Exception e) {
            System.out.println("Falha ao remover o contato: " + e.getMessage());
        }

        System.out.println("\n-------------------Lista Atualizada\n-------------------");
        System.out.println(phoneBook.printList());
    }
}

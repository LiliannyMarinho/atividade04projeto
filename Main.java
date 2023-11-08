public class Main {
	public static void main(String[] args) {
        ListaTelefonica agenda = new ListaTelefonica(10);

        System.out.println("Agenda Telefônica:");
        System.out.println(agenda.print());

        System.out.println("\nInserindo contatos.");
        agenda.insert("Tatiane", 777777777);
        agenda.insert("Lilianny", 888888888);
        agenda.insert("Everaldo", 999999999);        

        System.out.println("Agenda Telefônica:");
        System.out.println(agenda.print());
        System.out.println("\nBuscando número:");

        try {
            int numeroTelefone = agenda.search(888888888);
            System.out.println("Número de Telefone encontrado: " + numeroTelefone + "\n");            
            System.out.println("\nRemovendo número: " + numeroTelefone);
            agenda.remove(999999999);
            System.out.println("\nAgenda Telefônica:");
            System.out.println(agenda.print());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

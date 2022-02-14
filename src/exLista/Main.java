package exLista;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<AtualizaSalario> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			AtualizaSalario func = new AtualizaSalario();
			
			System.out.println();
			System.out.println("Employee #" + (i+1) + ": ");
			System.out.print("Id: ");
			func.setId(sc.nextInt());
			System.out.print("Nome: ");
			sc.nextLine();
			func.setNome(sc.nextLine());
			System.out.print("Salário: ");
			func.setSalario(sc.nextDouble());
			
			list.add(func);
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idSalary = sc.nextInt();
		
		//Teste com lambda
		/*atualizaSalario atl = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		if (atl == null) {
			System.out.println("Esse id não existe");
		} else {
			System.out.print("Digite a porcentagem: ");
			
		}*/
		System.out.println();
		Integer pos = position(list, idSalary);
		if(pos == null) {
			System.out.println("Esse id não existe!");
		} else {
			System.out.print("Digite a porcentagem: ");
			double percent = sc.nextDouble();
			list.get(pos).aumentaSalario(percent);
		}
		
		System.out.println();
		System.out.println("Lista de funcionários: \n");
		for (AtualizaSalario func : list) {
			System.out.println(func.toString());
		}
		
		sc.close();
	}
	
	public static Integer position(List<AtualizaSalario> list, int id) {
		for(int i=0; i<list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
}
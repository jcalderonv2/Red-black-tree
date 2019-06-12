package redBlack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	static RedBlackTree tree = new RedBlackTree(0);

	public static void main(String[] args) throws IOException {

		menu();

	}

	public static void menu() throws IOException {

		int opc = -1;

		do {

			out.println();
			out.println("----MENU PRINCIPAL ROJO NEGRO----");
			out.println();
			out.println("1.  Insertar");
			out.println("2.  Mostrar");
			out.println("3.  Salir");
			out.println();
			out.println(" Digite la opcion: ");
			out.println();
			opc = Integer.parseInt(in.readLine());
			out.println();
			option(opc);
			out.println();
		} while (opc != 3);

	}

	static void option(int popc) throws IOException {

		switch (popc) {

		case 1:

			insert();
			break;

		case 2:

			show();
			break;

		default:

			out.println("Opcion invalida.");
			out.println();
			break;

		}

	}

	private static void insert() throws NumberFormatException, IOException {

		int data;
		System.out.println("\nDigite el dato que desea ingresar\n");
		data = Integer.parseInt(in.readLine());
		tree.insert(data);
		System.out.println("\nDato ingresado correctamente.\n");

	}

	private static void show() {

		out.print("\nPost order: ");
		tree.postorder();
		out.print("\nPre order: ");
		tree.preorder();
		out.print("\nIn order: ");
		tree.inorder();

	}
}

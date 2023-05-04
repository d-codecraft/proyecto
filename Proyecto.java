import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

public class Proyecto extends JFrame implements ActionListener {
    
    private JLabel welcomeLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    public Proyecto() {
        setTitle("Inicio de sesión");
        setSize(300, 130);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        welcomeLabel = new JLabel("Bienvenido, por favor ingrese sus credenciales");
        usernameLabel = new JLabel("Nombre de usuario:");
        passwordLabel = new JLabel("Contraseña:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener(this);
        
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);
        
        setLayout(new BorderLayout());
        add(welcomeLabel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        
        if (isValid(username, password)) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");

            String[] opciones = {"Numeros Primos", "Factorial", "Calculadora", "Contar Vocales", "Tabla de Multiplicar", "Ordenar Numeros"};
            int seleccion = JOptionPane.showOptionDialog(this, "Seleccione un ejercicio", "Ejercicios", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            
            // Dependiendo de la opción seleccionada, iniciar el ejercicio correspondiente
            if (seleccion == 0) {
                //Numeros Primos
                // Iniciar Ejercicio 1
                 // Pedimos al usuario que ingrese un número entero
                int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número entero:"));

                boolean esPrimo = true; // suponemos que es primo al principio

                // comprobamos si el número es divisible por algún otro número diferente a 1 y a sí mismo
                for (int i = 2; i < numero; i++) {
                    if (numero % i == 0) {
                        esPrimo = false; // si es divisible, no es primo
                        break;
                    }
                }

                // mostramos el resultado al usuario
                if (esPrimo) {
                    JOptionPane.showMessageDialog(null, numero + " es un número primo");
                } else {
                    JOptionPane.showMessageDialog(null, numero + " no es un número primo");
                }

            } else if (seleccion == 1) {
                //Factorial
                // Iniciar Ejercicio 2
                 // Pedimos al usuario que ingrese un número entero positivo
                int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número entero positivo:"));

                int factorial = 1; // inicializamos el factorial en 1

                // calculamos el factorial del número ingresado
                for (int i = 1; i <= numero; i++) {
                    factorial *= i;
                }

                // mostramos el resultado al usuario
                JOptionPane.showMessageDialog(null, "El factorial de " + numero + " es " + factorial);

            } else if (seleccion == 2) {
                //Calculadora
                // Iniciar Ejercicio 3
                // Pedimos al usuario que ingrese dos números
                double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer número:"));
                double numero2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo número:"));

                // Pedimos al usuario que elija la operación a realizar
                String[] opcione = {"Sumar", "Restar", "Multiplicar", "Dividir"};
                int seleccio = JOptionPane.showOptionDialog(null, "Seleccione la operación a realizar:", "Calculadora",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcione, opcione[0]);

                double resultado = 0; // inicializamos el resultado en 0

                // realizamos la operación correspondiente
                switch (seleccio) {
                    case 0: // suma
                        resultado = numero1 + numero2;
                        break;
                    case 1: // resta
                        resultado = numero1 - numero2;
                        break;
                    case 2: // multiplicación
                        resultado = numero1 * numero2;
                        break;
                    case 3: // división
                        resultado = numero1 / numero2;
                        break;
                }

                // mostramos el resultado al usuario
                JOptionPane.showMessageDialog(null, "El resultado es " + resultado);


            } else if (seleccion == 3) {
                //Contar Vocales
                // Iniciar Ejercicio 4
                 // Pedimos al usuario que ingrese una cadena de caracteres
                String cadena = JOptionPane.showInputDialog("Ingrese una cadena de caracteres:");

                int contadorVocales = 0; // inicializamos el contador de vocales en 0

                // recorremos la cadena de caracteres
                for (int i = 0; i < cadena.length(); i++) {
                    // comprobamos si el caracter actual es una vocal
                    char caracterActual = cadena.charAt(i);
                    if (caracterActual == 'a' || caracterActual == 'e' || caracterActual == 'i' || caracterActual == 'o' || caracterActual == 'u' ||
                            caracterActual == 'A' || caracterActual == 'E' || caracterActual == 'I' || caracterActual == 'O' || caracterActual == 'U') {
                        contadorVocales++; // si es una vocal, aumentamos el contador
                    }
                }

                // mostramos el resultado al usuario
                JOptionPane.showMessageDialog(null, "La cadena de caracteres ingresada tiene " + contadorVocales + " vocales");


            } else if (seleccion == 4) {
                //Tabla de Multiplicar
                // Iniciar Ejercicio 5
                String tabla = ""; // inicializamos la tabla en una cadena vacía

                // realizamos la tabla de multiplicar para los números del 1 al 10
                for (int i = 1; i <= 10; i++) {
                    for (int j = 1; j <= 10; j++) {
                        int resultado = i * j;
                        tabla += i + " x " + j + " = " + resultado + "\n";
                    }
                    tabla += "\n"; // agregamos una línea en blanco para separar las tablas de cada número
                }
        
                // mostramos la tabla al usuario
                JOptionPane.showMessageDialog(null, tabla);

            } else if (seleccion == 5) {
                // Ordenar Numeros
                // Iniciar Ejercicio 6
                // Pedimos al usuario que ingrese la cantidad de números que desea generar
                int cantidadNumeros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de números que desea generar:"));

                int[] numeros = new int[cantidadNumeros]; // creamos un arreglo para almacenar los números

                // Generamos números aleatorios y los almacenamos en el arreglo
                Random rand = new Random();
                for (int i = 0; i < cantidadNumeros; i++) {
                    numeros[i] = rand.nextInt(100); // generamos números aleatorios entre 0 y 99
                }

                // Ordenamos el arreglo de menor a mayor
                Arrays.sort(numeros);

                // Mostramos los números ordenados al usuario
                String numerosOrdenados = "Los números generados y ordenados son:\n";
                for (int i = 0; i < cantidadNumeros; i++) {
                    numerosOrdenados += numeros[i] + "\n";
                }

                JOptionPane.showMessageDialog(null, numerosOrdenados);

            } 

            //Termina los ejercios

        } else {
            JOptionPane.showMessageDialog(this, "Credenciales inválidas");
        }
    }
    
    private boolean isValid(String username, String password) {
        // Lógica de autenticación aquí
        // Devuelve true si las credenciales son válidas, false de lo contrario
        return username.equals("david") && password.equals("1234");
    }
    
    public static void main(String[] args) {
        new Proyecto();
    }
}

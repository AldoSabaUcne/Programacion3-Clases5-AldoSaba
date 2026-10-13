import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.stage.Stage;


public class EvaluadorNotas extends Application {

    private TextField txtNombre;
    private TextField txtNota;
    private Label lblResultado;

@Override
public void start(Stage stage) {
    Label lblTitulo = new Label("Evaluador de Calificaciones");
        lblTitulo.setStyle("-fx-font-size: 22px; -fx-font-weigth: bold; -fx- text-fill: #2c3e50;");

        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre del estudiante");
        txtNota = new TextField();
        txtNombre.setPromptText("Calificacion (0-100)");

        Button btnEvaluar = new Button("Evaluar");
        btnEvaluar.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"
        + "-fx-font-weigth: bold; -fx-Padding: 8 20 8 20;");
        btnEvaluar.setOnAction(e -> evaluar());

        lblResultado = new Label();

        lblResultado.setMaxWidth(Double.MAX_VALUE);

        lblResultado.setAlignment(Pos.CENTER);
            lblResultado.setPadding(new Insets(12));

        VBox root = new VBox(12, lblTitulo, txtNombre, txtNota, btnEvaluar, lblResultado);
            root.setPadding(new Insets(20));
            root.setAlignment(Pos.CENTER);

            stage.setTitle("Evaluador de notas");
            stage.setScene(new Scene(root, 360, 320));
            stage.show();
            }

            private void evaluar() {
                String nombre = txtNombre.getText().trim();
                if (nombre.isEmpty()) {
                    nombre = "Estudiante";
                }

                try {
                    int nota = Integer.parseInt(txtNota.getText().trim());

                    if (nota < 0 || nota > 100) {
                        mostrarInvalida();
                    } else if (nota >= 70) {
                        mostrar(nombre + ": Aprobado", "#2ecc71");
                    } else if (nota >= 60) {
                        mostrar(nombre + ": Completivo","#f1c40f");
                    } else {
                        mostrar(nombre + ": Reprobado", "#e74c3c");
                }
            } catch (NumberFormatException ex) {
                mostrarInvalida();
            }
        }

        private void mostrar(String mensaje, String color) {
            lblResultado.setText(mensaje);
            lblResultado.setStyle("-fx-background-color: " + color + "; " + "-fx-font-size: 16px; -fx-font-weigth: bold; -fx-text-fill: black:");
        }

        private void mostrarInvalida() {
            mostrar("Nota Invalida", "#bdc3c7");
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
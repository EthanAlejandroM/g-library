package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interfaz extends Application {

    private BorderPane contenedorPrincipal;

    @Override
    public void start(Stage escenario) {

        // Contenedor principal de toda la aplicación
        contenedorPrincipal = new BorderPane();

        // Título
        Label titulo = new Label("📚 G-LIBRARY");
        titulo.getStyleClass().add("titulo");

        // Subtítulo
        Label subtitulo = new Label("Sistema de gestión de biblioteca");
        subtitulo.getStyleClass().add("subtitulo");

        // Botones
        Button botonEstudiante = new Button("Registrar estudiante");
        Button botonProfesor = new Button("Registrar profesor");
        Button botonUsuarios = new Button("Mostrar usuarios");

        // Aplicamos el estilo CSS
        botonEstudiante.getStyleClass().add("boton");
        botonProfesor.getStyleClass().add("boton");
        botonUsuarios.getStyleClass().add("boton");

        // Tamaño de los botones
        botonEstudiante.setPrefWidth(280);
        botonProfesor.setPrefWidth(280);
        botonUsuarios.setPrefWidth(280);

        // Contenedor del menú
        VBox menu = new VBox(15);

        menu.getChildren().addAll(
                titulo,
                subtitulo,
                botonEstudiante,
                botonProfesor,
                botonUsuarios);

        // Centramos el menú
        menu.setAlignment(javafx.geometry.Pos.CENTER);

        contenedorPrincipal.setCenter(menu);

        // =========================
        // ACCIONES DE LOS BOTONES
        // =========================

        botonEstudiante.setOnAction(e -> mostrarPanelEstudiante());

        botonProfesor.setOnAction(e -> mostrarPanelProfesor());

        botonUsuarios.setOnAction(e -> mostrarPanelUsuarios());

        // Escena
        Scene escena = new Scene(contenedorPrincipal, 500, 400);

        // CSS
        escena.getStylesheets().add(
                getClass().getResource("/UI/estilos.css").toExternalForm());

        escenario.setTitle("G-Library");
        escenario.setScene(escena);
        escenario.show();
    }

    // MÉTODOS DE NAVEGACIÓN

    private void mostrarPanelEstudiante() {

        PanelEstudiante panel = new PanelEstudiante(
                () -> mostrarMenu());
        contenedorPrincipal.setCenter(panel);
    }

    private void mostrarPanelProfesor() {

        PanelProfesor panel = new PanelProfesor(
                () -> mostrarMenu());
        contenedorPrincipal.setCenter(panel);
    }

    private void mostrarPanelUsuarios() {

        PanelUsuarios panel = new PanelUsuarios(() -> mostrarMenu());

        contenedorPrincipal.setCenter(panel);
    }

    // VOLVER AL MENÚ PRINCIPAL

    private void mostrarMenu() {

        Label titulo = new Label("📚 G-LIBRARY");
        titulo.getStyleClass().add("titulo");

        Label subtitulo = new Label("Sistema de gestión de biblioteca");
        subtitulo.getStyleClass().add("subtitulo");

        Button botonEstudiante = new Button("Registrar estudiante");
        Button botonProfesor = new Button("Registrar profesor");
        Button botonUsuarios = new Button("Mostrar usuarios");

        botonEstudiante.getStyleClass().add("boton");
        botonProfesor.getStyleClass().add("boton");
        botonUsuarios.getStyleClass().add("boton");

        botonEstudiante.setPrefWidth(280);
        botonProfesor.setPrefWidth(280);
        botonUsuarios.setPrefWidth(280);

        botonEstudiante.setOnAction(e -> mostrarPanelEstudiante());
        botonProfesor.setOnAction(e -> mostrarPanelProfesor());
        botonUsuarios.setOnAction(e -> mostrarPanelUsuarios());

        VBox menu = new VBox(15);
        menu.setAlignment(javafx.geometry.Pos.CENTER);

        menu.getChildren().addAll(
                titulo,
                subtitulo,
                botonEstudiante,
                botonProfesor,
                botonUsuarios);

        contenedorPrincipal.setCenter(menu);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

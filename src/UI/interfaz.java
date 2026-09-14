// package UI;

// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// public class Interfaz extends Application {

//     private BorderPane contenedorPrincipal;

//     @Override
//     public void start(Stage escenario) {

//         // Contenedor principal de toda la aplicación
//         contenedorPrincipal = new BorderPane();

//         // Título
//         Label titulo = new Label("📚 G-LIBRARY");
//         titulo.getStyleClass().add("titulo");

//         // Subtítulo
//         Label subtitulo = new Label("Sistema de gestión de biblioteca");
//         subtitulo.getStyleClass().add("subtitulo");

//         // Botones
//         Button botonEstudiante = new Button("Registrar estudiante");
//         Button botonProfesor = new Button("Registrar profesor");
//         Button botonUsuarios = new Button("Mostrar usuarios");

//         // Aplicamos el estilo CSS
//         botonEstudiante.getStyleClass().add("boton");
//         botonProfesor.getStyleClass().add("boton");
//         botonUsuarios.getStyleClass().add("boton");

//         // Tamaño de los botones
//         botonEstudiante.setPrefWidth(280);
//         botonProfesor.setPrefWidth(280);
//         botonUsuarios.setPrefWidth(280);

//         // Contenedor del menú
//         VBox menu = new VBox(15);

//         menu.getChildren().addAll(
//                 titulo,
//                 subtitulo,
//                 botonEstudiante,
//                 botonProfesor,
//                 botonUsuarios);

//         // Centramos el menú
//         menu.setAlignment(javafx.geometry.Pos.CENTER);

//         contenedorPrincipal.setCenter(menu);

//         // =========================
//         // ACCIONES DE LOS BOTONES
//         // =========================

//         botonEstudiante.setOnAction(e -> mostrarPanelEstudiante());

//         botonProfesor.setOnAction(e -> mostrarPanelProfesor());

//         botonUsuarios.setOnAction(e -> mostrarPanelUsuarios());

//         // Escena
//         Scene escena = new Scene(contenedorPrincipal, 500, 400);

//         // CSS
//         escena.getStylesheets().add(
//                 getClass().getResource("/UI/estilos.css").toExternalForm());

//         escenario.setTitle("G-Library");
//         escenario.setScene(escena);
//         escenario.show();
//     }

//     // MÉTODOS DE NAVEGACIÓN

//     private void mostrarPanelEstudiante() {

//         PanelEstudiante panel = new PanelEstudiante(
//                 () -> mostrarMenu());
//         contenedorPrincipal.setCenter(panel);
//     }

//     private void mostrarPanelProfesor() {

//         PanelProfesor panel = new PanelProfesor(
//                 () -> mostrarMenu());
//         contenedorPrincipal.setCenter(panel);
//     }

//     private void mostrarPanelUsuarios() {

//         PanelUsuarios panel = new PanelUsuarios(() -> mostrarMenu());

//         contenedorPrincipal.setCenter(panel);
//     }

//     // VOLVER AL MENÚ PRINCIPAL

//     private void mostrarMenu() {

//         Label titulo = new Label("📚 G-LIBRARY");
//         titulo.getStyleClass().add("titulo");

//         Label subtitulo = new Label("Sistema de gestión de biblioteca");
//         subtitulo.getStyleClass().add("subtitulo");

//         Button botonEstudiante = new Button("Registrar estudiante");
//         Button botonProfesor = new Button("Registrar profesor");
//         Button botonUsuarios = new Button("Mostrar usuarios");

//         botonEstudiante.getStyleClass().add("boton");
//         botonProfesor.getStyleClass().add("boton");
//         botonUsuarios.getStyleClass().add("boton");

//         botonEstudiante.setPrefWidth(280);
//         botonProfesor.setPrefWidth(280);
//         botonUsuarios.setPrefWidth(280);

//         botonEstudiante.setOnAction(e -> mostrarPanelEstudiante());
//         botonProfesor.setOnAction(e -> mostrarPanelProfesor());
//         botonUsuarios.setOnAction(e -> mostrarPanelUsuarios());

//         VBox menu = new VBox(15);
//         menu.setAlignment(javafx.geometry.Pos.CENTER);

//         menu.getChildren().addAll(
//                 titulo,
//                 subtitulo,
//                 botonEstudiante,
//                 botonProfesor,
//                 botonUsuarios);

//         contenedorPrincipal.setCenter(menu);
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }--!

package UI;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Interfaz extends Application {

    private BorderPane contenedorPrincipal;
    private Stage escenario;

    @Override
    public void start(Stage escenario) {

        this.escenario = escenario;

        // Contenedor principal de toda la aplicación
        contenedorPrincipal = new BorderPane();

        mostrarMenu();

        // Escena
        Scene escena = new Scene(contenedorPrincipal, 1000, 680);

        // CSS
        escena.getStylesheets().add(
                getClass().getResource("/UI/estilos.css").toExternalForm());

        escenario.setTitle("G-Library");
        escenario.setScene(escena);

        // La aplicación inicia maximizada y conserva este estado durante toda
        // la navegación. Las pantallas internas no vuelven a cambiar el tamaño.
        escenario.setMaximized(true);
        escenario.show();
    }

    // =========================
    // MENÚ PRINCIPAL
    // =========================

    private void mostrarMenu() {

        VBox tarjetaMenu = new VBox();
        tarjetaMenu.getStyleClass().add("card");
        tarjetaMenu.setMaxWidth(420);
        tarjetaMenu.setMaxHeight(420);

        // Encabezado
        Label icono = new Label("📚");
        icono.getStyleClass().add("icono-header");

        Label titulo = new Label("G-Library");
        titulo.getStyleClass().add("titulo-header");

        Label subtitulo = new Label("Sistema de gestión de biblioteca");
        subtitulo.getStyleClass().add("subtitulo-header");

        VBox textosHeader = new VBox(2, titulo, subtitulo);

        HBox header = new HBox(14, icono, textosHeader);
        header.getStyleClass().add("header-bar");
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(22, 30, 22, 26));

        // Botones
        Button botonEstudiante = new Button("Registrar estudiante");
        Button botonProfesor = new Button("Registrar profesor");
        Button botonUsuarios = new Button("Mostrar usuarios");

        for (Button boton : new Button[] { botonEstudiante, botonProfesor, botonUsuarios }) {
            boton.getStyleClass().add("boton-menu");
            boton.setMaxWidth(Double.MAX_VALUE);
        }

        botonEstudiante.setOnAction(e -> mostrarPanelEstudiante());
        botonProfesor.setOnAction(e -> mostrarPanelProfesor());
        botonUsuarios.setOnAction(e -> mostrarPanelUsuarios());

        VBox opciones = new VBox(16, botonEstudiante, botonProfesor, botonUsuarios);
        opciones.setAlignment(Pos.CENTER);
        opciones.setPadding(new Insets(34, 50, 34, 50));

        tarjetaMenu.getChildren().addAll(header, opciones);

        contenedorPrincipal.setPadding(new Insets(40));
        BorderPane.setAlignment(tarjetaMenu, Pos.CENTER);
        cambiarPanel(tarjetaMenu);
    }

    // =========================
    // NAVEGACIÓN
    // =========================

    private void mostrarPanelEstudiante() {

        PanelEstudiante panel = new PanelEstudiante(
                this::mostrarMenu,
                this::mostrarPanelProfesor);

        contenedorPrincipal.setPadding(new Insets(40));
        BorderPane.setAlignment(panel, Pos.CENTER);
        cambiarPanel(panel);
    }

    private void mostrarPanelProfesor() {

        PanelProfesor panel = new PanelProfesor(
                this::mostrarMenu,
                this::mostrarPanelEstudiante);

        contenedorPrincipal.setPadding(new Insets(40));
        BorderPane.setAlignment(panel, Pos.CENTER);
        cambiarPanel(panel);
    }

    private void mostrarPanelUsuarios() {

        PanelUsuarios panel = new PanelUsuarios(this::mostrarMenu);

        // Esta pantalla ocupa toda la ventana y sin margen.
        contenedorPrincipal.setPadding(Insets.EMPTY);
        BorderPane.setAlignment(panel, Pos.CENTER);
        cambiarPanel(panel);
    }

    // =========================
    // TRANSICIÓN ANIMADA ENTRE PANELES
    // =========================

    /**
     * Reemplaza el contenido central con una animación: el panel anterior se
     * desvanece y el nuevo aparece con un ligero desplazamiento hacia arriba.
     */
    private void cambiarPanel(Node nuevoPanel) {

        Node actual = contenedorPrincipal.getCenter();

        if (actual == null) {
            contenedorPrincipal.setCenter(nuevoPanel);
            animarEntrada(nuevoPanel);
            return;
        }

        FadeTransition salida = new FadeTransition(Duration.millis(140), actual);
        salida.setFromValue(1);
        salida.setToValue(0);
        salida.setOnFinished(evento -> {
            contenedorPrincipal.setCenter(nuevoPanel);
            animarEntrada(nuevoPanel);
        });
        salida.play();
    }

    private void animarEntrada(Node nodo) {

        nodo.setOpacity(0);
        nodo.setTranslateY(16);

        FadeTransition aparecer = new FadeTransition(Duration.millis(240), nodo);
        aparecer.setFromValue(0);
        aparecer.setToValue(1);

        TranslateTransition subir = new TranslateTransition(Duration.millis(240), nodo);
        subir.setFromY(16);
        subir.setToY(0);

        new ParallelTransition(aparecer, subir).play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

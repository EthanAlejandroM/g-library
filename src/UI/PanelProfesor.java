// package UI;

// import javafx.geometry.Pos;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Button;
// import javafx.scene.control.ComboBox;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.VBox;
// import Business.GestionUsuario;
// import Service.ProfesorDAO;

// public class PanelProfesor extends VBox {

//     public PanelProfesor(Runnable volverAlMenu) {

//         Label titulo = new Label("👨‍🏫 Registrar profesor");
//         titulo.getStyleClass().add("titulo");

//         TextField nombre = new TextField();
//         nombre.setPromptText("Nombre completo");
//         nombre.setPrefWidth(280);

//         TextField cedula = new TextField();
//         cedula.setPromptText("Documento");
//         cedula.setPrefWidth(280);

//         TextField telefono = new TextField();
//         telefono.setPromptText("Teléfono");
//         telefono.setPrefWidth(280);

//         TextField correo = new TextField();
//         correo.setPromptText("ej: pepito@profesor.uniajc.edu.co");
//         correo.setPrefWidth(280);

//         TextField codigo = new TextField();
//         codigo.setPromptText("Código del profesor");
//         codigo.setPrefWidth(280);

//         ComboBox<String> departamento = new ComboBox<>();

//         departamento.getItems().addAll(
//                 "Ingeniería de Sistemas",
//                 "Ingeniería Electrónica",
//                 "Administración",
//                 "Contaduría",
//                 "Humanidades",
//                 "Matemáticas");

//         departamento.setPromptText("Seleccione el departamento");
//         departamento.setPrefWidth(280);

//         Button registrar = new Button("Registrar profesor");
//         registrar.getStyleClass().add("boton");
//         registrar.setPrefWidth(280);

//         registrar.setOnAction(e -> {

//             if (nombre.getText().trim().isEmpty()
//                     || cedula.getText().trim().isEmpty()
//                     || telefono.getText().trim().isEmpty()
//                     || correo.getText().trim().isEmpty()
//                     || codigo.getText().trim().isEmpty()
//                     || departamento.getValue() == null) {

//                 Alert alerta = new Alert(Alert.AlertType.WARNING);
//                 alerta.setTitle("Datos incompletos");
//                 alerta.setHeaderText("Faltan datos por completar");
//                 alerta.setContentText("Debe completar todos los campos.");
//                 alerta.showAndWait();

//                 return;
//             }

//             ProfesorDAO profesor = new ProfesorDAO(
//                     0,
//                     nombre.getText(),
//                     correo.getText(),
//                     cedula.getText(),
//                     telefono.getText(),
//                     codigo.getText(),
//                     departamento.getValue());

//             GestionUsuario gestion = new GestionUsuario();
//             String mensajeError = gestion.validarDatosBO(profesor);

//             if (mensajeError != null) {

//                 Alert alerta = new Alert(Alert.AlertType.ERROR);
//                 alerta.setTitle("No se puede registrar");
//                 alerta.setHeaderText("Los datos no son válidos");
//                 alerta.setContentText(mensajeError);
//                 alerta.showAndWait();

//                 return;
//             }

//             // Validamos el teléfono
//             if (!telefono.getText().matches("\\d{10}")) {

//                 Alert alerta = new Alert(Alert.AlertType.ERROR);
//                 alerta.setTitle("Teléfono no válido");
//                 alerta.setHeaderText("El número de teléfono no es válido");
//                 alerta.setContentText(
//                         "El teléfono debe contener exactamente 10 dígitos.");
//                 alerta.showAndWait();

//                 return;
//             }

//             if (!profesor.validarCorreo()) {

//                 Alert alerta = new Alert(Alert.AlertType.ERROR);
//                 alerta.setTitle("Correo no válido");
//                 alerta.setHeaderText("El correo institucional no es válido");
//                 alerta.setContentText("Vuelve a intentarlo");
//                 alerta.showAndWait();

//                 return;
//             }

//             if (profesor.registrarProfesor()) {

//                 Alert alerta = new Alert(Alert.AlertType.INFORMATION);
//                 alerta.setTitle("Registro exitoso");
//                 alerta.setHeaderText("¡Profesor registrado!");
//                 alerta.setContentText(
//                         "El profesor fue registrado correctamente en la base de datos.");
//                 alerta.showAndWait();

//             } else {

//                 Alert alerta = new Alert(Alert.AlertType.ERROR);
//                 alerta.setTitle("Error en el registro");
//                 alerta.setHeaderText("No se pudo registrar el profesor");
//                 alerta.setContentText(
//                         "Ocurrió un error al guardar los datos en la base de datos.");
//                 alerta.showAndWait();
//             }
//         });

//         // boton volver
//         Button volver = new Button("← Volver");
//         volver.getStyleClass().add("boton");
//         volver.setPrefWidth(280);

//         volver.setOnAction(e -> volverAlMenu.run());

//         setSpacing(12);
//         setAlignment(Pos.CENTER);
//         setFillWidth(false);

//         getChildren().addAll(
//                 titulo,
//                 nombre,
//                 cedula,
//                 telefono,
//                 correo,
//                 codigo,
//                 departamento,
//                 registrar,
//                 volver);
//     }
// }

package UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import Business.GestionUsuario;
import Service.ProfesorDAO;

public class PanelProfesor extends BorderPane {

    public PanelProfesor(Runnable volverAlMenu, Runnable irARegistroEstudiante) {

        getStyleClass().add("card");
        setMaxWidth(760);
        setMaxHeight(560);

        // ===================== ENCABEZADO =====================

        Button botonVolver = new Button("‹");
        botonVolver.getStyleClass().add("boton-volver");
        botonVolver.setOnAction(e -> volverAlMenu.run());

        Label icono = new Label("👨‍🏫");
        icono.getStyleClass().add("icono-header");

        Label titulo = new Label("Registro");
        titulo.getStyleClass().add("titulo-header");

        Label subtitulo = new Label("Docente");
        subtitulo.getStyleClass().add("subtitulo-header");

        VBox textosHeader = new VBox(2, titulo, subtitulo);

        HBox header = new HBox(14, botonVolver, icono, textosHeader);
        header.getStyleClass().add("header-bar");
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(20, 30, 20, 20));

        setTop(header);

        // ===================== CAMPOS =====================

        TextField nombre = new TextField();
        nombre.setPromptText("Nombre completo");

        TextField cedula = new TextField();
        cedula.setPromptText("Documento");

        TextField codigo = new TextField();
        codigo.setPromptText("Código del profesor");

        TextField telefono = new TextField();
        telefono.setPromptText("Teléfono");

        TextField correo = new TextField();
        correo.setPromptText("ej: pepito@profesor.uniajc.edu.co");

        ComboBox<String> departamento = new ComboBox<>();
        departamento.getItems().addAll(
                "Ingeniería de Sistemas",
                "Ingeniería Electrónica",
                "Administración",
                "Contaduría",
                "Humanidades",
                "Matemáticas");
        departamento.setPromptText("Seleccione el departamento");

        for (TextField campo : new TextField[] { nombre, cedula, codigo, telefono, correo }) {
            campo.getStyleClass().add("campo-texto");
        }
        departamento.getStyleClass().add("campo-combo");

        GridPane campos = new GridPane();
        campos.getStyleClass().add("cuerpo-formulario");
        campos.setHgap(36);
        campos.setVgap(16);
        campos.setPadding(new Insets(28, 36, 10, 36));

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        col1.setHgrow(Priority.ALWAYS);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        col2.setHgrow(Priority.ALWAYS);
        campos.getColumnConstraints().addAll(col1, col2);

        campos.add(campoConEtiqueta("Nombre completo:", nombre), 0, 0);
        campos.add(campoConEtiqueta("Teléfono:", telefono), 1, 0);
        campos.add(campoConEtiqueta("Documento:", cedula), 0, 1);
        campos.add(campoConEtiqueta("Correo institucional:", correo), 1, 1);
        campos.add(campoConEtiqueta("Código profesor:", codigo), 0, 2);
        campos.add(campoConEtiqueta("Departamento:", departamento), 1, 2);

        setCenter(campos);

        // ===================== PIE =====================

        Hyperlink cambiarAEstudiante = new Hyperlink("¿El usuario no es docente? Registro estudiante");
        cambiarAEstudiante.getStyleClass().add("enlace-pie");
        cambiarAEstudiante.setOnAction(e -> irARegistroEstudiante.run());

        Button registrar = new Button("Registrar");
        registrar.getStyleClass().add("boton-primario");

        registrar.setOnAction(e -> {

            if (nombre.getText().trim().isEmpty()
                    || cedula.getText().trim().isEmpty()
                    || telefono.getText().trim().isEmpty()
                    || correo.getText().trim().isEmpty()
                    || codigo.getText().trim().isEmpty()
                    || departamento.getValue() == null) {

                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Datos incompletos");
                alerta.setHeaderText("Faltan datos por completar");
                alerta.setContentText("Debe completar todos los campos.");
                alerta.showAndWait();

                return;
            }

            ProfesorDAO profesor = new ProfesorDAO(
                    0,
                    nombre.getText(),
                    correo.getText(),
                    cedula.getText(),
                    telefono.getText(),
                    codigo.getText(),
                    departamento.getValue());

            GestionUsuario gestion = new GestionUsuario();
            String mensajeError = gestion.validarDatosBO(profesor);

            if (mensajeError != null) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("No se puede registrar");
                alerta.setHeaderText("Los datos no son válidos");
                alerta.setContentText(mensajeError);
                alerta.showAndWait();

                return;
            }

            // Validamos el teléfono
            if (!telefono.getText().matches("\\d{10}")) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Teléfono no válido");
                alerta.setHeaderText("El número de teléfono no es válido");
                alerta.setContentText(
                        "El teléfono debe contener exactamente 10 dígitos.");
                alerta.showAndWait();

                return;
            }

            if (!profesor.validarCorreo()) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Correo no válido");
                alerta.setHeaderText("El correo institucional no es válido");
                alerta.setContentText("Vuelve a intentarlo");
                alerta.showAndWait();

                return;
            }

            if (profesor.registrarProfesor()) {

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Registro exitoso");
                alerta.setHeaderText("¡Profesor registrado!");
                alerta.setContentText(
                        "El profesor fue registrado correctamente en la base de datos.");
                alerta.showAndWait();

            } else {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error en el registro");
                alerta.setHeaderText("No se pudo registrar el profesor");
                alerta.setContentText(
                        "Ocurrió un error al guardar los datos en la base de datos.");
                alerta.showAndWait();
            }
        });

        Region espaciador = new Region();
        HBox.setHgrow(espaciador, Priority.ALWAYS);

        HBox pie = new HBox(20, cambiarAEstudiante, espaciador, registrar);
        pie.getStyleClass().add("pie-formulario");
        pie.setAlignment(Pos.CENTER_LEFT);
        pie.setPadding(new Insets(6, 36, 26, 36));

        setBottom(pie);
    }

    /** Envuelve un control en una etiqueta + campo, estilo formulario del mockup. */
    private VBox campoConEtiqueta(String texto, Control control) {
        Label etiqueta = new Label(texto);
        etiqueta.getStyleClass().add("etiqueta-campo");
        control.setMaxWidth(Double.MAX_VALUE);
        return new VBox(6, etiqueta, control);
    }
}
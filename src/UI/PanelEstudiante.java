package UI;

import javafx.scene.control.Alert;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import Service.EstudianteDAO;
import Business.GestionUsuario;

public class PanelEstudiante extends VBox {

    public PanelEstudiante(Runnable volverAlMenu) {

        // Título
        Label titulo = new Label("👩‍🎓 Registrar estudiante");
        titulo.getStyleClass().add("titulo");

        // Campos
        TextField nombre = new TextField();
        nombre.setPromptText("Nombre completo");
        nombre.setPrefWidth(280);

        TextField cedula = new TextField();
        cedula.setPromptText("Documento");
        cedula.setPrefWidth(280);

        TextField telefono = new TextField();
        telefono.setPromptText("Teléfono");
        telefono.setPrefWidth(280);

        TextField correo = new TextField();
        correo.setPromptText("ej: pepito@estudiante.uniajc.edu.co");
        correo.setPrefWidth(280);

        TextField codigo = new TextField();
        codigo.setPromptText("Código del estudiante");
        codigo.setPrefWidth(280);

        // Programas
        ComboBox<String> programa = new ComboBox<>();

        programa.getItems().addAll(
                "Ingeniería de Sistemas",
                "Administración de Empresas",
                "Contaduría Pública",
                "Ingeniería Electrónica",
                "Tecnología en Sistemas",
                "Tecnología en Electrónica");

        programa.setPromptText("Seleccione el programa");
        programa.setPrefWidth(280);

        // Botón registrar
        Button registrar = new Button("Registrar estudiante");
        registrar.getStyleClass().add("boton");
        registrar.setPrefWidth(280);

        registrar.setOnAction(e -> {

            // Verificamos que todos los campos estén completos
            if (nombre.getText().trim().isEmpty()
                    || cedula.getText().trim().isEmpty()
                    || telefono.getText().trim().isEmpty()
                    || correo.getText().trim().isEmpty()
                    || codigo.getText().trim().isEmpty()
                    || programa.getValue() == null) {

                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Datos incompletos");
                alerta.setHeaderText("Faltan datos por completar");
                alerta.setContentText("Debe completar todos los campos.");
                alerta.showAndWait();

                return;
            }

            // Creamos el estudiante con los datos del formulario
            EstudianteDAO estudiante = new EstudianteDAO(
                    0,
                    nombre.getText(),
                    correo.getText(),
                    cedula.getText(),
                    telefono.getText(),
                    codigo.getText(),
                    programa.getValue());

            GestionUsuario gestion = new GestionUsuario();
            String mensajeError = gestion.validarDatosBO(estudiante);

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

            // Validamos el correo institucional
            if (!estudiante.validarCorreo()) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Correo no válido");
                alerta.setHeaderText("El correo institucional no es válido");
                alerta.setContentText("Vuelve a intentarlo");
                alerta.showAndWait();

                return;
            }

            // Si todo está correcto
            if (estudiante.registrarEstudiante()) {

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Registro exitoso");
                alerta.setHeaderText("¡Estudiante registrado!");
                alerta.setContentText(
                        "El estudiante fue registrado correctamente en la base de datos.");
                alerta.showAndWait();

            } else {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error en el registro");
                alerta.setHeaderText("No se pudo registrar el estudiante");
                alerta.setContentText(
                        "Ocurrió un error al guardar los datos en la base de datos.");
                alerta.showAndWait();
            }
        });

        // Botón volver
        Button volver = new Button("← Volver");
        volver.getStyleClass().add("boton");
        volver.setPrefWidth(280);

        // Acción del botón volver
        volver.setOnAction(e -> volverAlMenu.run());

        // Espaciado y alineación
        setSpacing(12);
        setAlignment(Pos.CENTER);
        setFillWidth(false);

        // Agregamos todos los elementos
        getChildren().addAll(
                titulo,
                nombre,
                cedula,
                telefono,
                correo,
                codigo,
                programa,
                registrar,
                volver);
    }
}

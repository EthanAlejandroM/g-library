package UI;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import Business.GestionUsuario;
import Service.ProfesorDAO;

public class PanelProfesor extends VBox {

    public PanelProfesor(Runnable volverAlMenu) {

        Label titulo = new Label("👨‍🏫 Registrar profesor");
        titulo.getStyleClass().add("titulo");

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
        correo.setPromptText("ej: pepito@profesor.uniajc.edu.co");
        correo.setPrefWidth(280);

        TextField codigo = new TextField();
        codigo.setPromptText("Código del profesor");
        codigo.setPrefWidth(280);

        ComboBox<String> departamento = new ComboBox<>();

        departamento.getItems().addAll(
                "Ingeniería de Sistemas",
                "Ingeniería Electrónica",
                "Administración",
                "Contaduría",
                "Humanidades",
                "Matemáticas");

        departamento.setPromptText("Seleccione el departamento");
        departamento.setPrefWidth(280);

        Button registrar = new Button("Registrar profesor");
        registrar.getStyleClass().add("boton");
        registrar.setPrefWidth(280);

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

        // boton volver
        Button volver = new Button("← Volver");
        volver.getStyleClass().add("boton");
        volver.setPrefWidth(280);

        volver.setOnAction(e -> volverAlMenu.run());

        setSpacing(12);
        setAlignment(Pos.CENTER);
        setFillWidth(false);

        getChildren().addAll(
                titulo,
                nombre,
                cedula,
                telefono,
                correo,
                codigo,
                departamento,
                registrar,
                volver);
    }
}
package UI;

import Service.UsuarioConsultaDAO;
import Service.UsuarioVista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class PanelUsuarios extends BorderPane {

        private TableView<UsuarioVista> tablaUsuarios;

        public PanelUsuarios(Runnable volverAlMenu) {

                // Título
                Label titulo = new Label("👥 Usuarios registrados");
                titulo.getStyleClass().add("titulo");

                // Tabla
                tablaUsuarios = new TableView<>();

                TableColumn<UsuarioVista, Integer> columnaId = new TableColumn<>("ID");
                TableColumn<UsuarioVista, String> columnaNombre = new TableColumn<>("Nombre");
                TableColumn<UsuarioVista, String> columnaCorreo = new TableColumn<>("Correo");
                TableColumn<UsuarioVista, String> columnaCedula = new TableColumn<>("Documento");
                TableColumn<UsuarioVista, String> columnaTelefono = new TableColumn<>("Teléfono");
                TableColumn<UsuarioVista, String> columnaTipo = new TableColumn<>("Tipo");
                TableColumn<UsuarioVista, String> columnaCodigo = new TableColumn<>("Código");
                TableColumn<UsuarioVista, String> columnaDetalle = new TableColumn<>("Programa / Departamento");

                columnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
                columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
                columnaCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
                columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
                columnaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
                columnaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
                columnaDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));

                // Agregar comlumnas a la tabla

                tablaUsuarios.getColumns().addAll(

                                columnaId,
                                columnaNombre,
                                columnaCorreo,
                                columnaCedula,
                                columnaTelefono,
                                columnaTipo,
                                columnaCodigo,
                                columnaDetalle);

                tablaUsuarios.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

                // Lista para guardar los usuarios consultados
                UsuarioConsultaDAO consulta = new UsuarioConsultaDAO();

                ObservableList<UsuarioVista> usuarios = FXCollections.observableArrayList(
                                consulta.obtenerUsuarios());

                tablaUsuarios.setItems(usuarios);

                // Botón volver
                Button btnVolver = new Button("← Volver al menú");
                btnVolver.getStyleClass().add("boton");
                btnVolver.setPrefWidth(200);

                btnVolver.setOnAction(e -> volverAlMenu.run());

                // Contenedor
                VBox contenido = new VBox(20);
                contenido.setAlignment(Pos.CENTER);
                contenido.setPadding(new Insets(30));

                contenido.getChildren().addAll(
                                titulo,
                                tablaUsuarios,
                                btnVolver);

                setCenter(contenido);
        }
}

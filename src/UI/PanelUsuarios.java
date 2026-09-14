// package UI;

// import Service.UsuarioConsultaDAO;
// import Service.UsuarioVista;

// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TableView;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.VBox;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.cell.PropertyValueFactory;

// public class PanelUsuarios extends BorderPane {

//         private TableView<UsuarioVista> tablaUsuarios;

//         public PanelUsuarios(Runnable volverAlMenu) {

//                 // Título
//                 Label titulo = new Label("👥 Usuarios registrados");
//                 titulo.getStyleClass().add("titulo");

//                 // Tabla
//                 tablaUsuarios = new TableView<>();

//                 TableColumn<UsuarioVista, Integer> columnaId = new TableColumn<>("ID");
//                 TableColumn<UsuarioVista, String> columnaNombre = new TableColumn<>("Nombre");
//                 TableColumn<UsuarioVista, String> columnaCorreo = new TableColumn<>("Correo");
//                 TableColumn<UsuarioVista, String> columnaCedula = new TableColumn<>("Documento");
//                 TableColumn<UsuarioVista, String> columnaTelefono = new TableColumn<>("Teléfono");
//                 TableColumn<UsuarioVista, String> columnaTipo = new TableColumn<>("Tipo");
//                 TableColumn<UsuarioVista, String> columnaCodigo = new TableColumn<>("Código");
//                 TableColumn<UsuarioVista, String> columnaDetalle = new TableColumn<>("Programa / Departamento");

//                 columnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
//                 columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
//                 columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
//                 columnaCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
//                 columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
//                 columnaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
//                 columnaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
//                 columnaDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));

//                 // Agregar comlumnas a la tabla

//                 tablaUsuarios.getColumns().addAll(

//                                 columnaId,
//                                 columnaNombre,
//                                 columnaCorreo,
//                                 columnaCedula,
//                                 columnaTelefono,
//                                 columnaTipo,
//                                 columnaCodigo,
//                                 columnaDetalle);

//                 tablaUsuarios.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

//                 // Lista para guardar los usuarios consultados
//                 UsuarioConsultaDAO consulta = new UsuarioConsultaDAO();

//                 ObservableList<UsuarioVista> usuarios = FXCollections.observableArrayList(
//                                 consulta.obtenerUsuarios());

//                 tablaUsuarios.setItems(usuarios);

//                 // Botón volver
//                 Button btnVolver = new Button("← Volver al menú");
//                 btnVolver.getStyleClass().add("boton");
//                 btnVolver.setPrefWidth(200);

//                 btnVolver.setOnAction(e -> volverAlMenu.run());

//                 // Contenedor
//                 VBox contenido = new VBox(20);
//                 contenido.setAlignment(Pos.CENTER);
//                 contenido.setPadding(new Insets(30));

//                 contenido.getChildren().addAll(
//                                 titulo,
//                                 tablaUsuarios,
//                                 btnVolver);

//                 setCenter(contenido);
//         }
// }

package UI;

import Service.UsuarioConsultaDAO;
import Service.UsuarioVista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PanelUsuarios extends HBox {

        private TableView<UsuarioVista> tablaUsuarios;

        public PanelUsuarios(Runnable volverAlMenu) {

                // ===================== SIDEBAR =====================

                Label iconoLogo = new Label("📚");
                iconoLogo.getStyleClass().add("sidebar-logo-icon");

                Label textoLogo = new Label("G-library");
                textoLogo.getStyleClass().add("sidebar-logo");

                HBox logo = new HBox(8, iconoLogo, textoLogo);
                logo.setAlignment(Pos.CENTER_LEFT);

                Label subtituloSidebar = new Label("Bibliotecarios");
                subtituloSidebar.getStyleClass().add("sidebar-subtitulo");

                VBox encabezadoSidebar = new VBox(6, logo, subtituloSidebar);

                // "Registros" nace del mismo azul del contenedor y, al hacer clic
                // (quedar posicionado en esta sección), se pone y se mantiene amarillo.
                ToggleGroup grupoNavegacion = new ToggleGroup();

                ToggleButton navRegistros = new ToggleButton("Registros");
                navRegistros.getStyleClass().add("sidebar-nav-item");
                navRegistros.setToggleGroup(grupoNavegacion);
                navRegistros.setSelected(true);

                navRegistros.setOnAction(e -> navRegistros.setSelected(true));

                navRegistros.setMaxWidth(Double.MAX_VALUE);
                navRegistros.setPrefWidth(230);

                HBox contenedorRegistros = new HBox(navRegistros);
                contenedorRegistros.getStyleClass().add("sidebar-registros-container");
                contenedorRegistros.setMaxWidth(Double.MAX_VALUE);

                Region espaciadorSidebar = new Region();
                VBox.setVgrow(espaciadorSidebar, Priority.ALWAYS);

                Label navVolver = new Label("← Volver al menú");
                navVolver.getStyleClass().add("sidebar-nav-secundario");
                navVolver.setOnMouseClicked(e -> volverAlMenu.run());

                VBox sidebar = new VBox(28, encabezadoSidebar, contenedorRegistros, espaciadorSidebar, navVolver);
                sidebar.getStyleClass().add("sidebar");
                sidebar.setPrefWidth(230);
                sidebar.setMinWidth(230);

                // ===================== CONTENIDO =====================

                Label titulo = new Label("Usuarios registrados");
                titulo.getStyleClass().add("titulo-usuarios");

                tablaUsuarios = new TableView<>();
                tablaUsuarios.getStyleClass().add("tabla-usuarios");

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

                UsuarioConsultaDAO consulta = new UsuarioConsultaDAO();

                ObservableList<UsuarioVista> usuarios = FXCollections.observableArrayList(
                                consulta.obtenerUsuarios());

                tablaUsuarios.setItems(usuarios);
                VBox.setVgrow(tablaUsuarios, Priority.ALWAYS);

                VBox contenido = new VBox(20, titulo, tablaUsuarios);
                contenido.getStyleClass().add("contenido-usuarios");
                contenido.setAlignment(Pos.TOP_LEFT);
                HBox.setHgrow(contenido, Priority.ALWAYS);

                getChildren().addAll(sidebar, contenido);
        }
}
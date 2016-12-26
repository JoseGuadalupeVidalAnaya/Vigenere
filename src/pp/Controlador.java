package pp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controlador implements Initializable
{
    Vigenere v;
    @FXML
    Button cifrar, decifrar;
    @FXML
    TextField alfa, men, clave, out;

    @FXML
    private void metodoCifrar(ActionEvent e)
    {
        v.setMensaje(men.getText());
        v.setClave(clave.getText());
        out.setText(v.cifrar());
    }

    @FXML
    private void metodoDecifrar(ActionEvent e)
    {
        v.setMensaje(men.getText());
        v.setClave(clave.getText());
        out.setText(v.decifrar());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        v=new Vigenere();
    }
}

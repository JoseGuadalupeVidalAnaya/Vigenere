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
        if (alfa.getText().isEmpty())
            out.setText("Ingrese el alfabeto");
        else if (men.getText().isEmpty())
            out.setText("Ingrese el mensaje a cifrar");
        else if (clave.getText().isEmpty())
            out.setText("Ingrese la clave para cifrar");
        else
        {
            v.setAlfa(alfa.getText());
            v.setMensaje(men.getText());
            v.setClave(clave.getText());
            out.setText(v.cifrar());
        }
    }

    @FXML
    private void metodoDecifrar(ActionEvent e)
    {
        if (alfa.getText().isEmpty())
            out.setText("Ingrese el alfabeto");
        else if (men.getText().isEmpty())
            out.setText("Ingrese el mensaje a decifrar");
        else if (clave.getText().isEmpty())
            out.setText("Ingrese la clave para decifrar");
        else
        {
            v.setAlfa(alfa.getText());
            v.setMensaje(men.getText());
            v.setClave(clave.getText());
            out.setText(v.decifrar());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        v = new Vigenere();
        men.setOnKeyTyped(e ->
        {
            String alfaAux = alfa.getText() + " ";
            if (!alfaAux.contains(e.getCharacter()))
                e.consume();
        });
        alfa.setOnKeyTyped(e ->
        {
            if (e.getCharacter().equals(" "))
                e.consume();
        });
        clave.setOnKeyTyped(e ->
        {
            String alfaAux = alfa.getText();
            if (!alfaAux.contains(e.getCharacter()))
                e.consume();
        });
    }
}

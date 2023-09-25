package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MainSceneController {
    public AnchorPane root;
    public ListView<String> lvMessage;
    public ListView<String> lvMemberList;
    public TextField txtMessage;
    public Button btnSave;

    private ObjectOutputStream oos;

    public void initialize(){
        try {
            Socket remoteSocket=new Socket("localhost",5050);
            OutputStream os=remoteSocket.getOutputStream();
            BufferedOutputStream bos=new BufferedOutputStream(os);
            oos=new ObjectOutputStream(bos);
            System.out.println("Connected");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }
}

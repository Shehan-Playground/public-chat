package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginViewController {
    public TextField txtUserName;
    public Button btnLogin;

    public void txtUserNameOnAction(ActionEvent actionEvent) throws IOException {
        Socket socket = new Socket("192.168.8.1.100", 5050);
        System.out.println("Connected to server");
        if(txtUserName.getText().isEmpty()){
            String userName = txtUserName.getText().strip();
            socket.getOutputStream().write(userName.getBytes());
        }
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5060);
        System.out.println("Server is up and running at 5060");

        if(true){

        }

    }
}

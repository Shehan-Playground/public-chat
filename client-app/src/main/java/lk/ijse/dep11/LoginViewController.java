package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginViewController {
    public TextField txtUserName;
    public Button btnLogin;
    public AnchorPane root;

    public boolean isValid;

    public void txtUserNameOnAction(ActionEvent actionEvent) throws IOException {
        Socket socket = new Socket("192.168.8.1.100", 5050);
        System.out.println("Connected to server");
        if(txtUserName.getText().isEmpty()){
            String userName = txtUserName.getText().strip();
            socket.getOutputStream().write(userName.getBytes());
        }
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(isValid){
            Stage stage = (Stage) root.getScene().getWindow();
            AnchorPane mainRoot = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
            Scene loginScene = new Scene(mainRoot);
            stage.setScene(loginScene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.setTitle("Public Chat");
            stage.show();
        }
    }

    private boolean isValid() throws IOException {
        ServerSocket serverSocket = new ServerSocket(5060);
        System.out.println("Server is up and running at 5060");
        while (true){
            System.out.println("Waiting for an incoming connection");
            Socket localSocket = serverSocket.accept();

            new Thread(()->{
                try{
                    InputStream is = localSocket.getInputStream();
                    byte[] buffer = new byte[1024];
                    int read = -1;
                    while ((read = is.read(buffer)) != -1){
                        System.out.println(new String(buffer, 0, read).equals("OK"));
                        if(new String(buffer, 0, read).equals("OK")){
                            isValid = true;
                        }else {
                            isValid = false;
                        }
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

package UI;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class LoginPage extends HorizontalLayout {
    public LoginPage() {
        VerticalLayout loginLayout = new VerticalLayout();
        VerticalLayout logoLayout = new VerticalLayout();
        VerticalLayout loginForm = new VerticalLayout();

        H1 title = new H1("Login");
        TextField usernameField = new TextField("Username");
        PasswordField passwordField = new PasswordField("Password");
        Button loginButton = new Button("Log in");
        Image expediaLogo = new Image("https://github.com/travelhack/travelhack.github.io/blob/master/static/media/travelhack_logo.7b2b2e41.png?raw=true","dummy image");

        // set up for components
        loginButton.addClickShortcut(Key.ENTER);
        loginButton.getStyle().set("background-color","blue");
        loginButton.getStyle().set("color", "white");

        expediaLogo.setHeight("400px");
        expediaLogo.setWidth("600px");

        // set up layouts
        loginForm.add(usernameField,passwordField,loginButton);
        loginForm.setAlignItems(Alignment.CENTER);

        loginLayout.add(title, loginForm);
        loginLayout.setAlignItems(Alignment.CENTER);
        loginLayout.setHeightFull();

        logoLayout.add(expediaLogo);
        loginLayout.setHeightFull();

        //Stuff to get from database later
        String correctUsername = "Teach";
        String correctPassword = "Stuff";

        // check username and password when triggered
        loginButton.addClickListener(e -> {

            // for now it's only a dialog window after it will also change the route

            Dialog dialog = new Dialog();
            Label label = new Label();
            // set color to red for errors
            label.getStyle().set("color", "red");

            if (usernameField.isEmpty() || passwordField.isEmpty()) {
                label.setText("Some fields were left blank!");
                dialog.add(label);
                dialog.open();
            } else if (usernameField.getValue().equals(correctUsername) && passwordField.getValue().equals(correctPassword)) {
                loginButton.getUI().ifPresent(ui -> {
                        ui.navigate("Home");
                });
            } else {
                label.setText("Username doesn't match the password, try again!");
                dialog.add(label);
                usernameField.clear();
                passwordField.clear();
                dialog.open();
            }
        });

        add(loginLayout, logoLayout);

    }

}

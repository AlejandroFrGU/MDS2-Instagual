package ual.mds2.Instagual;

import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import Instagual.Iniciar_sesion;
import ual.mds2.Instagual.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	Navigator navigator;
	int tipoUser = 0;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	navigator = new Navigator(this, this);
    	tipoUser = 0;
    	
    	getPage().setTitle("Instagual");
    	navigator.addView("IniciarSesion", (Class<? extends View>) Iniciar_sesion.class);
    	
    	
    	
    	
    	
    	
    	/*
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        Button button2 = new Button("Yeeeeey");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        layout.addComponents(name, button);
        layout.addComponents(name,button2);
        
        List<String> people = Arrays.asList(
        	    new String("Nicolaus Copernicus"),
        	    new String("Galileo Galilei"),
        	    new String("Johannes Kepler"));

        	// Create a grid bound to the list
        	Grid<String> grid = new Grid<>();
        	grid.setItems(people);

        	layout.addComponent(grid);
        	
        setContent(layout);
        */
        
    }

    
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    	
    }
}

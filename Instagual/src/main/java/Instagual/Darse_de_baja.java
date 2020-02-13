package Instagual;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import instagualbdorm.BD_Principal;
import ual.mds2.Instagual.Darse_de_baja_ventana;
import ual.mds2.app.MyUI;

public class Darse_de_baja extends Darse_de_baja_ventana{
	//private Button _aceptarB;
	public Configuracion _configuracion;
	public Window wi;
	iUsuario_registrado iRegistrado = new BD_Principal();
	
	public Darse_de_baja() {
		wi = new Window("Darse de baja");
		wi.setHeight(300,Unit.PIXELS);
		wi.setWidth(300,Unit.PIXELS);
		buttonYes.addClickListener(event->DarDeBaja());
		buttonNo.addClickListener(event->wi.close());
		wi.setContent(verticalLayoutDarseBaja);
		wi.center();
		wi.setModal(true);
	}
	
	public void DarDeBaja() {
		iRegistrado.DarseDe_Baja(((MyUI)UI.getCurrent()).getUsuario().getORMID());
		((MyUI)UI.getCurrent()).reset();
		((MyUI)UI.getCurrent()).getNavigator1().navigateTo("IniciarSesion");
		wi.close();
		Notification.show("Cuenta desactivada.", Notification.Type.WARNING_MESSAGE);
	}
	
	public Window getWDarseBaja() {
		return wi;
	}
}
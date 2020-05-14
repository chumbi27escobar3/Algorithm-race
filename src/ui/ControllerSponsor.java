package ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.MainSponsor;

public class ControllerSponsor {

	private MainSponsor mainSpon;

	@FXML
	private TextField text1;

	@FXML
	private TextField texTime;

	@FXML
	private TextField texArray;

	@FXML
	private TextField texAbb;

	@FXML
	private TextField texList;

	public ControllerSponsor(MainSponsor mainSpon) {
		this.mainSpon = mainSpon;
	}
	

}

package atree.core.dialogs;

//import java.util.ArrayList;

public interface IMessageDialogShower {

	//public void showMessage(String message, String optionsLabel, ArrayList<String> options);
	public void openMissingQFLanCoreLibraryDialog(String link, String linkShort/*, ArrayList<String> paths,String OS*/,boolean linux);
	public void openSimpleDialog(String message);

}

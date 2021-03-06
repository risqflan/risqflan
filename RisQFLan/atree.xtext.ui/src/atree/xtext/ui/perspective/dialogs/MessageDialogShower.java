
package atree.xtext.ui.perspective.dialogs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import atree.xtext.ui.handler.MyMultiVeStAAnalysisExecutor;

public class MessageDialogShower implements atree.core.dialogs.IMessageDialogShower {

	private Shell parentShell;
	
	public MessageDialogShower(Shell parentShell){
		this.parentShell=parentShell;
	}
	
	@Override
	//public void showMessage(String message, String optionsLabel, ArrayList<String> options){
	public void openMissingQFLanCoreLibraryDialog(String link, String linkShort/*, ArrayList<String> paths,String OS*/,boolean linux){
		
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				//MissingQflanCoreJarDialog dialog = new MissingQflanCoreJarDialog(parentShell,link,linkShort, paths,OS);
				MissingAtreeCoreJarDialog dialog = new MissingAtreeCoreJarDialog(parentShell,link,linkShort/*, paths,OS*/,linux);
				dialog.open();
				//System.out.println("The jar is in: "+dialog.getJarFileLocation());
				BufferedWriter bw=null;
				try {
					bw = new BufferedWriter(new FileWriter(new File(MyMultiVeStAAnalysisExecutor.FILEWITHLIBRARYFILELOCATION)));
					bw.write(dialog.getJarFileLocation()+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					if(bw!=null){
						try {
							bw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
			}
		});
	}

	@Override
	public void openSimpleDialog(String message) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				MessageDialog dialog = new MessageDialog(parentShell, "Warning", null, message, MessageDialog.QUESTION, new String[]{"Ok"}, 0);
				dialog.open();
				/*MessageBox mb = new MessageBox(parentShell);
				mb.setText("Action required");
				mb.setMessage(message);
				mb.open();*/
			}
		});
		
	}
	
}

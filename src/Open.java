import java.awt.Desktop;
import java.io.File;

public class Open {
	public static boolean FOpen(){
		Desktop d = Desktop.getDesktop();
	    try {
	        if (OSDetector.isWindows()) {
	        	d.open(new File("C:\\"));
	            return true;
	        } else if (OSDetector.isLinux() || OSDetector.isMac()) {
	            d.open(new File("/users/"));
	            return true;
	        } else {
	            return false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace(System.err);
	        return false;
	    }
	}
}


package monitor;

import java.io.*;
import java.util.*;

public abstract class MonitorDeArchivoDeConfiguracion extends TimerTask{
      private long timeStamp;
      private File file;

      public MonitorDeArchivoDeConfiguracion( File file ) {
        this.file = file;
        this.timeStamp = file.lastModified();
      }

      public final void run() {
        long timeStamp = file.lastModified();

        if( this.timeStamp != timeStamp ) {
          this.timeStamp = timeStamp;
          onChange(file);
        }
      }

      protected abstract void onChange( File file );
}

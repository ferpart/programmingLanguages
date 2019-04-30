
package finalProject;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread {
    Buffer buffer;
    String operadores;
    int min;
    int max;
    int sleep;
    
    Producer(Buffer buffer, String operadores, int min, int max, int sleep) {
        this.buffer = buffer;
        this.operadores = operadores;
        this.min = min;
        this.max = max;
        this.sleep = sleep;
    }
    
    @Override
    public void run() {
        System.out.println("Running Producer...");
        Random r = new Random(System.currentTimeMillis());
        String product;
        
        while(true) {
            synchronized (this){ 
                product = "(";
                product += operadores.charAt(r.nextInt(operadores.length())) + " ";
                product += (r.nextInt(max-min+1)+min) + " ";
                product += (r.nextInt(max-min+1)+min); 
                product += ")";
                this.buffer.produce(product);
                //System.out.println("Producer produced: " + product);
                Buffer.print("Producer produced: " + product);

                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}

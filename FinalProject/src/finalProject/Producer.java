
package finalProject;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread {
    static int id = 0;
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
    public synchronized void run() {
        System.out.println("Running Producer...");
        Random r = new Random(System.currentTimeMillis());
        Operation product;
        String productOp;
        
        while(true) {
            synchronized (this){
                synchronized (buffer){
                    productOp = "(";
                    productOp += operadores.charAt(r.nextInt(operadores.length())) + " ";
                    productOp += (r.nextInt(max-min+1)+min) + " ";
                    productOp += (r.nextInt(max-min+1)+min); 
                    productOp += ")";
                    id++;
                    product = new Operation(productOp, id);
                    this.buffer.produce(product);
                    //System.out.println("Producer produced: " + product);
                    Buffer.print("Producer produced: " + productOp + " id: " + id);

                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    public void resetId (){
        this.id=0;
    }
}

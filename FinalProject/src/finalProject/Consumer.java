
package finalProject;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Consumer extends Thread {
    private Buffer buffer;
    private int sleep;
    private static int counter = 0;
    private GUIFrame guiReference;
    
    Consumer(Buffer buffer, int sleep, GUIFrame guiReference) {
        this.buffer = buffer;
        this.sleep = sleep;
        this.guiReference = guiReference;
    }
    
    @Override
    public synchronized void run() {
        System.out.println("Running Consumer...");
        Operation product;
        
        while(true) {
            synchronized (this){
                synchronized (buffer){
                    product = this.buffer.consume();
                    //System.out.println("Consumer consumed: " + product);
                    String result = null;
                    String productOp = product.getOperationString();
                    char value = productOp.charAt(1);
                    switch (value){
                        case '+' :
                            result = String.valueOf(Character.getNumericValue(productOp.charAt(3))+Character.getNumericValue(productOp.charAt(5)));
                            break;
                        case '-' :
                            result = String.valueOf(productOp.charAt(3)-productOp.charAt(5));
                            break;
                        case '*' :
                            result = String.valueOf(Character.getNumericValue(productOp.charAt(3))*Character.getNumericValue(productOp.charAt(5)));
                            break;
                        case '/' :
                            if(Character.getNumericValue(productOp.charAt(5))==0){
                                //JOptionPane.showMessageDialog(null, "Error: Can't divide by 0!", "DivideByZeroError", JOptionPane.ERROR_MESSAGE);
                                result = "Can't divide by 0";
                            }else{
                                result = String.valueOf((float)Character.getNumericValue(productOp.charAt(3))/Character.getNumericValue(productOp.charAt(5)));
                            }
                            break;
                    }
                    Buffer.print("Consumer consumed: " + result + " " + productOp + " id: " + product.getId());
                    guiReference.setTareasConsumer(product.getId(), productOp, result);
                    counter++;
                    guiReference.setOperationsCounter(counter);

                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    public void resetCounter (){
        this.counter=0;
    }
}

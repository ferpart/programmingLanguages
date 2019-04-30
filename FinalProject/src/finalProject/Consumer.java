
package finalProject;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Consumer extends Thread {
    Buffer buffer;
    int sleep;
    
    Consumer(Buffer buffer, int sleep) {
        this.buffer = buffer;
        this.sleep = sleep;
    }
    
    @Override
    public void run() {
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
                                JOptionPane.showMessageDialog(null, "Error: Can't divide by 0!", "DivideByZeroError", JOptionPane.ERROR_MESSAGE);
                            }else{
                                result = String.valueOf((float)Character.getNumericValue(productOp.charAt(3))/Character.getNumericValue(productOp.charAt(5)));
                            }
                            break;
                    }
                    Buffer.print("Consumer consumed: " + result + " " + productOp + " id: " + product.getId());

                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}

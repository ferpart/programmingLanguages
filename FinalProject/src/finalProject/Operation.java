/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

/**
 *
 * @author Fernando Partida
 */



public class Operation {
    private Integer id;
    private Integer result;
    private String operationString;
    
    public Operation(String operacion){
        
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getOperationString() {
        return operationString;
    }

    public void setOperationString(String operationString) {
        this.operationString = operationString;
    }
    
    
}

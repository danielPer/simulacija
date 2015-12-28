package view;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class bean {

    
    private List<Pumpa> lista;
    private int masterId;

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public int getMasterId() {
        
        return Integer.valueOf(getBindings().getAttributeBindings().get(2).toString());
    }


    public void setLista(List<Pumpa> lista) {
        this.lista = lista;
    }
    
    private int getVelicinaReda(int pumpaId){
        OperationBinding oper = getBindings().getOperationBinding("currentQueue");
        Map param = oper.getParamsMap();
        param.put("masterId", getMasterId());
        param.put("pumpaId", pumpaId);
        
        Object result = oper.execute();
        
        System.out.println("rezultat " + result );
        
        return Integer.valueOf(result.toString());
        //return 0;
    }
    
    private int getBrojPumpi(){
        
        return Integer.valueOf(getBindings().getAttributeBindings().get(1).toString());
    }

    public List<Pumpa> getLista() {
        
        lista = new ArrayList<Pumpa>();
        for(int i = 0 ; i < getBrojPumpi(); i++){
            Pumpa p1 = new Pumpa("Pumpa " + i, i);
            p1.setVelicinaReda(getVelicinaReda(i));
            lista.add(p1) ;   
        }
        
        return lista;
    }

    public void insertDolazak(ActionEvent e) {
        Object pumpaId = e.getComponent().getAttributes().get("pumpa");
        callProcedure("insertDolazak", pumpaId);
    }
    
    private String callProcedure(String name, Object pumpaId){
        OperationBinding oper = getBindings().getOperationBinding(name);
        Map param = oper.getParamsMap();
        param.put("masterId", getMasterId());
        param.put("pumpaId", pumpaId);
        
        Object result = oper.execute();
        
        System.out.println("rezultat " + result );
        return result.toString();
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String b4_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Last");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public void insertKraj(ActionEvent actionEvent) {
        Object pumpaId = actionEvent.getComponent().getAttributes().get("pumpa");
        callProcedure("insertKrajPunjenja", pumpaId);
    }

    public void insertOdlazak(ActionEvent actionEvent) {
        Object pumpaId = actionEvent.getComponent().getAttributes().get("pumpa");
        callProcedure("insertOdlazak", pumpaId);
    }
}

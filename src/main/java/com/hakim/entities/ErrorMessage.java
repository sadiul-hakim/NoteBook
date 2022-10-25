package com.hakim.entities;

import java.util.Optional;

/**
 *
 * @author Hakim
 */
public class ErrorMessage implements Message {
    private static Optional<String> message=Optional.ofNullable(null);

    public ErrorMessage() {
    }
    
    @Override
    public Optional<String> getMessage(){
        return message;
    }
    
    @Override
    public void setMessage(String msg){
        if(message.isPresent()){
            msg=msg+message.get();
        }
        message=Optional.of(msg);
    }
    
    @Override
    public void clear(){
        message=Optional.ofNullable(null);
    }
}

package com.hakim.entities;

import java.util.Optional;

/**
 *
 * @author Hakim
 */
public interface Message {
    Optional<String> getMessage();
    void setMessage(String msg);
    void clear();
}
